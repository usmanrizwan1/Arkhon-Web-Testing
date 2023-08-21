package com.arkhon.webtesting.stepdefs;

import com.arkhon.webtesting.pages.AddTradeBreakPage;
import com.arkhon.webtesting.pages.HomePage;
import com.arkhon.webtesting.pages.ReconciliationPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AddTradeBreakStepdefs {

    private static WebDriver webDriver;
    private HomePage homePage;
    private ReconciliationPage reconciliationPage;
    private AddTradeBreakPage addTradeBreakPage;

    @After("@add-trade-break")
    public void close(){
        webDriver.close();
        webDriver.quit();
    }

    @Given("I am on the reconciliation page")
    public void iAmOnTheReconciliationPage() {
        homePage = new HomePage();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.checkLoggedIn();
        webDriver = homePage.getWebDriver();
        reconciliationPage = homePage.goToReconciliationPage();

    }

    @When("I click on the add trade break button")
    public void iClickOnTheAddTradeBreakButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addTradeBreakPage = reconciliationPage.clickAddTradeBreak();
    }

    @And("I fill in trade break details trade break type {string} amount {string} currency type {string} reason type {string} platform {string} comment {string}")
    public void iFillInTradeBreakDetailsTradeBreakTypeAmountCurrencyTypeReasonTypePlatformComment(String tradeBreakType, String amount, String currencyType, String reasonType, String platform, String comment) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String platformDataValue;
        if("talos".equalsIgnoreCase(platform)){
            platformDataValue = "12";
            addTradeBreakPage.fillInTradeBreakDetails(tradeBreakType,amount,currencyType,reasonType,comment, platformDataValue);
        }

    }

    @And("I confirm the trade break should be added")
    public void iConfirmTheTradeBreakShouldBeAdded() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addTradeBreakPage.confirmTradeBreak();
    }

    @Then("I should see that the trade break has been added to the trade break table with correct date and trade break type {string} amount {string} currency type {string} reason type {string} platform {string} comment {string}")
    public void iShouldSeeThatTheTradeBreakHasBeenAddedToTheTradeBreakTableWithCorrectDateAndTradeBreakTypeAmountCurrencyTypeReasonTypePlatformComment(String tradeBreakType, String amount, String currencyType, String reasonType, String platform, String comment) {
        boolean tradeBreakEntryCorrect = reconciliationPage.checkTradeBreakEnteredCorrectly(tradeBreakType.toLowerCase(),amount,currencyType.toLowerCase(),reasonType.toLowerCase(),platform.toLowerCase(),comment.toLowerCase());
        Assertions.assertTrue(tradeBreakEntryCorrect);
    }
}
