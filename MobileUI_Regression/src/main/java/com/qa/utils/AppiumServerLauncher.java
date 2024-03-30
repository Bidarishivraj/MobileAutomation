package com.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.URL;

public class AppiumServerLauncher {
    public static AppiumDriverLocalService service;
    static String logFilePath = "/Users/shivrajbidari/Documents/IdeaProjects/MobileUI_Regression/src/test/java/com/qa/serverLogs"; // Specify the path for your log file



    public static void configServer(){
        String appiumPath = "/opt/homebrew/bin/appium"; // Adjust the path as per your Appium installation
         //logFilePath = "/Users/shivrajbidari/Documents/IdeaProjects/MobileUI_Regression/src/test/java/com/qa/serverLogs"; // Specify the path for your log file

        // Build the Appium service
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumPath))
                .usingAnyFreePort()
                .withLogFile(new File(logFilePath)); // Redirect logs to the specified file

         service = AppiumDriverLocalService.buildService(builder);
        System.out.println("***&&&&&&&&   "+service);
    }


    public static URL stratServer() {
        configServer();
        service.start();
        // Print the server URL to the console
        System.out.println("Appium server started at: " + service.getUrl());
        return service.getUrl();

    }

    public static void stopServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium server stopped.$$$$$");
            System.out.println("View the Appium server logs at: " + "/Users/shivrajbidari/Documents/IdeaProjects/MobileUI_Regression/src/test/java/com/qa/serverLogs");

           // String logFilePath = "/Users/shivrajbidari/Documents/IdeaProjects/MobileUI_Regression/src/test/java/com/qa/serverLogs";


            // Convert the log file path to a file URL
            String fileUrl = new File(logFilePath).toURI().toString();

            // Print the URL to the console
            System.out.println("View the Appium server logs at: " + fileUrl);
        }
    }
}
