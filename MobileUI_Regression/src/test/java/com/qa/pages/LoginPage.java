package com.qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en_scouse.An;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.utils.TestUtils;
import io.appium.java_client.remote.SupportsContextSwitching;



import java.time.Duration;
import java.util.Set;

import static com.qa.utils.DriverManager.driver;
import io.appium.java_client.AppiumDriver;



public class LoginPage {


    public TestUtils testutils;
    WebDriverWait wait;

    public LoginPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
        this.wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
    }

    public AppiumDriver appiumDriver;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Login']")
    public WebElement loginBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='email']")
    public WebElement usernameTxtfFld;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='password']")
    public WebElement passwordTxtfFld;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='search-region']")
    public WebElement regionDropdown;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='kc-login']")
    public WebElement signin;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Open menu']")
    public WebElement settingsBtn;

    @AndroidFindBy(xpath = "/android.widget.TextView[@text=\"Ignore\"]\n")
    public WebElement ignoreBtm;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"__next\"]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button")
    public WebElement addBtn;

    //android.view.View[@resource-id="__next"]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"patientId\"]")
    public WebElement patientID;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"name\"]")
    public WebElement patientName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"age\"]")
    public WebElement patientAge;

//    @AndroidFindBy(xpath = " //android.widget.Button[@resource-id=\"headlessui-listbox-button-:rh:\"]")
//    public WebElement patientGender;

    @AndroidFindBy(uiAutomator = "//android.widget.Button[@resource-id=\"headlessui-listbox-button-:rh:\"]")
    public WebElement patientGender;

    //android.widget.Button[@resource-id="headlessui-listbox-button-:rh:"]

//    @AndroidFindBy(uiAutomator = "//android.widget.Button[@resource-id=\"com.android.chrome:id/signin_fre_dismiss_button\"]")
//    public WebElement chromeUseWithoutAccount;











//    @AndroidFindBy(xpath = "//android.widget.CheckBox[@resource-id='rememberMe']")
//    private static WebElement rememberMeCheckBox;


    @SneakyThrows
    public void click_LoginBtn() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();

//        SupportsContextSwitching contextSwitchingDriver = (SupportsContextSwitching) appiumDriver;
//        Set<String> contextNames = contextSwitchingDriver.getContextHandles(); // here you need to make the changes according to the convience
//        for (String contextName : contextNames) {
//            if (contextName.contains("WEBVIEW")) {
//                ((SupportsContextSwitching) appiumDriver).context(contextName); // Cast to SupportsContextSwitching
//                break;
//            }
//        }
//        try {
//            WebElement chromeElement = appiumDriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.chrome:id/signin_fre_dismiss_button\"]"));
//            if (chromeElement != null) {
//                chromeElement.click();
//                System.out.println("Clicked on the element.");
//            }
//        } catch (NoSuchElementException e) {
//            System.out.println("Chrome element not found.");
//        }
//        ((SupportsContextSwitching) appiumDriver).context((String) contextNames.toArray()[0]);
    }





    @SneakyThrows
    public void enter_Username(String userName) {
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOf(usernameTxtfFld));
        usernameTxtfFld.sendKeys(userName);
    }

    @SneakyThrows
    public void enter_password(String password) {
        Thread.sleep(10000);
        passwordTxtfFld.sendKeys(password);
        Thread.sleep(10000);
    }


    public void selectRegion(String region) {
        wait.until(ExpectedConditions.visibilityOf(regionDropdown));
//        Select dropdown = new Select(regionDropdown);
//        dropdown.selectByVisibleText(region);
        regionDropdown.click();
        appiumDriver.findElement(By.xpath("//android.view.View[@content-desc='"+ region +"']")).click();
    }

    @SneakyThrows
    public void signin() {
        System.out.println("inside signin");
        wait.until(ExpectedConditions.visibilityOf(signin));
        signin.click();
        //Thread.sleep(10000);
    }

    @SneakyThrows
    public void clickOnSettings() {
//        wait.until(ExpectedConditions.visibilityOf(ignoreBtm));
//        ignoreBtm.click();
        wait(10000);
        wait.until(ExpectedConditions.visibilityOf(settingsBtn));
        settingsBtn.click();
    }

    public void clickOnAdd(){
        wait.until(ExpectedConditions.visibilityOf(addBtn));
        addBtn.click();
        wait.until(ExpectedConditions.visibilityOf(patientID));
    }

    public void enterPatientDetails(String gender){
        String randomID = TestUtils.generateRandomAlphabets(10);
        System.out.println("Random Alphabets: " + randomID);
        patientID.sendKeys(randomID);
        String randomName = TestUtils.generateRandomAlphabets(10);
        System.out.println("Random Alphabets: " + randomName);
        patientName.sendKeys(randomName);

        String age = TestUtils.generateRandomNumbers(2);
        System.out.println("Random number: " + randomName);
        patientAge.sendKeys(age);
        patientGender.click();
        appiumDriver.findElement(By.xpath("//android.view.View[@text='Male']")).click();
       // appiumDriver.findElement(By.name("+ gender +"))











    }






    public void enableNotifications(){
    }

}
