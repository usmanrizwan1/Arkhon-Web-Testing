package com.arkhon.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientAccountPage {

    private WebDriver webDriver;

    public ClientAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private By selectPortfolioLinkInTable(String rowNumber){
        return new By.ByXPath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div["+ rowNumber + "]/div[1]/div/span/p/div/a");
    }

    public ClientPortfolioPage goToClientPortfolioFromTable(String rowNumber){
        webDriver.findElement(selectPortfolioLinkInTable(rowNumber)).click();
        return new ClientPortfolioPage(webDriver);
    }

    public String getClientNameFromTable(String rowNumber){
        return webDriver.findElement(selectPortfolioLinkInTable(rowNumber)).getText();
    }

}
