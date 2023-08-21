package com.arkhon.webtesting.pages;

import com.arkhon.webtesting.LoginWithLinkTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver webDriver;
    private By loginButton = new By.ByXPath("//*[@id=\"root\"]/div/div/div[4]/div/div/button");
    private By clientPageLink = new By.ByXPath("//*[@id=\"root\"]/div[1]/div/div[1]/div/div[2]/div/div/div[2]/div/div");
    private By reconciliationPageLink = new By.ByXPath("//*[@id=\"root\"]/div[1]/div/div[1]/div/div[2]/div/div/div[3]/div/div");

    private final By headerMenuSelector = new By.ByXPath("//*[name()='path' and contains(@d,'M0.0801124')]");

    public HomePage(WebDriver webDriver) {
        goToHomePage();
    }


    private void goToHomePage() {
        webDriver = LoginWithLinkTest.logIn();
    }

    public void checkLoggedIn(){
        String url = webDriver.getCurrentUrl();
        if("https://admin.arkhon.uat.arkhon.digital/#/".equalsIgnoreCase(url)){
            webDriver.findElement(loginButton).click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ClientAccountPage goToClientAccountPage(){
        webDriver.findElement(clientPageLink).click();
        return new ClientAccountPage(webDriver);
    }


    public ReconciliationPage goToReconciliationPage(){
        webDriver.findElement(reconciliationPageLink).click();
        return new ReconciliationPage(webDriver);
    }

    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void goToUserSettings() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.cssSelector(".MuiTypography-root.MuiTypography-h5.css-rfdqlv"))));
        menuButton.click();
        WebElement educationButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("(//p[normalize-space()='Education/Training'])[1]"))));
        educationButton.click();
    }
}
