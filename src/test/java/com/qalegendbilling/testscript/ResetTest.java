package com.qalegendbilling.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.ResetPage;
import com.qalegendbilling.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ResetTest extends Base {
    LoginPage login ;
    ResetPage reset;

    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1,description = "TC001_verifyResetPasswordWithInvalidEmailId",groups = {"Smoke"})
    public void TC001_verifyResetPasswordWithInvalidEmailId() {
        extentTest.get().assignCategory("Smoke");
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("ResetPassword");
        String expectedMessage=data.get(0).get(1);
        login=new LoginPage(driver);
        login.clickOnForgotPasswordLink();
        reset=new ResetPage(driver);
        reset.enterEmail();
        reset.clickOnPasswordResetButton();
        String actualMessage= reset.getMessageDisplayedOnInvalidEmailId();
        Assert.assertEquals(actualMessage,expectedMessage, ErrorMessage.PASSWORD_RESET_FAILED_MESSAGE);
        extentTest.get().log(Status.PASS,"Expected email match with email");

    }
}
