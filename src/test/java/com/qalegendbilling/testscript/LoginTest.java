package com.qalegendbilling.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.constants.ExcelSheet;
import com.qalegendbilling.constants.ExtentLogMessage;
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
    @Test(priority = 1, description = "TC001_verifyLoginPageTitle", groups = {"Regression"})
    public void TC001_verifyLoginPageTitle() {
        extentTest.get().assignCategory("Regression");
        List<ArrayList<String>> data = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String expLoginPageTitle = data.get(0).get(1);
        login = new LoginPage(driver);
        String actLoginPageTitle = login.getLoginPageTitle();
        System.out.println("Test");
        extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_TITLE_RECEIVED_MESSAGE);
        Assert.assertEquals(actLoginPageTitle, expLoginPageTitle, ErrorMessage.TITLE_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_TITLE_VALIDATION_MESSAGE);
    }
    @Test(priority = 1, description = "TC002_verifyUserLoginWithValidUserCredentials", groups = {"Smoke"})
    public void TC002_verifyUserLoginWithValidUserCredentials() {
        extentTest.get().assignCategory("Smoke");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String UserName=loginData.get(1).get(1);
        String Password=loginData.get(2).get(1);
        List<ArrayList<String>> homeData = ExcelUtility.excelDataReader(ExcelSheet.HOME_PAGE_SHEET);
        String expLoggedInUserName=homeData.get(1).get(1);
        login = new LoginPage(driver);
        login.enterUsername(UserName);
        login.enterPassword(Password);
        login.selectRememberMeCheckBox();
        home = login.clickOnLoginButton();
        home.clickOnEndTourButton();
        String actLoggedInUserName=home.getLoggedInUserName();
        extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_USERNAME_RECEIVED_MESSAGE);
        Assert.assertEquals(actLoggedInUserName, expLoggedInUserName, ErrorMessage.LOGIN_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_USERNAME_VALIDATION_MESSAGE);
    }
    @Test(priority = 1, description = "TC003_verifyUserLoginWithInvalidUserCredentials", dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviders.class, groups = {"Sanity"})
    public void TC003_verifyUserLoginWithInvalidUserCredentials(String userName, String password) {
        extentTest.get().assignCategory("Sanity");
        List<ArrayList<String>> data =ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String expErrorMessage = data.get(3).get(1);
        login = new LoginPage(driver);
        login.enterUsername(userName);
        login.enterPassword(password);
        login.clickOnLoginButton();
        String actErrorMessage = login.getInvalidLoginMessage();
        extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_INVALID_LOGIN_ERROR_MESSAGE);
        Assert.assertEquals(actErrorMessage, expErrorMessage, ErrorMessage.INVALID_ERROR_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_INVALID_LOGIN_ERROR_VALIDATION_MESSAGE);
    }
    @Test(priority = 1, description = "TC004_verifyUserAbleToClickOnRememberMeCheckBox", groups = {"Regression"})
    public void TC004_verifyUserAbleToClickOnRememberMeCheckBox() {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        Boolean status = login.checkRememberMeCheckBoxStatus();
        if(status==true){
            Assert.assertTrue(status, ErrorMessage.REMEMBER_ME_CHECKBOX_SELECTED_BY_DEFAULT_MESSAGE);
            extentTest.get().log(Status.FAIL, ExtentLogMessage.LOGIN_CHECKBOX_DEFAULT_SELECTION_MESSAGE);
        }
        else {
            login.selectRememberMeCheckBox();
            Boolean statusCheck = login.checkRememberMeCheckBoxStatus();
            Assert.assertTrue(statusCheck, ErrorMessage.REMEMBER_ME_CHECKBOX_CANNOT_SELECT_MESSAGE);
            extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_CHECKBOX_SELECT_MESSAGE);
        }
    }
}
