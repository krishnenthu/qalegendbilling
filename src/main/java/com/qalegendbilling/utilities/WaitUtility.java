package com.qalegendbilling.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

    public static final long EXPLICIT_WAIT = 20000;
    public static final long IMPLICIT_WAIT = 20;
    public static final long HARD_WAIT = 20000;
    public static final long PAGE_LOAD_WAIT = 20;
    public static final long FLUENT_WAIT = 20;
    public static final long POLLING_TIME = 5;

    public void setHardWait() {
        try {
            Thread.sleep(HARD_WAIT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
    }

    public static void setPageLoadWait(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
    }

    public enum LocatorType {
        Id, Name, Xpath, ClassName, CssSelector, TagName, LinkText, PartialLinkText;
    }

    public void waitForElementToBeVisible(WebDriver driver, String target, Enum locatorType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        if (locatorType.equals(LocatorType.Id)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
        } else if (locatorType.equals(LocatorType.ClassName)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(target)));
        } else if (locatorType.equals(LocatorType.Name)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(target)));
        } else if (locatorType.equals(LocatorType.Xpath)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target)));
        } else if (locatorType.equals(LocatorType.TagName)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(target)));
        } else if (locatorType.equals(LocatorType.LinkText)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(target)));
        } else if (locatorType.equals(LocatorType.PartialLinkText)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(target)));
        } else if (locatorType.equals(LocatorType.CssSelector)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(target)));
        } else {
            throw new RuntimeException("Invalid Locator");
        }
    }

    public void waitForElementToBeClickable(WebDriver driver, String target, Enum locatorType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        if (locatorType.equals(LocatorType.Id)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(target)));
        } else if (locatorType.equals(LocatorType.ClassName)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.className(target)));
        } else if (locatorType.equals(LocatorType.Name)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.name(target)));
        } else if (locatorType.equals(LocatorType.Xpath)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(target)));
        } else if (locatorType.equals(LocatorType.TagName)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.tagName(target)));
        } else if (locatorType.equals(LocatorType.LinkText)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText(target)));
        } else if (locatorType.equals(LocatorType.PartialLinkText)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(target)));
        } else if (locatorType.equals(LocatorType.CssSelector)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(target)));
        } else {
            throw new RuntimeException("Invalid Locator");
        }
    }

    public void waitForElementToBeSelected(WebDriver driver, String target, Enum locatorType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        if (locatorType.equals(LocatorType.Id)) {
            wait.until(ExpectedConditions.elementToBeSelected(By.id(target)));
        } else if (locatorType.equals(LocatorType.ClassName)) {
            wait.until(ExpectedConditions.elementToBeSelected(By.className(target)));
        } else if (locatorType.equals(LocatorType.Name)) {
            wait.until(ExpectedConditions.elementToBeSelected(By.name(target)));
        } else if (locatorType.equals(LocatorType.Xpath)) {
            wait.until(ExpectedConditions.elementToBeSelected(By.xpath(target)));
        } else if (locatorType.equals(LocatorType.TagName)) {
            wait.until(ExpectedConditions.elementToBeSelected(By.tagName(target)));
        } else if (locatorType.equals(LocatorType.LinkText)) {
            wait.until(ExpectedConditions.elementToBeSelected(By.linkText(target)));
        } else if (locatorType.equals(LocatorType.PartialLinkText)) {
            wait.until(ExpectedConditions.elementToBeSelected(By.partialLinkText(target)));
        } else if (locatorType.equals(LocatorType.CssSelector)) {
            wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector(target)));
        } else {
            throw new RuntimeException("Invalid Locator");
        }
    }

    public void waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver, String target, Enum locatorType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        if (locatorType.equals(LocatorType.Id)) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(target)));
        } else if (locatorType.equals(LocatorType.ClassName)) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className(target)));
        } else if (locatorType.equals(LocatorType.Name)) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(target)));
        } else if (locatorType.equals(LocatorType.Xpath)) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(target)));
        } else if (locatorType.equals(LocatorType.TagName)) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName(target)));
        } else if (locatorType.equals(LocatorType.LinkText)) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.linkText(target)));
        } else if (locatorType.equals(LocatorType.PartialLinkText)) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.partialLinkText(target)));
        } else if (locatorType.equals(LocatorType.CssSelector)) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(target)));
        } else {
            throw new RuntimeException("Invalid Locator");
        }
    }

    public void waitForPresenceOfAllElementsLocatedBy(WebDriver driver, String target, Enum locatorType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        if (locatorType.equals(LocatorType.Id)) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(target)));
        } else if (locatorType.equals(LocatorType.ClassName)) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(target)));
        } else if (locatorType.equals(LocatorType.Name)) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(target)));
        } else if (locatorType.equals(LocatorType.Xpath)) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(target)));
        } else if (locatorType.equals(LocatorType.TagName)) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName(target)));
        } else if (locatorType.equals(LocatorType.LinkText)) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(target)));
        } else if (locatorType.equals(LocatorType.PartialLinkText)) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText(target)));
        } else if (locatorType.equals(LocatorType.CssSelector)) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(target)));
        } else {
            throw new RuntimeException("Invalid Locator");
        }
    }

    public void waitForElementToBeVisible(WebDriver driver, WebElement element, Enum locatorType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        if (locatorType.equals(LocatorType.Id)) {
            wait.until(ExpectedConditions.visibilityOf(element));
        } else {
            throw new RuntimeException("Invalid Locator");
        }
    }


    public void waitForVisibilityOfAllElements(WebDriver driver, String target, Enum locatorType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        if (locatorType.equals(LocatorType.Id)) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(target)));
        } else if (locatorType.equals(LocatorType.ClassName)) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(target)));
        } else if (locatorType.equals(LocatorType.Name)) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(target)));
        } else if (locatorType.equals(LocatorType.Xpath)) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(target)));
        } else if (locatorType.equals(LocatorType.TagName)) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(target)));
        } else if (locatorType.equals(LocatorType.LinkText)) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(target)));
        } else if (locatorType.equals(LocatorType.PartialLinkText)) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText(target)));
        } else if (locatorType.equals(LocatorType.CssSelector)) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(target)));
        } else {
            throw new RuntimeException("Invalid Locator");
        }
    }

    public void setFluentWaitWaitForElementToBeVisible(WebDriver driver, WebElement element) {
        FluentWait fwait = new FluentWait<>(driver);
        fwait.withTimeout(Duration.ofSeconds(FLUENT_WAIT));
        fwait.pollingEvery(Duration.ofSeconds(POLLING_TIME));
        fwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void setFluentWaitWaitForElementToBeClickable(WebDriver driver, WebElement element) {
        FluentWait fwait = new FluentWait<>(driver);
        fwait.withTimeout(Duration.ofSeconds(FLUENT_WAIT));
        fwait.pollingEvery(Duration.ofSeconds(POLLING_TIME));
        fwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void setFluentWaitForElementToBeSelected(WebDriver driver, WebElement element) {
        FluentWait fwait = new FluentWait<>(driver);
        fwait.withTimeout(Duration.ofSeconds(FLUENT_WAIT));
        fwait.pollingEvery(Duration.ofSeconds(POLLING_TIME));
        fwait.until(ExpectedConditions.elementToBeSelected(element));

    }
}
