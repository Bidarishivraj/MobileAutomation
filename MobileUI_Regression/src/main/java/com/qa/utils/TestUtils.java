package com.qa.utils;

import java.util.Random;

public class TestUtils {

    // Method to generate a random string of given length containing only alphabets
    public static String generateRandomAlphabets(int length) {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabets.length());
            sb.append(alphabets.charAt(index));
        }
        return sb.toString();
    }

    // Method to generate a random string of given length containing only numbers
    public static String generateRandomNumbers(int length) {
        String numbers = "0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(numbers.length());
            sb.append(numbers.charAt(index));
        }
        return sb.toString();
    }

    // Method to generate a random string of given length containing alphanumeric characters
    public static String generateRandomAlphaNumeric(int length) {
        String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphaNumeric.length());
            sb.append(alphaNumeric.charAt(index));
        }
        return sb.toString();
    }


    public static void eraseChromeAppData() {
        try {
            // Command to clear Chrome app data
            String command = "adb shell pm clear com.android.chrome";

            // Execute the command
            Process process = Runtime.getRuntime().exec(command);

            // Wait for the process to finish
            process.waitFor();

            System.out.println("Chrome app data cleared successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add more utility methods as per your requirement
    }
}
