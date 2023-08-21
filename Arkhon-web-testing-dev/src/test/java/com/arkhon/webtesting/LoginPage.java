package com.arkhon.webtesting;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToLoginPage() {
        webDriver.get("https://admin.arkhon.uat.arkhon.digital/#/en-GB/home");
    }

    }
