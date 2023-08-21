package com.arkhon.webtesting;

import com.arkhon.webtesting.utils.LinkExtractor;
import com.arkhon.webtesting.utils.Routes;
import com.arkhon.webtesting.utils.WebDriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.Properties;

public class LoginWithLinkTest {
    private static WebDriver driver;
    private static Properties properties = new Properties();
    private static final By signInButton = new By.ByXPath("//button[@type='button']");
    private static final By emailField = new By.ByXPath("//input[@id='1-email']");
    private static final By submitButton = new By.ByXPath("//button[@id='1-submit']");
     private static final By welcomeBackH1 = new By.ByXPath("(//h1[normalize-space()='Welcome back'])[1]");

    public static WebDriver logIn() {
        String email, link;

        try {
            properties.load(new FileReader("src/test/resources/admin.properties"));
            email = properties.getProperty("email");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver = WebDriverConfiguration.getChromeDriver("mac");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Routes.getLoginURL());

        if (isLoggedIn()) {
            return driver;
        } else {
            driver.findElement(signInButton).click();
            driver.findElement(emailField).sendKeys(email);
            driver.findElement(submitButton).click();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                link = LinkExtractor.getLink();
            } catch (GeneralSecurityException | IOException e) {
                throw new RuntimeException(e);
            }

            driver.get(link);
        }

        return driver;
    }

    private static boolean isLoggedIn() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if ("https://admin.arkhon.uat.arkhon.digital/#/en-GB/home".equalsIgnoreCase(driver.getCurrentUrl())) {
            return true;
        }
        return false;
    }

}
