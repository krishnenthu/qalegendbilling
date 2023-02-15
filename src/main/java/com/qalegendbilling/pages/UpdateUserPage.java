package com.qalegendbilling.pages;

import com.qalegendbilling.utilities.TableUtility;
import com.qalegendbilling.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UpdateUserPage extends TestHelperUtility {
    public WebDriver driver;
    /** Page Constructor **/
    public UpdateUserPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private final String _lastNameField="//input[@id='last_name']";
    @FindBy(xpath = _lastNameField) private WebElement lastNameField;


    public String getEditUserPageTitle(){
        String title=page.getPageTitle(driver);
        return  title;
    }

    public void clearLastNameField(){
        page.clearField(lastNameField);
    }




}
