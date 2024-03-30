package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

public class DriverManager {

    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

   // TestUtils utils = new TestUtils();

    public AppiumDriver getDriver(){
        return  driver.get();

    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver =null;
        GlobalParams params = new GlobalParams();
        Propertymanager props = new Propertymanager();

        if(driver==null){
            try {
                switch (params.getPlatformName()){
                    case "Android":
                        driver = new AppiumDriver(new ServerManager().getServer().getUrl(),new CapabilitiesManager().getCaps());
                        break;
                    case "ios":
                        driver= new IOSDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());

                }
                if(driver==null){
                    throw new Exception("Driver is null. Abourt!!");
                }
               // utils.log.info("Driver is initialized");
                this.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                //utils.log().fatal("Driver initialization failer.. Abourt!!" + e.toString());
                throw e ;

            }

        }

    }

}
