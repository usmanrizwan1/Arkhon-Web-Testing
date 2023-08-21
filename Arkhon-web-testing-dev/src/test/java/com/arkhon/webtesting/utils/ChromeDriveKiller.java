package com.arkhon.webtesting.utils;

import java.io.IOException;

public class ChromeDriveKiller {
    public static void main(String[] args) {
        try {
            // Execute a command to close all instances of chromedriver.exe
            Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

            System.out.println("Successfully closed all instances of chromedriver.exe");
        } catch (IOException e) {
            System.err.println("Error closing chromedriver.exe: " + e.getMessage());
        }
    }
}
