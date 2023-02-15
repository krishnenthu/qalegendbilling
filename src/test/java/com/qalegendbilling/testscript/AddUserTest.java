package com.qalegendbilling.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.constants.ExcelSheet;
import com.qalegendbilling.constants.ExtentLogMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.*;
import com.qalegendbilling.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddUserTest extends Base {
    LoginPage login;
    HomePage home;
    UserManagementPage userManagement;
    UsersPage user;
    AddUserPage adduser;

    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 1,description = "TC001_verifyAddUsersPageTitle",groups = {"Sanity"})
    public void TC001_verifyAddUsersPageTitle() {
       extentTest.get().assignCategory("Sanity");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String UserName = loginData.get(1).get(1);
        String Password = loginData.get(2).get(1);
        List<ArrayList<String>> UsersData = ExcelUtility.excelDataReader(ExcelSheet.ADD_USERS_PAGE_SHEET);
        String expAddUsersPageTitle = UsersData.get(0).get(1);
        login = new LoginPage(driver);
        login.enterUsername(UserName);
        login.enterPassword(Password);
        login.selectRememberMeCheckBox();
        home = login.clickOnLoginButton();
        home.clickOnEndTourButton();
        userManagement = home.clickOnTheUserManagementMenu();
        user = userManagement.clickOnUsersMenu();
        adduser=user.clickOnAddUserButton();
        String actAddUsersPageTitle= adduser.getAddUserPageTitle();
        extentTest.get().log(Status.PASS, ExtentLogMessage.ADD_USER_TITLE_RECEIVED_MESSAGE);
        Assert.assertEquals(actAddUsersPageTitle,expAddUsersPageTitle, ErrorMessage.TITLE_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.ADD_USER_TITLE_VALIDATION_MESSAGE);
    }
    @Test(priority = 1,description = "TC002_verifyErrorMessageDisplayedWithoutFillingMandatoryFieldsInAddUserForm",groups = {"Regression"})
    public void TC002_verifyErrorMessageDisplayedWithoutFillingMandatoryFieldsInAddUserForm() {
        extentTest.get().assignCategory("Regression");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String UserName=loginData.get(1).get(1);
        String Password=loginData.get(2).get(1);
        List<ArrayList<String>> AddUserData = ExcelUtility.excelDataReader(ExcelSheet.ADD_USERS_PAGE_SHEET);
        String expEmailFieldErrorMessage=AddUserData.get(1).get(1);
        login = new LoginPage(driver);
        login.enterUsername(UserName);
        login.enterPassword(Password);
        login.selectRememberMeCheckBox();
        home = login.clickOnLoginButton();
        home.clickOnEndTourButton();
        userManagement=home.clickOnTheUserManagementMenu();
        user=userManagement.clickOnUsersMenu();
        adduser=user.clickOnAddUserButton();
        adduser.enterFirstName();
        adduser.enterLastName();
        adduser.enterUserName();
        adduser.enterPassword();
        adduser.clickOnSaveButton();
        String actEmailFieldErrorMessage= adduser.getEmailFieldErrorMessage();
        extentTest.get().log(Status.PASS, ExtentLogMessage.ADD_USER_WITHOUT_EMAIL_FIELD_ERROR_MESSAGE);
        Assert.assertEquals(actEmailFieldErrorMessage,expEmailFieldErrorMessage,ErrorMessage.ADD_USER_EMPTY_EMAIL_FIELD_VALIDATION_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.ADD_USER_WITHOUT_EMAIL_FIELD_ERROR_VALIDATION_MESSAGE);
    }


}
