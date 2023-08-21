package com.arkhon.webtesting.utils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePart;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class LinkExtractor {

    private static final String APPLICATION_NAME = "Gmail API Example";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Arrays.asList(GmailScopes.GMAIL_READONLY, GmailScopes.MAIL_GOOGLE_COM);

    private static Credential getCredentials(final NetHttpTransport httpTransport) throws IOException {
        InputStream credentialsInputStream = LinkExtractor.class.getResourceAsStream("/credentials.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(credentialsInputStream));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();

        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
                .authorize("user");
    }

    public static String getLink() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        Gmail service = new Gmail.Builder(httpTransport, JSON_FACTORY, getCredentials(httpTransport))
                .setApplicationName(APPLICATION_NAME)
                .build();
        String link = null;

        String userId = "me";
        String query = "from:Portal@mail.uat.arkhon.digital subject:Welcome to Portal";
        ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();

        List<Message> messages = response.getMessages();

        // Iterate through the messages and retrieve the message ID
        for (Message message : messages) {
            String messageId = message.getId();

            // Retrieve the full message
            Message fullMessage = service.users().messages().get(userId, messageId).execute();

            // Get the message payload
            MessagePart payload = fullMessage.getPayload();

            // Find the part containing the HTML body
            String htmlBody = getHtmlBody(payload);

            link = extractLinkFromBody(htmlBody);

            // Delete the email
            service.users().messages().delete(userId, messageId).execute();

        }
        return link;
    }


    // Method to extract the HTML body from the message payload
    private static String getHtmlBody(MessagePart messagePart) {
        // Check if the current part is an HTML part
        if (messagePart.getMimeType().equals("text/html")) {
            // Retrieve the HTML body content
            String body = messagePart.getBody().getData();

            // Decode and return the HTML content
            return new String(Base64.getUrlDecoder().decode(body));
        }

        // If the current part is not an HTML part, recursively search for the HTML part
        if (messagePart.getParts() != null) {
            for (MessagePart part : messagePart.getParts()) {
                String htmlBody = getHtmlBody(part);
                if (htmlBody != null) {
                    return htmlBody;
                }
            }
        }

        // Return null if no HTML part was found
        return null;
    }


    // Method to extract the link from the message body
    private static String extractLinkFromBody(String body) {
        // Find the start and end index of the href attribute in the <a> element
        String hrefAttribute = "href=\"";
        int startIndex = body.indexOf(hrefAttribute);
        int hrefEndIndex = body.indexOf("\"", startIndex + hrefAttribute.length());

        // Extract the link from the href attribute
        if (startIndex != -1 && hrefEndIndex != -1) {
            return body.substring(startIndex + hrefAttribute.length(), hrefEndIndex);
        }

        return null;
    }

}
