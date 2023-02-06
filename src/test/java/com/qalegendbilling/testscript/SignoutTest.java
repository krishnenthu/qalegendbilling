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
import com.qalegendbilling.pages.SignoutPage;
import com.qalegendbilling.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
public class SignoutTest extends Base {
    LoginPage login;
    HomePage home;
    SignoutPage signOut;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1,description = "TC001_verifyUserSignOut",groups = {"Smoke"})
    public void TC001_verifyUserSignOut() {
        extentTest.get().assignCategory("Smoke");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String expLoginPageTitle = loginData.get(0).get(1);
        String UserName=loginData.get(1).get(1);
        String Password=loginData.get(2).get(1);
        login = new LoginPage(driver);
        login.enterUsername(UserName);
        login.enterPassword(Password);
        login.selectRememberMeCheckBox();
        home = login.clickOnLoginButton();
        home.clickOnEndTourButton();
        signOut=home.clickOnLoggedInUserName();
        login= signOut.clickOnSignOutButton();
        String actPageTitle= login.getLoginPageTitle();
        Assert.assertEquals(actPageTitle,expLoginPageTitle, ErrorMessage.SIGN_OUT_FAILED_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.SIGN_OUT_SUCCESS_MESSAGE);
    }
}
