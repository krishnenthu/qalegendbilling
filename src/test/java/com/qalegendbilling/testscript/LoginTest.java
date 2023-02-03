package com.qalegendbilling.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.dataprovider.DataProviders;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends Base {
    LoginPage login;
    HomePage home;
    DataProvider dataProvider;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test
    public void TC001_verifyLoginPageTitle() {
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPageTitle");
        String expLoginPageTitle=data.get(0).get(1);
        login=new LoginPage(driver);
        String actLoginPageTitle=login.getLoginPageTitle();
       // extentTest.get().log(Status.PASS,"Login page title received");
        Assert.assertEquals(actLoginPageTitle,expLoginPageTitle, ErrorMessage.TITLE_FAILURE_MESSAGE);
      //  extentTest.get().log(Status.PASS,"Expected login page title match with actual login page title");
    }
    @Test
    public void TC002_verifyUserLoginWithValidUserCredentials() {
        login=new LoginPage(driver);
        login.enterUsername();
        login.enterPassword();
        login.selectRememberMeCheckBox();
        login.clickOnLoginButton();
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePageTitle");
        String expHomePageTitle=data.get(0).get(1);
        home=new HomePage(driver);
        String actHomePageTitle= home.getHomePageTitle();
        Assert.assertEquals(actHomePageTitle,expHomePageTitle, ErrorMessage.LOGIN_FAILURE_MESSAGE);
    }
    @Test(dataProvider = "InvalidCredentials", dataProviderClass = DataProviders.class)
    public void TC003_verifyUserLoginWithInvalidUserCredentials(String userName, String password) {
            List<ArrayList<String>> data = ExcelUtility.excelDataReader("LogInInvalid");
             String expErrorMessage=data.get(0).get(1);
            login=new LoginPage(driver);
            login.enterInvalidUsername(userName);
            login.enterInvalidPassword(password);
            login.clickOnLoginButton();
            String actErrorMessage= login.getInvalidLoginMessage();
            Assert.assertEquals(expErrorMessage,actErrorMessage,ErrorMessage.INVALID_ERROR_MESSAGE);
    }
    @Test
    public void TC004_verifyUserAbleToClickOnRememberMeCheckBox() {
        login=new LoginPage(driver);
       Boolean status= login.checkRememberMeCheckBoxStatus();
       Assert.assertFalse(status,ErrorMessage.REMEMBER_ME_CHECKBOX_SELECTED_BY_DEFAULT_MESSAGE);
    }
}
