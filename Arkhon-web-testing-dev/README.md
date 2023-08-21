# Arkhon-web-testing
This project will make use of the Selenium for automating web testing and Cucumber for BDD. 

# Project Overview: Web Testing for Arkhon Web Portal

 

## Introduction

The purpose of this project is to perform comprehensive web testing for the Arkhon Web Portal, ensuring the application's functionality, security, and usability. The project involves creating a Jira board to manage user stories, conducting web testing for various features, and performing OAuth testing to assess the application's security.

 

## Objectives

The primary objectives of this project are as follows:

a. Functionality Testing: Verify that all features and functionalities of the Arkhon Web Portal work as intended and meet the specified requirements.

b. Usability Testing: Evaluate the user interface (UI) and user experience (UX) to ensure that the application is intuitive and easy to navigate.

c. Security Testing: Conduct OAuth testing to assess the application's security and ensure that proper authentication and authorization mechanisms are in place.

d. Jira Board Setup: Create a Jira board to manage and track user stories, and tasks related to the testing process efficiently.

## Overview of any internal goals/strategy for this project

The initial approach when it came to deciding on the internal goals of this project was to break down what was required from us as a testing team, before deciding on the best approach. The first initial goal that we had was to agree as a team on the main epics that we needed to test, before finally breaking those down into smaller, more bite sized, user stories that we could create automated tests for.

Once we were happy as a team that we had devised enough user stories to cover the requirements we started to develop our testing framework. In order to do this we decided on what strategic approach would be best to make our work most effective and cut down on the amount of time debugging or resolving the dreaded git merge conflicts.

Our first internal goal when it came to developing the project was to create a git repository on Github that we all had access to and that need two approvals for merging. Once this was set up, the work to achieving a next goal could begin, automating the login. However, this proved to be difficult than first thought (more details in the blockers section).  But eventually this was resolved.

Once we had the login working, we decided as a team what our next goals should be. In the end we decided to divided the main features up between us and each work on one feautre to increase the efficiency of our work.

As a team the strategy that decided would be best to approach this using an Agile methodology. To work in increments, figure out our goals for this increment, decided the best approach, complete them, and then come back to discuss the process and what could be improved.

#Summary of the tests that have been running:

##Test 1: Accessing the Education/Training Feature
This test ensures that the admin can access the Education/Training page. The scenario involves logging in as an admin, clicking on the Education/Training option, and verifying that the admin successfully reaches the Education/Training page. The test validates the expected URL against the actual URL to confirm proper navigation.

##Test 2: Accessing User Settings
This test validates the admin's ability to access the user settings. The scenario includes logging in as an admin, clicking on the User settings option, and ensuring that the admin is directed to the User settings page without any issues.

##Test 3: Login to Homepage
This test verifies the successful login to the homepage. The scenario involves opening the homepage and confirming that the user is logged in, ensuring a smooth authentication process.

##Test 4: Accessing a Client's Portfolio
This test focuses on accessing a client's portfolio through the Client Account Page. The scenario outlines the steps of navigating to the client account page, selecting a specific client account using the provided row ID, and validating that the client's portfolio is accessible. The test covers multiple scenarios by utilizing different row IDs.

The previously successful tests conducted on the Arkhon web portal can no longer achieve the desired results. This is due to recent changes made by the client to the UI format of the portal. The modified UI has resulted in a deviation from the original layout, rendering the existing locators ineffective in locating the necessary buttons for navigation.
To address this issue, it is necessary to update the locators used in the tests to align them with the new UI structure. This adjustment will enable the tests to locate and interact with the buttons accurately, ensuring proper navigation within the application.
Additionally, with the updated UI, a new pop-up has been introduced. This pop-up needs to be handled appropriately in the tests to bypass it.
Furthermore, it has been identified that the User Setting button is not functioning as expected.

## Blockers

Issues with Authorization
-	The team faced issues with accessing the portal because only 3 members were given Authorization to log on from the start and were not able to add the rest of the team for an extended period. 
-	With a majority of the team left without access it was difficult to even write user stories for the portal, attempt to manually test and explore which features would be best to automate, or begin writing automated tests.
-   We are still unable to login to the portal using any account for a user that is not an admin eg. a partial-admin, so we cannot write tests for these users

