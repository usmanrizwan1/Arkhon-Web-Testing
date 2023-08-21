package com.arkhon.webtesting.stepdefs;

import com.arkhon.webtesting.pages.ClientAccountPage;
import com.arkhon.webtesting.pages.ClientPortfolioPage;
import com.arkhon.webtesting.pages.HomePage;
import com.arkhon.webtesting.utils.WebDriverConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ViewClientPortfolioStepdefs {

    private static WebDriver webDriver;
    private HomePage homePage;
    private ClientAccountPage clientAccountPage;
    private ClientPortfolioPage clientPortfolioPage;
    private String clientName;


    @Before("@view-client-portfolio")
    public void setup() {
        webDriver = WebDriverConfiguration.getChromeDriver("mac");
    }

    @After("@view-client-portfolio")
    public void close(){
        webDriver.close();
        webDriver.quit();
    }

    @Given("I am on the client account page")
    public void iAmOnTheClientAccountPage() {
        homePage = new HomePage();
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.checkLoggedIn();
        webDriver = homePage.getWebDriver();
        clientAccountPage = homePage.goToClientAccountPage();
    }

    @When("I click on a client account in the table with row id {string}")
    public void iClickOnAClientAccountInTheTableWithRowId(String rowNumber) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clientName = clientAccountPage.getClientNameFromTable(rowNumber);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clientPortfolioPage = clientAccountPage.goToClientPortfolioFromTable(rowNumber);

    }

    @Then("I should view the clients portfolio")
    public void iShouldViewTheClientsPortfolio() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String displayedString = clientPortfolioPage.getClientDetailsString();
        System.out.println( clientName + " / " + displayedString);
        Assertions.assertTrue(displayedString.contains(clientName));

    }
}
