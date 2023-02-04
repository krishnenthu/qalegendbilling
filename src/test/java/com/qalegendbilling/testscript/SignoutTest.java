package com.qalegendbilling.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.SignoutPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.TestHelperUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SignoutTest extends Base {
    LoginPage login;
    SignoutPage signOut;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 1,description = "TC001_verifyUserSignOut",groups = {"Smoke"})
    public void TC001_verifyUserSignOut() {
        extentTest.get().assignCategory("Smoke");
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPageTitle");
        String expLoginPageTitle=data.get(0).get(1);
        login=new LoginPage(driver);
        login.enterUsername();
        login.enterPassword();
        login.selectRememberMeCheckBox();
        login.clickOnLoginButton();
        signOut=new SignoutPage(driver);
        signOut.clickOnSignOutButton();
        String actPageTitle= login.getLoginPageTitle();
        Assert.assertEquals(actPageTitle,expLoginPageTitle, ErrorMessage.SIGNOUT_FAILED_MESSAGE);
        extentTest.get().log(Status.PASS,"SignedOut from home page");

    }
}
