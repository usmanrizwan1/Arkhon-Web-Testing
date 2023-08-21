package com.arkhon.webtesting.stepdefs;

import com.arkhon.webtesting.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccessEducationTrainingStepDef {
    private HomePage homePage;
    private static WebDriver webDriver;


    @Before("@UserSettings")
    public void setup() {

    }

    @After("@UserSettings")
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario status =======> " + scenario.getStatus());
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) homePage.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }


    @Given("Admin is logged in")
    public void adminIsLoggedIn() {
        homePage = new HomePage(webDriver);
    }

    @When("Admin click on Education Training")
    public void adminClickOnEducationTraining() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.goToUserSettings();
    }

    @Then("Admin go to Education Training page")
    public void adminGoToEducationTrainingPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String actual = homePage.getCurrentUrl();
        String expected = "https://admin.arkhon.uat.arkhon.digital/#/en-GB/education-training";
        assertEquals(expected, actual);
        homePage.getWebDriver().close();
        homePage.getWebDriver().quit();
    }
}