Automating the sign-in process
-	Automation of the login process was difficult because signing in required 2-factor authentication (verification email) which is something we spent a lot of time researching to find solutions because this blocker was key to getting resolved (without getting around this blocker it would not be possible to automate testing)

Many of the existing features were either disabled or not functioning properly enough to write automated tests for.
-	Buttons that did nothing
-	Many errors showing when attempting to manually test any feature
-	Many of the visuals on the page like charts/graphs were either not displaying properly or there was something wrong with the data that they were made to display.

Many of the team members were out of the office for a week immediately after we managed to automate the sign-in process so we were not able to make as much progress with writing automated tests once we could access the portal using Selenium.

The automated tests that were written had to be modified almost immediately after the UI was updated.

### Issues related to UI changes/Updates to the web portal

As tests were being developed, there were recent major updates to the UI and web portal.  Changes include:

- a disclaimer that needs to be checked when initially signing into the portal and after not using the portal for a period of time.  

- updates to functionality of certain transactions. E.g. buying and selling crypto for a client 

- location of the navigation bar 

- page layout 

- table layout 

- some features have been added/removed 

This means that some tests written previously need to be updated to work with the new layout. Additionally some tests developed have not been included in the project due to no longer working with the new design.

## Scope

The scope of this project includes:

a. Feature Testing: Testing all major and minor features of the Arkhon Web Portal, including but not limited to registration, login, user profile management, content submission, search functionality, and account settings.

b. Compatibility Testing: Ensuring that the web application is compatible with different web browsers and operating systems.

c. Performance Testing: Evaluating the application's responsiveness and performance under various load conditions.

d. OAuth Testing: Assessing the OAuth implementation to verify the security and proper access controls.

 

## Deliverables

The following deliverables are expected from the project:

a. Jira Board: A fully set up Jira board with well-defined user stories, and test cases.

b. Test Plan: Detailed test plan outlining the testing approach, testing types, and testing tools to be used.

c. Test Cases: Comprehensive test cases covering all the features and test scenarios.

 

## Methodology

The project will follow an Agile testing methodology to ensure flexibility and adaptability to changes. Sprints will be used to manage the testing process effectively.

 

## Timeline

The project is estimated to be completed in [time period], divided into weekly sprints. A detailed project timeline will be established during the project planning phase.

 

## Risks and Mitigations

Potential risks and their mitigation strategies will be identified during the project planning phase to minimize the impact on the project's success.

 

## Communication

Regular communication will be maintained between the testing team and project stakeholders to ensure alignment and prompt issue resolution.

# User Stories and Epics

_Our user stories are split in five epics which are centred around.._

1. _Managing Accounts_
2. _Transferring Funds_
3. _Trading capabilities_
4. _User Access and Accounts_
5. _Logging in_
6. _Home Page_

**Managing Accounts:**

The two user stories for this epic are..

- Removing Accounts
- Adding New Accounts

\*_account in this sense relates to a holding of currency, not a user account._

**Transferring Funds:**

The two user stories for this epic are..

- Deleting Transfers
- Transferring Own Funds Between Accounts

**Trading Capabilities:**

The four user stories for this epic are..

- Adding a Trade Break
- Buying Cryptocurrency
- Selling Cryptocurrency
- View Transaction History

**Logging In:**

The two user store is for this epic are..

- Signing in
- Signing out

**Homepage:**

The two user stories for this epic are..

- Accessing User Settings
- Viewing Trad Data on Homepage

 # Automatic login process

## How it works
The application flow would be as follows: 

