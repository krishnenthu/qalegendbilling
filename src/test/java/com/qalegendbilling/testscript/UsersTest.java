package com.qalegendbilling.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.constants.ExcelSheet;
import com.qalegendbilling.constants.ExtentLogMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserManagementPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
public class UsersTest extends Base {
    LoginPage login;
    HomePage home;
    UserManagementPage userManagement;
    UsersPage user;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1,description = "TC001_verifyUsersPageTitle",groups = {"Regression"})
    public void TC001_verifyUsersPageTitle() {
        extentTest.get().assignCategory("Regression");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String UserName=loginData.get(1).get(1);
        String Password=loginData.get(2).get(1);
        List<ArrayList<String>> UsersData = ExcelUtility.excelDataReader(ExcelSheet.USERS_PAGE_SHEET);
        String expUserPageTitle=UsersData.get(0).get(1);
        login = new LoginPage(driver);
        login.enterUsername(UserName);
        login.enterPassword(Password);
        login.selectRememberMeCheckBox();
        home = login.clickOnLoginButton();
        home.clickOnEndTourButton();
        userManagement=home.clickOnTheUserManagementMenu();
        user=userManagement.clickOnUsersMenu();
        String actUserPageTitle=user.getUsersPageTitle();
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_TITLE_RECEIVED_MESSAGE);
        Assert.assertEquals(actUserPageTitle,expUserPageTitle, ErrorMessage.TITLE_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS,ExtentLogMessage.USERS_TITLE_VALIDATION_MESSAGE);
    }
}
