package com.arkhon.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReconciliationPage {

    WebDriver webDriver;

    private By addTradeBreakButton = new By.ById(":rk:");
    private By tradeBreakTable = new By.ByCssSelector("[data-testid = FEES_TABLE]");
    private By tradeBreakTableRowClass = new By.ByClassName("ag-center-cols-clipper");
    private By tradeBreakTableFirstRow = new By.ByCssSelector("[row-index = \"0\"]");

    public ReconciliationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public AddTradeBreakPage clickAddTradeBreak(){
        webDriver.findElement(addTradeBreakButton).click();
        return new AddTradeBreakPage(webDriver);
    }

    public boolean checkTradeBreakEnteredCorrectly(String tradeBreakType, String quantity, String currency, String reason, String platform, String comment){
        WebElement feesTable = webDriver.findElement(tradeBreakTable);
        WebElement rowClass = feesTable.findElement(tradeBreakTableRowClass);
        String row = rowClass.findElement(tradeBreakTableFirstRow).getText().toLowerCase();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Date currentDate = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        String formattedDate = sdf.format(currentDate).toLowerCase();


        if(row.contains(formattedDate)
                && row.contains(tradeBreakType)
                && row.contains(quantity)
                && row.contains(currency)
                && row.contains(reason)
                && row.contains(platform)
                && row.contains(comment)){
            return true;
        }
        return false;
    }
}