1. The `getLink` method is called. 
2. It generates a `Credential` object by calling the `getCredentials` method. 
3. It initializes a Gmail service using the `Credential` object. 
4. It queries the user's mailbox for emails that are from "Portal@mail.uat.arkhon.digital" and has the subject "Welcome to Portal". 
5. It then iterates over each found email. 
6. For each email, it retrieves the full email, then the payload. 
7. It extracts the HTML body by calling the `getHtmlBody` method. 
8. It extracts a hyperlink from the HTML body by calling the `extractLinkFromBody` method. 
9. It deletes the processed email. 
10. Finally, it returns the extracted link.
11. When `logIn` method is called, it first loads the properties from a file named "admin.properties" and gets the email from there.
12. It initializes the driver instance using the `WebDriverConfiguration.getChromeDriver` method and sets an implicit wait of 10 seconds.
13. It navigates to the login URL (https://admin.arkhon.uat.arkhon.digital/) of the application using `driver.get`.
14. If the user is already logged in, determined by the `isLoggedIn` method, it simply returns the driver instance with its state.
15. And will start to execute test scripts, otherwise, it proceeds with the login process. 
16. Clicking the sign-in button then enter the email (“testing.sparta207@gmail.com”) and click the submit button.
17. It then sleeps for 5 seconds to wait for the email to be sent.
18. It retrieves the link from the email by calling the `LinkExtractor.getLink` method.
19. It navigates to the retrieved link using `driver.get`.
20. Finally, it returns the driver instance with its state and run test scripts.  

# Code Analysis

This README provides detailed explanations of two Java classes: `LinkExtractor` and `LoginWithLinkTest`. These classes are used for interacting with the Gmail API and automating web login operations.

## `LinkExtractor`

This class uses the Gmail API to access a user's Gmail account, extract a particular link from an email, and delete the email. It's used in scenarios where, for instance, a confirmation or activation link needs to be automatically extracted from an email and used in the next steps of an automation process.

Here is a brief explanation of the key methods in the `LinkExtractor` class:

- `getCredentials()`: This method takes care of loading the `credentials.json` file and setting up the `GoogleAuthorizationCodeFlow` object, which is necessary for the OAuth2 authentication with Gmail API. 

- `getLink()`: This method uses the `getCredentials()` method to authenticate and create a `Gmail` service. It then interacts with the Gmail API to query a user's Gmail account, read emails that match the query, extract a link from the email body, delete the email, and return the link. 

- `getHtmlBody()`: This recursive method takes a `MessagePart` (a part of an email message) and returns the HTML body of the message. 

- `extractLinkFromBody()`: This method takes a string (the HTML body of an email message), and extracts a link from it. It then returns the link.

## `LoginWithLinkTest`

This class is part of a test automation framework, likely for a web application. It uses Selenium WebDriver to automate the process of logging into an application via a web interface. It includes the process of extracting a confirmation or activation link from an email using the `LinkExtractor` class and navigating to that link. 

Here is a brief explanation of the key methods in the `LoginWithLinkTest` class:

- `logIn()`: This method handles the overall login process. It starts by reading an email address from a properties file, then it initiates the WebDriver and navigates to the login page. If not logged in already, it performs login actions (clicking a button, entering the email, clicking submit), extracts the confirmation link from the email using `LinkExtractor`, and navigates to the link.

- `isLoggedIn()`: This helper method checks whether the user is already logged in based on the current URL.

## Gmail API Credentials 

The Gmail API, like many Google APIs, uses OAuth 2.0 for authentication and authorization. OAuth 2.0 is a standard protocol that allows third-party applications to access user data without needing to know the user's password. Instead, applications use tokens, which grant limited access to the user's data for a specific time period and set of operations.

To use the Gmail API, an application needs to have the necessary credentials, which are stored in a client secrets file and a credentials file. 

- **Client Secrets**: This file is downloaded from the Google API Console and contains the client ID and client secret for your application. It's used to authenticate your application with Google and to request access tokens.

- **credentials.json**: This file is where your application's credentials (including the access and refresh tokens) are stored after the user has granted your application permission to access their Gmail account. By storing these credentials, your application can authenticate itself and the user in the future without requiring the user to grant permission again.

The `credentials.json` file needs to be updated whenever your application needs a new access token. Access tokens are time-limited, so they need to be refreshed regularly. The refresh token stored in `credentials.json` is used to obtain new access tokens without the user needing to re-authorize your application.


## Conclusion

The initial project setup has been completed. This includes:

- The framework layout, we have used the POM for this 

- Functionality to automatically login to the portal through the Auth0 email registration process 

- Setting up Chromedriver so the same Auth0 token is used while tests are being run, so the email registration isn’t repeated unnecessarily.  

- Ensuring that the framework is able to run on different systems 

Feature development was initially slowed due to problems with logging into the portal, and features that have been written have been affected by recent changes to the UI. Functioning tests have been included into the project, however with updates to the UI being made these may need to be reviewed and adjusted to work with any new layout.

As well as adjusting for changes to the portal, further work includes creating a full set of features to test all main functionality, adjust code so tests can be run on all main browsers and include tests for users other than admins. This is covered in more detail in the next section. 

