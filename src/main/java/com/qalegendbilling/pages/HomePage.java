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
    private final String _dateDisplayed="//div[@class='m-8 pull-left mt-15 hidden-xs']//strong";
    @FindBy(xpath = _dateDisplayed) private WebElement dateDisplayed;

    public String getHomePageTitle(){
        String title=page.getPageTitle(driver);
        return  title;
    }
    public String getDate(){
        String date=page.getElementText(dateDisplayed);
        return date;
    }
}
