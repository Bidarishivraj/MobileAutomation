package com.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.HashMap;

public class ServerManager {
private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
//TestUtils utils = new TestUtils(); this method is for logs

    public AppiumDriverLocalService getServer(){
        return server.get();
    }


    public void startServer(){
        System.out.println("in server");
        AppiumDriverLocalService server = MacGetAppiumService();
        server.start();
        if(server==null || !server.isRunning()){
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. Abort");
        }
        //server.clearOutPutStreams(); This method will clear the logs from terminal
        this.server.set(server);
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

    //Below method is for windows
//    public AppiumDriverLocalService WindowsGetAppiumService() {
//        GlobalParams params = new GlobalParams();
//        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingAnyFreePort()
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                .withLogFile(new File(params.getPlatformName() + "_"
//                        + params.getDeviceName()+ File.separator + "Server.log")));
//    }

    //Below method is for MAC
    public AppiumDriverLocalService MacGetAppiumService() {
        GlobalParams params = new GlobalParams();
        HashMap<String, String> environment = new HashMap<String, String>();
        environment.put("PATH", "/Users/shivrajbidari/Library/Android/sdk/emulator /Users/shivrajbidari/Library/Android/sdk/tools /Users/shivrajbidari/Library/Android/sdk/tools/bin /Users/shivrajbidari/Library/Android/sdk/platform-tools /Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home/bin /Users/shivrajbidari/anaconda3/bin /Users/shivrajbidari/anaconda3/condabin /opt/homebrew/bin /opt/homebrew/sbin /usr/local/bin /usr/bin /bin /usr/sbin /sbin" + System.getenv("PATH"));
        environment.put("ANDROID_HOME", "/Users/shivrajbidari/Library/Android/sdk");
        environment.put("JAVA_HOME", "/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home");
        System.out.println("Server here");
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/lib/main.js"))
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withEnvironment(environment));
//                .withLogFile(new File(params.getPlatformName() + "_"
//                        + params.getDeviceName() + File.separator + "Server.log")));
    }


}


//////////////////////////////////////////

