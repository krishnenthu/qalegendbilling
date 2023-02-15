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
public class UsersTest extends Base {
    LoginPage login;
    HomePage home;
    UserManagementPage userManagement;
    UsersPage user;
    AddUserPage adduser;
    SignoutPage signOut;
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
    @Test(priority = 1,description = "TC002_VerifyUserSearchWithValidData",groups = {"Smoke"})
    public void TC002_VerifyUserSearchWithValidData() {
         extentTest.get().assignCategory("Smoke");
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
    }

    @Test(priority = 1,description = "TC003_verifyMessageDisplayedByUserSearchWithInvalidData",groups = {"Sanity"})
    public void TC003_verifyMessageDisplayedByUserSearchWithInvalidData() {
        extentTest.get().assignCategory("Sanity");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String UserName = loginData.get(1).get(1);
        String Password = loginData.get(2).get(1);
        List<ArrayList<String>> usersData = ExcelUtility.excelDataReader(ExcelSheet.USERS_PAGE_SHEET);
        String expInvalidSearchMessage = usersData.get(2).get(1);
        login = new LoginPage(driver);
        login.enterUsername(UserName);
        login.enterPassword(Password);
        login.selectRememberMeCheckBox();
        home = login.clickOnLoginButton();
        home.clickOnEndTourButton();
        userManagement=home.clickOnTheUserManagementMenu();
        user=userManagement.clickOnUsersMenu();
        user.searchWithInvalidEmail();
        String actInvalidSearchMessage= user.getMessageDisplayedOnInvalidSearch();
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_INVALID_SEARCH_RESULT_MESSAGE);
        Assert.assertEquals(actInvalidSearchMessage,expInvalidSearchMessage,ErrorMessage.USER_INVALID_DATA_SEARCH_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_INVALID_SEARCH_RESULT_VALIDATION_MESSAGE);
    }

    @Test(priority = 1,description = "TC004_VerifyUserLoginWithNewlyAddedUser",groups = {"Smoke"})
    public void TC004_VerifyUserLoginWithNewlyAddedUser() {
        extentTest.get().assignCategory("Smoke");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String UserName = loginData.get(1).get(1);
        String Password = loginData.get(2).get(1);
        List<ArrayList<String>> usersData = ExcelUtility.excelDataReader(ExcelSheet.USERS_PAGE_SHEET);
        String expSuccessMessage = usersData.get(1).get(1);
        login = new LoginPage(driver);
        login.enterUsername(UserName);
        login.enterPassword(Password);
        login.selectRememberMeCheckBox();
        home = login.clickOnLoginButton();
        home.clickOnEndTourButton();
        userManagement = home.clickOnTheUserManagementMenu();
        user = userManagement.clickOnUsersMenu();
        adduser = user.clickOnAddUserButton();
        String newUserFirstName=adduser.enterFirstName();
        String newUserLastName=adduser.enterLastName();
        adduser.enterEmail();
        String newUserUserName = adduser.enterUserName();
        String newUserPassword = adduser.enterPassword();
        user = adduser.clickOnSaveButton();
        String actSuccessMessage = user.getAddUserSuccessMessage();
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_ADD_USER_SUCCESS_MESSAGE);
        Assert.assertEquals(actSuccessMessage, expSuccessMessage, ErrorMessage.USER_ADD_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.USERS_ADD_USER_SUCCESS_VALIDATION_MESSAGE);
        signOut = user.clickOnLoggedInUserNameFromUsersPage();
        login = signOut.clickOnSignOutButton();
        extentTest.get().log(Status.PASS, ExtentLogMessage.SIGN_OUT_SUCCESS_FROM_USERS_PAGE_MESSAGE);
        login.enterUsername(newUserUserName);
        login.enterPassword(newUserPassword);
        login.selectRememberMeCheckBox();
        home = login.clickOnLoginButton();
        String actLoggedInUserName = home.getLoggedInUserName();
        String expLoggedInUserName=newUserFirstName+" "+newUserLastName;
        extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_USERNAME_RECEIVED_MESSAGE);
        Assert.assertEquals(actLoggedInUserName, expLoggedInUserName, ErrorMessage.LOGIN_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_USERNAME_VALIDATION_MESSAGE);
    }

}
