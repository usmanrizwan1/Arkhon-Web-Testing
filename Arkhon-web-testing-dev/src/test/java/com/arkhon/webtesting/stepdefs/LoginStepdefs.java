package com.arkhon.webtesting.stepdefs;

import com.arkhon.webtesting.LoginWithLinkTest;
import com.arkhon.webtesting.pages.HomePage;
import com.arkhon.webtesting.utils.WebDriverConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class loginStepdefs {

    private static WebDriver webDriver;
    private HomePage homePage;

    @Before("@Login")
    public void setup() {
        webDriver = WebDriverConfiguration.getChromeDriver("mac");
    }

    @After("@Login")
    public void close(){
        webDriver.close();
        webDriver.quit();
    }


    @Given("I go to the homepage")
    public void iGoToTheHomepage() {
        homePage = new HomePage();
    }

    @Then("I should be logged into the homepage")
    public void iShouldBeLoggedIntoTheHomepage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals("https://admin.arkhon.uat.arkhon.digital/#/en-GB/home", webDriver.getCurrentUrl());
    }
}
