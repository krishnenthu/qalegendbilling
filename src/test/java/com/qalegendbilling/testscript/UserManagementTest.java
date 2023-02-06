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
import com.qalegendbilling.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
public class UserManagementTest extends Base {
    LoginPage login;
    HomePage home;
    UserManagementPage userManagement;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1,description = "TC001_verifyTheUserManagementSubTabsAreDisplayed",groups = {"Sanity"})
    public void TC001_verifyTheUserManagementSubTabsAreDisplayed() {
        extentTest.get().assignCategory("Sanity");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String UserName=loginData.get(1).get(1);
        String Password=loginData.get(2).get(1);
        login = new LoginPage(driver);
        login.enterUsername(UserName);
        login.enterPassword(Password);
        login.selectRememberMeCheckBox();
        home = login.clickOnLoginButton();
        home.clickOnEndTourButton();
        userManagement=home.clickOnTheUserManagementMenu();
        Boolean userMenuStatus=userManagement.userMenuIsDisplayed();
        Assert.assertTrue(userMenuStatus, ErrorMessage.USER_SUB_MENU_NOT_FOUND_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.USER_MANAGEMENT_USERS_MENU_DISPLAYED_MESSAGE);
        Boolean rolesMenuStatus=userManagement.roleMenuIsDisplayed();
        Assert.assertTrue(rolesMenuStatus, ErrorMessage.ROLE_SUB_MENU_NOT_FOUND_MESSAGE);
        extentTest.get().log(Status.PASS,ExtentLogMessage.USER_MANAGEMENT_ROLES_MENU_DISPLAYED_MESSAGE);
        Boolean salesMenuStatus=userManagement.salesCommissionMenuIsDisplayed();
        Assert.assertTrue(salesMenuStatus, ErrorMessage.SALES_SUB_MENU_NOT_FOUND_MESSAGE);
        extentTest.get().log(Status.PASS,ExtentLogMessage.USER_MANAGEMENT_SALES_MENU_DISPLAYED_MESSAGE);
    }
}
