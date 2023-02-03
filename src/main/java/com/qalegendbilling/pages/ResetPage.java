package com.qalegendbilling.pages;

import com.qalegendbilling.constants.Constants;
import com.qalegendbilling.utilities.RandomDataUtility;
import com.qalegendbilling.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage extends TestHelperUtility {

    public WebDriver driver;
    /** Page Constructor **/
    public ResetPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    /** Page Elements **/

    private final String _emailField="//input[@id='email']";
    @FindBy(xpath = _emailField) private WebElement emailField;

    private final String _passwordResetButton="//input[@id='email']";
    @FindBy(xpath = _passwordResetButton) private WebElement passwordResetButton;

    private final String _messageOnInvalidEmailId="//span[@class='help-block']//following::strong";
    @FindBy(xpath = _messageOnInvalidEmailId) private WebElement messageOnInvalidEmailId;

    public void enterEmail(){
        String randomEmail= RandomDataUtility.getRandomEmail();
        page.enterText(emailField,randomEmail);
    }
    public void clickOnPasswordResetButton(){
        page.clickOnElement(passwordResetButton);
    }

    public String getMessageDisplayedOnInvalidEmailId(){
        wait.setHardWait();
        String messageDisplayed=page.getElementText(messageOnInvalidEmailId);
        return messageDisplayed;
    }

}
