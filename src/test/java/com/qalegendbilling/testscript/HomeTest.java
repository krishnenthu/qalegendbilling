package com.qalegendbilling.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeTest extends Base {

    HomePage home;
    LoginPage login;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test
    public void TC001_verifyHomePageTitle() {
        login=new LoginPage(driver);
        login.enterUsername();
        login.enterPassword();
        login.selectRememberMeCheckBox();
        login.clickOnLoginButton();
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePageTitle");
        String expHomePageTitle=data.get(0).get(1);
        home=new HomePage(driver);
        String actHomePageTitle=home.getHomePageTitle();
        // extentTest.get().log(Status.PASS,"Home page title received");
        Assert.assertEquals(actHomePageTitle,expHomePageTitle, ErrorMessage.TITLE_FAILURE_MESSAGE);
        //  extentTest.get().log(Status.PASS,"Expected Home page title match with actual Home page title");
    }
    @Test
    public void TC002_verifyDateDisplayed() {
        login=new LoginPage(driver);
        login.enterUsername();
        login.enterPassword();
        login.selectRememberMeCheckBox();
        login.clickOnLoginButton();
        home=new HomePage(driver);
        String actualDate= home.getDate();
       DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        Date currentDateWithTime = new Date();
        String expectedDate= dateFormat.format(currentDateWithTime);
        System.out.println(expectedDate);
        Assert.assertEquals(actualDate,expectedDate, ErrorMessage.DATE_DISPLAYED_FAILED_MESSAGE);
    }
}