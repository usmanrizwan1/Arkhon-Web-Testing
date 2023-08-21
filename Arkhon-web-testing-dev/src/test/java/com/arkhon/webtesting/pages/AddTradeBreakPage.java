package com.arkhon.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTradeBreakPage {

    private WebDriver webDriver;

    private By tradeBreakTypeSelect = new By.ByXPath("/html/body/div/div/div/div[2]/div[2]/div/div[1]/div/div/div");
    private By currencyTypeSelect = new By.ByXPath("/html/body/div/div/div/div[2]/div[2]/div/div[3]/div/div/div");
    private By platformSelect = new By.ByXPath("/html/body/div/div/div/div[2]/div[2]/div/div[4]/div/div/div");
    private By reasonSelect = new By.ByXPath("/html/body/div/div/div/div[2]/div[2]/div/div[5]/div/div/div");
    private By tradeBreakAmountInput = new By.ByXPath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div[2]/div/fieldset/div/input");
    private By commentInput = new By.ById(":r14:");
    private By createTradeBreakButton = new By.ById(":r13:");
    private By confirmTradeBreakYesButton = new By.ByXPath("/html/body/div[2]/div[3]/div[2]/button[2]");

    public AddTradeBreakPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private By selectItemByDataValue(String dataValue) {
        return new By.ByCssSelector("[data-value="+ dataValue +"]");
    }

    public void fillInTradeBreakDetails(String tradeBreakType, String amount, String currencyType, String reasonType, String testComment, String platformDataValue){

        webDriver.findElement(tradeBreakTypeSelect).click();
        webDriver.findElement(selectItemByDataValue(tradeBreakType)).click();
        webDriver.findElement(tradeBreakAmountInput).sendKeys(amount);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriver.findElement(currencyTypeSelect).click();
        webDriver.findElement(selectItemByDataValue(currencyType)).click();
        webDriver.findElement(platformSelect).click();
        webDriver.findElement(selectItemByDataValue("\"" + platformDataValue + "\"")).click();
        webDriver.findElement(reasonSelect).click();
        webDriver.findElement(selectItemByDataValue("\""+reasonType+ "\"")).click();
        webDriver.findElement(commentInput).sendKeys(testComment);

    }

    public void confirmTradeBreak(){
        webDriver.findElement(createTradeBreakButton).click();
        webDriver.findElement(confirmTradeBreakYesButton).click();
    }

}
