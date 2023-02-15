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

public class UpdateUserTest extends Base {
    LoginPage login;
    HomePage home;
    UserManagementPage userManagement;
    UsersPage user;
    AddUserPage adduser;

    UpdateUserPage updateUser;

    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 1, description = "TC001_verifyEditUserPageTitle", groups = {"Smoke"})
    public void TC001_verifyEditUserPageTitle() {
       // extentTest.get().assignCategory("Smoke");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String UserName=loginData.get(1).get(1);
        String Password=loginData.get(2).get(1);
        List<ArrayList<String>> usersData = ExcelUtility.excelDataReader(ExcelSheet.USERS_PAGE_SHEET);
        String expSuccessMessage=usersData.get(1).get(1);
        List<ArrayList<String>> editUserData = ExcelUtility.excelDataReader(ExcelSheet.EDIT_USER_PAGE_SHEET);
        String expEditUserPageTitle=editUserData.get(0).get(1);
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
        String email= adduser.enterEmail();
        adduser.enterUserName();
        adduser.enterPassword();
        user=adduser.clickOnSaveButton();
        String actSuccessMessage=user.getAddUserSuccessMessage();
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_ADD_USER_SUCCESS_MESSAGE);
        Assert.assertEquals(actSuccessMessage,expSuccessMessage, ErrorMessage.USER_ADD_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_ADD_USER_SUCCESS_VALIDATION_MESSAGE);
        user.enterMailIdInSearchField(email);
        String actSearchResultEmail=user.getValidSearchResult();
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_SEARCH_RESULT_RECEIVED_MESSAGE);
        Assert.assertEquals(actSearchResultEmail,email,ErrorMessage.USER_VALID_DATA_SEARCH_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_SEARCH_RESULT_VALIDATION_MESSAGE);
        updateUser=user.clickOnEditButtonInSearchResult();
        String actEditUserPageTitle=updateUser.getEditUserPageTitle();
        extentTest.get().log(Status.PASS, ExtentLogMessage.EDIT_USER_TITLE_RECEIVED_MESSAGE);
        Assert.assertEquals(actEditUserPageTitle,expEditUserPageTitle, ErrorMessage.TITLE_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS,ExtentLogMessage.EDIT_USER_TITLE_VALIDATION_MESSAGE);

    }

    @Test(priority = 1, description = "TC001_verifyUserCanEditTheUserDetails", groups = {"Sanity"})
    public void TC002_verifyUserCanEditTheUserDetails() {
       // extentTest.get().assignCategory("Sanity");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String UserName=loginData.get(1).get(1);
        String Password=loginData.get(2).get(1);
        List<ArrayList<String>> usersData = ExcelUtility.excelDataReader(ExcelSheet.USERS_PAGE_SHEET);
        String expSuccessMessage=usersData.get(1).get(1);
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
        String email= adduser.enterEmail();
        adduser.enterUserName();
        adduser.enterPassword();
        user=adduser.clickOnSaveButton();
        String actSuccessMessage=user.getAddUserSuccessMessage();
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_ADD_USER_SUCCESS_MESSAGE);
        Assert.assertEquals(actSuccessMessage,expSuccessMessage, ErrorMessage.USER_ADD_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_ADD_USER_SUCCESS_VALIDATION_MESSAGE);
        user.enterMailIdInSearchField(email);
        String actSearchResultEmail=user.getValidSearchResult();
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_SEARCH_RESULT_RECEIVED_MESSAGE);
        Assert.assertEquals(actSearchResultEmail,email,ErrorMessage.USER_VALID_DATA_SEARCH_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_SEARCH_RESULT_VALIDATION_MESSAGE);
        updateUser=user.clickOnEditButtonInSearchResult();
        updateUser.clearLastNameField();
    }

}
