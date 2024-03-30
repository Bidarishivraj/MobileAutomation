package com.qa.stepdef;

import com.qa.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import com.qa.utils.WebDriverFactory;


public class LoginStepdef {

    public AppiumDriver appiumDriver;
    public LoginPage loginPage;

    public LoginStepdef() {
        appiumDriver = Hooks.appiumDriver;
        loginPage = new LoginPage(appiumDriver); // Initialize LoginPage object
    }

    @Given("Open the Qure mobile app")
    public void openTheQureMobileApp() {
        System.out.println("open");
    }

    @Given("Select region {string}")
    public void selectRegion(String region) {
    }


    @Given("Click on login button")
    public void clickOnLogin_Btn() {
        System.out.println("befr click btn");
        loginPage.click_LoginBtn();
        System.out.println("after click btn");
    }


    @Given("Enter email address {string}")
    public void enterEmailAddress(String userName)  {
        System.out.println("user name");
        loginPage.enter_Username(userName);

    }

    @And("Enter password {string}")
    public void enter_password(String password) {
       loginPage.enter_password(password);
    }

    @And("Select the region {string}")
    public void select_Region(String region){
        loginPage.selectRegion(region);

    }

    @And("Click on signin")
    public void signin(){
        loginPage.signin();
    }

    @And("Click on Enable notifications")
    public void enableNotifications(){
        loginPage.enableNotifications();
    }

    @And("Click on Settings button")
    public void clickOnSettings(){
        loginPage.clickOnSettings();
    }

    @And("Click on Add button")
    public void clickOnAdd(){
        loginPage.clickOnAdd();
    }

//    @And("Enter Patient details")
//    public void enterPatientDetails(){
//        loginPage.enterPatientDetails();
//    }




//    @Given("Click on signin button")
//    public void clickOnSigninButton() {
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("User should be successfully logged into the application")
//    public void userShouldBeSuccessfullyLoggedIntoTheApplication() {
//        throw new io.cucumber.java.PendingException();
//    }


//                WebDriverFactory.getDriver(); // Initialize WebDriver


}
