package com.qalegendbilling.pages;

import com.qalegendbilling.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends TestHelperUtility {

    public WebDriver driver;
    /** Page Constructor **/
    public UsersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getUsersPageTitle(){
        String title=page.getPageTitle(driver);
        return  title;
    }
}
