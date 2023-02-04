package com.qalegendbilling.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessage;
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
    UserManagementPage userManagement;
    UsersPage user;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1,description = "TC001_verifyUsersPageTitle",groups = {"Regression"})
    public void TC001_verifyUsersPageTitle() {
        extentTest.get().assignCategory("Regression");
        login=new LoginPage(driver);
        login.enterUsername();
        login.enterPassword();
        login.selectRememberMeCheckBox();
        login.clickOnLoginButton();
        userManagement=new UserManagementPage(driver);
        userManagement.clickOnTheUserManagementMenu();
        userManagement.clickOnUsersMenu();
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("UsersPageTitle");
        String expUserPageTitle=data.get(0).get(1);
        user=new UsersPage(driver);
        String actUserPageTitle=user.getUsersPageTitle();
        extentTest.get().log(Status.PASS,"Users page title received");
        Assert.assertEquals(actUserPageTitle,expUserPageTitle, ErrorMessage.TITLE_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS,"Expected Users page title match with actual Users page title");

    }
}
