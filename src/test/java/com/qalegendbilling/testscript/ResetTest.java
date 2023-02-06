package com.qalegendbilling.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.constants.ExcelSheet;
import com.qalegendbilling.constants.ExtentLogMessage;
import com.qalegendbilling.listeners.TestListener;
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
        List<ArrayList<String>> data = ExcelUtility.excelDataReader(ExcelSheet.RESET_PAGE_SHEET);
        String expectedErrorMessage=data.get(0).get(1);
        login=new LoginPage(driver);
        reset=login.clickOnForgotPasswordLink();
        reset.enterRandomEmail();
        reset.clickOnPasswordResetButton();
        String actualErrorMessage= reset.getMessageDisplayedOnInvalidEmailId();
        extentTest.get().log(Status.PASS, ExtentLogMessage.RESET_INVALID_EMAIL_ERROR_MESSAGE);
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage, ErrorMessage.PASSWORD_RESET_FAILED_MESSAGE);
        extentTest.get().log(Status.PASS,ExtentLogMessage.RESET_INVALID_EMAIL_ERROR_VALIDATION_MESSAGE);
    }
}
