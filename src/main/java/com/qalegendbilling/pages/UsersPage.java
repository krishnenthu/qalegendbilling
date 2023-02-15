package com.qalegendbilling.pages;

import com.qalegendbilling.utilities.TestHelperUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends TestHelperUtility {

    public WebDriver driver;
    /** Page Constructor **/
    public UsersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private final String _addUserButton="//a[@class='btn btn-block btn-primary']";
    @FindBy(xpath = _addUserButton) private WebElement addUserButton;


    private final String _searchField="//input[@class='form-control input-sm']";
    @FindBy(xpath = _searchField) private WebElement searchField;

    private final String _userAddedSuccessMessage="//input[@id='status_span']";
    @FindBy(xpath = _userAddedSuccessMessage) private WebElement userAddedSuccessMessage;

    public final String attributeName="data-msg";

    private final String _searchResultRowCount="//table[@id='users_table']//tr[@class='odd']";
    @FindBy(xpath = _searchResultRowCount) private List<WebElement> searchResultRowCount;

    private final String _searchResultColumnCount="//table[@id='users_table']//tr[@class='odd']//td";
    @FindBy(xpath = _searchResultColumnCount) private List<WebElement> searchResultColumnCount;

    private final String _messageOnInvalidSearch="//table[@id='users_table']//td[@class='dataTables_empty']";
    @FindBy(xpath = _messageOnInvalidSearch) private WebElement messageOnInvalidSearch;

    private final String _usernameDisplayed="//a[@class='dropdown-toggle']//span";
    @FindBy(xpath = _usernameDisplayed) private WebElement usernameDisplayed;

    private final String _editUserButtonSearchResult="//a[@class='btn btn-xs btn-primary']//i[@class='glyphicon glyphicon-edit']";
    @FindBy(xpath = _editUserButtonSearchResult) private WebElement editUserButtonSearchResult;



    public String getUsersPageTitle(){
        String title=page.getPageTitle(driver);
        return  title;
    }
    public AddUserPage clickOnAddUserButton(){
        page.clickOnElement(addUserButton);
        return new AddUserPage(driver);
    }
    public void enterMailIdInSearchField(String email){
        wait.setHardWait();
        page.enterText(searchField,email);
        wait.setHardWait();
    }
    public String getAddUserSuccessMessage(){
        wait.setHardWait();
        String message=page.getAttributeValue(userAddedSuccessMessage,attributeName);
        wait.setHardWait();
        return message;
    }
    public String getValidSearchResult(){
        List<ArrayList<String>> actGridData = table.getTableElements(searchResultRowCount, searchResultColumnCount);
        String searchResultEmail=actGridData.get(0).get(3);
        return searchResultEmail;
    }

    public void searchWithInvalidEmail(){
        wait.setHardWait();
        String email = randomData.getRandomEmail();
        page.enterText(searchField,email);
        wait.setHardWait();
    }
    public String getMessageDisplayedOnInvalidSearch(){
        String invalidSearchMessage=page.getElementText(messageOnInvalidSearch);
        return invalidSearchMessage;
    }
    public SignoutPage clickOnLoggedInUserNameFromUsersPage(){
        page.clickOnElement(usernameDisplayed);
        return  new SignoutPage(driver);
    }

    public UpdateUserPage clickOnEditButtonInSearchResult(){
        page.clickOnElement(editUserButtonSearchResult);
        return new UpdateUserPage(driver);
    }




}
