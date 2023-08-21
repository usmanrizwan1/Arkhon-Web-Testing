package com.arkhon.webtesting.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConfiguration {

    /*** Chrome webdriver Version 114.0.5735.199 */

    private static WebDriver driver;
    private static final String winChromeDriverPath = "src/test/resources/webdrivers/chromedriver.exe";
    private static final String macArmChromeDriverPath = "src/test/resources/webdrivers/mac_arm/chromedriver";
    private static final String macChromeDriverPath = "src/test/resources/webdrivers/chromedriver";


    // osTypes: win - for Windows; Mac - macOS build on Intel; Arm - macOS build on Silicon;
    public static WebDriver getChromeDriver(String osType) {

        if ("win".equals(osType))
            System.setProperty("webdriver.chrome.driver", winChromeDriverPath);
        else if ("mac".equalsIgnoreCase(osType))
            System.setProperty("webdriver.chrome.driver", macChromeDriverPath);
        else if ("arm".equalsIgnoreCase(osType))
            System.setProperty("webdriver.chrome.driver", macArmChromeDriverPath);
        else
            throw new IllegalArgumentException("Wrong OS Type");

        driver = new ChromeDriver();
        return driver;
    }

}
