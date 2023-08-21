package com.arkhon.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientPortfolioPage {

    private WebDriver webDriver;

    private By clientNameDisplay = new By.ByXPath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/p[2]");

    public ClientPortfolioPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getClientDetailsString(){
        return webDriver.findElement(clientNameDisplay).getText();
    }
}
