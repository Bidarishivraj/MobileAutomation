//package com.qa.utils;
//
//import io.appium.java_client.remote.options.BaseOptions;
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class SampleTest {
//
//    private AndroidDriver driver;
//
////    @BeforeTest
////    public URL setUp() {
////        var options = new BaseOptions()
////                .amend("appium:automationName", "uiautomator2")
////                .amend("platformName", "Android")
////                .amend("appium:deviceName", "Pixel_7")
////                .amend("appium:app", "/Users/shivrajbidari/Documents/mobTest/qureapp.apk")
////                .amend("appium:ensureWebviewsHavePages", true)
////                .amend("appium:nativeWebScreenshot", true)
////                .amend("appium:newCommandTimeout", 3600)
////                .amend("appium:connectHardwareKeyboard", true);
////        return null;
////    }
////
////    private URL getUrl() {
////        try {
////            return new URL("http:127.0.0.1:4723");
////        } catch (MalformedURLException e) {
////            e.printStackTrace();
////        }
////
////
////        driver = new AndroidDriver(this.setUp(), options);
////        return null;
////    }
//
//
//
//
//    @Test
//    public void sampleTest() throws InterruptedException {
//        System.out.println("l");
//        setUpAppium();
//        Thread.sleep(1000);
//        System.out.println("finished");
//    }
//
//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
//
//
//    public  void setUpAppium() {
//        try {
//            final String URL_STRING = "http://127.0.0.1:4723/";
//            System.out.println("Started setAppium");
//            URL url = new URL(URL_STRING);
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("deviceName", "Pixel_7");
//            capabilities.setCapability("platformName", "Android");
//            capabilities.setCapability("automationName", "UiAutomator2");
//            capabilities.setCapability("app", "/Users/shivrajbidari/Documents/IdeaProjects/MobileUI_Regression/src/test/resources/apps/qureapp.apk");
//            driver = new AndroidDriver(url, capabilities);
//            System.out.println("Finished setAppium");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
