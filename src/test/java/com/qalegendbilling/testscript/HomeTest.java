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
import com.qalegendbilling.utilities.DateUtility;
import com.qalegendbilling.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class HomeTest extends Base {
    HomePage home;
    LoginPage login;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1, description = "TC001_verifyHomePageTitle", groups = {"Sanity"})
    public void TC001_verifyHomePageTitle() {
        extentTest.get().assignCategory("Sanity");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String UserName = loginData.get(1).get(1);
        String Password = loginData.get(2).get(1);
        List<ArrayList<String>> homeData = ExcelUtility.excelDataReader(ExcelSheet.HOME_PAGE_SHEET);
        String expHomePageTitle = homeData.get(0).get(1);
        login = new LoginPage(driver);
        login.enterUsername(UserName);
        login.enterPassword(Password);
        login.selectRememberMeCheckBox();
        home = login.clickOnLoginButton();
        home.clickOnEndTourButton();
        String actHomePageTitle = home.getHomePageTitle();
        extentTest.get().log(Status.PASS, ExtentLogMessage.HOME_TITLE_RECEIVED_MESSAGE);
        Assert.assertEquals(actHomePageTitle, expHomePageTitle, ErrorMessage.TITLE_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.HOME_TITLE_VALIDATION_MESSAGE);
    }
    @Test(priority = 1, description = "TC002_verifyDateDisplayed", groups = {"Regression"})
    public void TC002_verifyDateDisplayed() {
        extentTest.get().assignCategory("Regression");
        List<ArrayList<String>> loginData = ExcelUtility.excelDataReader(ExcelSheet.LOGIN_PAGE_SHEET);
        String userName = loginData.get(1).get(1);
        String password = loginData.get(2).get(1);
        login = new LoginPage(driver);
        login.enterUsername(userName);
        login.enterPassword(password);
        login.selectRememberMeCheckBox();
        home = login.clickOnLoginButton();
        home.clickOnEndTourButton();
        String actualDate = home.getDate();
        String expDate = DateUtility.getSystemDate();
        extentTest.get().log(Status.PASS, ExtentLogMessage.HOME_DATE_DISPLAYED_MESSAGE);
        Assert.assertEquals(actualDate, expDate, ErrorMessage.DATE_DISPLAYED_FAILED_MESSAGE);
        extentTest.get().log(Status.PASS, ExtentLogMessage.HOME_DATE_VALIDATION_MESSAGE);
    }
}
