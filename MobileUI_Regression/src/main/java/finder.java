import java.io.File;
import java.io.File;

public class finder {



//public class AppiumExecutableLocator {

    public static String findAppiumExecutable() {
        // Get the absolute path to the current working directory
        String projectDir = System.getProperty("user.dir");

        // Construct the path to the node_modules/.bin directory
        String binDir = projectDir + File.separator + "node_modules" + File.separator + ".bin";

        try {
            // Check if the node_modules/.bin directory exists
            File binDirectory = new File(binDir);
            if (binDirectory.exists() && binDirectory.isDirectory()) {
                // List the contents of the node_modules/.bin directory
                String[] files = binDirectory.list();

                // Check if the 'appium' executable exists
                for (String fileName : files) {
                    if (fileName.equals("appium")) {
                        // Return the absolute path to the 'appium' executable
                        return binDir + File.separator + "appium";
                    }
                }
            }

            // Return null if the 'appium' executable is not found
            return null;
        } catch (Exception e) {
            // Handle any errors that occur during file system operations
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage: Retrieve the location of the Appium executable
        String appiumExecutable = findAppiumExecutable();
        if (appiumExecutable != null) {
            System.out.println("Appium executable found at: " + appiumExecutable);
        } else {
            System.out.println("Appium executable not found.");
        }
    }
}

