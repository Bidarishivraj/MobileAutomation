package com.qa.utils;

public class GlobalParams {
    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
    private static ThreadLocal<String> webkitDebugProxyport = new ThreadLocal<String>();

    public void setPlatformName(String platformName1) {
        platformName.set(platformName1);
    }

    public String getPlatformName() {
        return platformName.get();
    }

    public void setUdid(String udid1) {
        udid.set(udid1);
    }

    public String getUdid() {
        return udid.get();
    }

    public void setDeviceName(String deviceName1) {
        deviceName.set(deviceName1);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setSystemPort(String systemPort1) {
        deviceName.set(systemPort1);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setChromeDriverPort(String chromeDriverPort1) {
        deviceName.set(chromeDriverPort1);
    }

    public String getChromeDriverPort() {
        return chromeDriverPort.get();
    }

    public void setWdaLocalPort(String wdaLocalPort1) {
        deviceName.set(wdaLocalPort1);
    }

    //These below Methods are for ios
//    public String getWdaLocalPort() {
//        return wdaLocalPort.get();
//    }
//
//    public void setWebkitDebugProxyport(String webkiteDbugProxyport1) {
//        deviceName.set(webkiteDbugProxyport1);
//    }
//
//    public String getWebkitDebugProxyport() {
//        return webkitDebugProxyport.get();
//    }


    public void initializeGlobalParams() {
        GlobalParams params = new GlobalParams();
        params.setPlatformName(System.getProperty("platformName", "Android"));
        params.setUdid(System.getProperty("udid", "emulator-5554"));
        params.setDeviceName(System.getProperty("deviceName", "Pixel_7"));

        switch (params.getPlatformName()) {
            case "Android":
                params.setSystemPort(System.getProperty("systemPort", "10000"));
                params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
                break;
//            case "ios":
//                params.setWdaLocalPort(System.getProperty("WdaLocalPort", "10001"));
//                params.setWebkitDebugProxyport(System.getProperty("webkitDebugProxyport", "110001"));
//                break;

            default:
                throw new IllegalStateException("Invalid Platform Name");
        }

    }


}

