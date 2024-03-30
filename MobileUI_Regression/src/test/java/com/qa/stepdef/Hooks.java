package com.qa.stepdef;

import com.qa.utils.AppiumServerLauncher;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static com.qa.utils.AppiumServerLauncher.service;


public class Hooks {
    public TestUtils testutils;
    public AppiumServerLauncher appiumserverlaunch;
    public static AppiumDriver appiumDriver;

    @Before
    public void initialize() throws Exception {
        //URL url = appiumserverlaunch.stratServer();
//        appiumserverlaunch.stratServer();



        System.out.println("in Capability block");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //desiredCapabilities.setCapability("fullReset",true);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Pixel 7");
        desiredCapabilities.setCapability("app", "/Users/shivrajbidari/Documents/IdeaProjects/MobileUI_Regression/src/test/resources/apps/qureapp.apk");

        URL url = new URL("http://127.0.0.1:4723/");
//        URL url = appiumserverlaunch.stratServer();
        appiumDriver = new AppiumDriver(url, desiredCapabilities);
        testutils.eraseChromeAppData();


    }

    @After
    public void quit() {
        //appiumDriver.quit();
        if (appiumDriver != null) {
            appiumDriver.quit();
        }

        appiumserverlaunch.stopServer();

//        DriverManager driverManager = new DriverManager();
//        if(driverManager.getDriver()!=null){
//            driverManager.getDriver().quit();
//            driverManager.setDriver(null);
//        }
//
//        ServerManager servermanager = new ServerManager();
//        if(servermanager.getServer() !=null){
//            servermanager.getServer().stop();
//        }


    }


//    GlobalParams params= new GlobalParams();

//    params.initializeGlobalParams();
    //ThreadContext.put("ROUTINGKEY", params.getPlatformName()+ "_"+ params.getDeviceName());
    //        new SampleTest().sampleTest();
//            new SampleTest.java().setUpAppium();
//            new ServerManager().startServer();
//            new DriverManager(). initializeDriver();


}
