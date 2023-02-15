package com.qalegendbilling.pages;

import com.qalegendbilling.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends TestHelperUtility {
    public WebDriver driver;
    /** Page Constructor **/
    public AddUserPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    private final String _prefixField="//input[@id='surname']";
    @FindBy(xpath = _prefixField) private WebElement prefixField;
    private final String _firstnameField="//input[@id='first_name']";
    @FindBy(xpath = _firstnameField) private WebElement firstnameField;
    private final String _lastnameField="//input[@id='last_name']";
    @FindBy(xpath = _lastnameField) private WebElement lastnameField;
    private final String _emailField="//input[@id='email']";
    @FindBy(xpath = _emailField) private WebElement emailField;
    private final String _userNameField="//input[@id='username']";
    @FindBy(xpath = _userNameField) private WebElement userNameField;

    private final String _passwordField="//input[@id='password']";
    @FindBy(xpath = _passwordField) private WebElement passwordField;

    private final String _confirmPasswordField="//input[@id='confirm_password']";
    @FindBy(xpath = _confirmPasswordField) private WebElement confirmPasswordField;

    private final String _saveButton="//button[@id='submit_user_button']";
    @FindBy(xpath = _saveButton) private WebElement saveButton;

    private final String _emailFieldErrorMessage="//label[@id='email-error']";
    @FindBy(xpath = _emailFieldErrorMessage) private WebElement emailFieldErrorMessage;


    public String enterFirstName(){
        String firstname = randomData.getfName();
        page.enterText(firstnameField,firstname);
        return firstname;
    }
    public String enterLastName(){
        String lastname = randomData.getlName();
        page.enterText(lastnameField,lastname);
        return lastname;
    }
    public String enterEmail(){
        String email = randomData.getRandomEmail();
        page.enterText(emailField,email);
        return email;
    }
    public String enterUserName(){
        String firstname = randomData.getfName();
        String lastname = randomData.getlName();
        String username = firstname.concat(lastname);
        page.enterText(userNameField,username);
        return username;
    }

    public String enterPassword(){
        String firstname = randomData.getfName();
        String password = firstname + "@123";
        String confirmPassword = password;
        page.enterText(passwordField,password);
        page.enterText(confirmPasswordField,confirmPassword);
        return password;
    }
    public UsersPage clickOnSaveButton(){
        page.clickOnElement(saveButton);
        return new UsersPage(driver);
    }

    public String getAddUserPageTitle(){
        String title=page.getPageTitle(driver);
        return  title;
    }
    public String getEmailFieldErrorMessage(){
        String emailErrorMessage=page.getElementText(emailFieldErrorMessage);
        return emailErrorMessage;
    }



}
