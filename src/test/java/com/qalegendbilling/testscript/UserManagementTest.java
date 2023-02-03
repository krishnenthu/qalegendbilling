package com.qalegendbilling.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserManagementPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserManagementTest extends Base {
    LoginPage login;
    HomePage home;
    UserManagementPage userManagement;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test
    public void TC001_verifyTheUserManagementSubTabsAreDisplayed() {
        login=new LoginPage(driver);
        login.enterUsername();
        login.enterPassword();
        login.selectRememberMeCheckBox();
        login.clickOnLoginButton();
        userManagement=new UserManagementPage(driver);
        userManagement.clickOnTheUserManagementMenu();
        Boolean userMenuStatus=userManagement.userMenuIsDisplayed();
        Assert.assertTrue(userMenuStatus, ErrorMessage.USER_SUB_MENU_NOT_FOUND_MESSAGE);
        Boolean rolesMenuStatus=userManagement.roleMenuIsDisplayed();
        Assert.assertTrue(rolesMenuStatus, ErrorMessage.ROLE_SUB_MENU_NOT_FOUND_MESSAGE);
        Boolean salesMenuStatus=userManagement.salesCommissionMenuIsDisplayed();
        Assert.assertTrue(salesMenuStatus, ErrorMessage.SALES_SUB_MENU_NOT_FOUND_MESSAGE);
    }
}
