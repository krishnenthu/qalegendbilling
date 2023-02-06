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

    private final String _signOutButton="//div[@class='pull-right']//a[@class='btn btn-default btn-flat']";
    @FindBy(xpath = _signOutButton) private WebElement signOutButton;


    public LoginPage clickOnSignOutButton(){
        page.clickOnElement(signOutButton);
        return new LoginPage(driver);
    }
}
