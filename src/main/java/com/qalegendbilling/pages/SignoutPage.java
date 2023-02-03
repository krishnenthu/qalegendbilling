package com.qalegendbilling.pages;

import com.qalegendbilling.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignoutPage extends TestHelperUtility {
    public WebDriver driver;
    /** Page Constructor **/
    public SignoutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private final String _loggedInUserName="//a[@class='dropdown-toggle']//span";
    @FindBy(xpath = _loggedInUserName) private WebElement loggedInUserName;

    private final String _signOutButton="//div[@class='pull-right']//a[@class='btn btn-default btn-flat']";
    @FindBy(xpath = _signOutButton) private WebElement signOutButton;


    public void clickOnSignOutButton(){
        page.clickOnElement(loggedInUserName);
        wait.setHardWait();
        page.clickOnElement(signOutButton);
    }


}
