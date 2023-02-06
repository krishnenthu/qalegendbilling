package com.qalegendbilling.pages;

import com.qalegendbilling.constants.Constants;
import com.qalegendbilling.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestHelperUtility {
    public WebDriver driver;
    /** Page Constructor **/
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    /** Page Elements **/
    private final String _usernameField="//input[@id='username']";
    @FindBy(xpath = _usernameField) private WebElement usernameField;
    private final String _passwordField="//input[@id='password']";
    @FindBy(xpath = _passwordField) private WebElement passwordField;
    private final String _rememberMeCheckBox="//input[@name='remember']";
    @FindBy(xpath = _rememberMeCheckBox) private WebElement rememberMeCheckBox;

    private final String _loginButton="//button[@class='btn btn-primary']";
    @FindBy(xpath = _loginButton) private WebElement loginButton;

    private final String _forgotPasswordLink="//a[@class='btn btn-link']";
    @FindBy(xpath = _forgotPasswordLink) private WebElement forgotPasswordLink;

    private final String _invalidLoginMessage="//span[@class='help-block']//following-sibling::strong";
    @FindBy(xpath = _invalidLoginMessage) private WebElement invalidLoginMessage;

    /** User Action Methods **/
    public String getLoginPageTitle(){
        String title=page.getPageTitle(driver);
        return  title;
    }
    public void enterUsername(String userName){
        page.enterText(usernameField,userName);
    }
    public void enterPassword(String password){
        page.enterText(passwordField,password);
    }
    public void selectRememberMeCheckBox(){
        page.clickOnElement(rememberMeCheckBox);
    }
    public HomePage clickOnLoginButton(){
        page.clickOnElement(loginButton);
        return new HomePage(driver);
    }

    public  ResetPage clickOnForgotPasswordLink(){
        page.clickOnElement(forgotPasswordLink);
        return new ResetPage(driver);
    }
    public Boolean checkRememberMeCheckBoxStatus(){
       Boolean status= page.isSelected(rememberMeCheckBox);
       return status;
    }

    public String getInvalidLoginMessage(){
        String message=page.getElementText(invalidLoginMessage);
        return message;
    }
}