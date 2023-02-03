package com.qalegendbilling.testscript;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessage;
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
    @Test
    public void TC001_verifyUsersPageTitle() {
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
        Assert.assertEquals(actUserPageTitle,expUserPageTitle, ErrorMessage.TITLE_FAILURE_MESSAGE);

    }
}
