package com.qalegendbilling.pages;


import com.qalegendbilling.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestHelperUtility {
    public WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    private final String _endTourButton="//button[@class='btn btn-default btn-sm']";
    @FindBy(xpath = _endTourButton) private WebElement endTourButton;
    private final String _dateDisplayed="//div[@class='m-8 pull-left mt-15 hidden-xs']//strong";
    @FindBy(xpath = _dateDisplayed) private WebElement dateDisplayed;

    private final String _usernameDisplayed="//a[@class='dropdown-toggle']//span";
    @FindBy(xpath = _usernameDisplayed) private WebElement usernameDisplayed;

    private final String _userManagementMenu="//span[text()='User Management']";
    @FindBy(xpath = _userManagementMenu )private WebElement userManagementMenu;



    public String getHomePageTitle(){
        String title=page.getPageTitle(driver);
        return  title;
    }
    public String getDate(){
        String date=page.getElementText(dateDisplayed);
        return date;
    }
    public String getLoggedInUserName(){
        String loggedInUserName=page.getElementText(usernameDisplayed);
        return loggedInUserName;
    }
    public SignoutPage clickOnLoggedInUserName(){
        page.clickOnElement(usernameDisplayed);
        return  new SignoutPage(driver);
    }
    public UserManagementPage clickOnTheUserManagementMenu(){
        page.clickOnElement(userManagementMenu);
        wait.setHardWait();
        return new UserManagementPage(driver);
    }
    public void  clickOnEndTourButton(){
        page.clickOnElement(endTourButton);
        wait.setHardWait();
    }
}
