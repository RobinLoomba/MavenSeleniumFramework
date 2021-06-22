package com.featuretesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseClass extends DriverClass {

    public void getMethod(String url) {
        driver.get(url);
        Log.info("URL Fetched");

    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void clickMethod(By locator) {
        explicitWait(locator).click();

    }

    public void pageLoadTimeOut() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void clickMethod(WebElement element)//overloading method
    {
        element.click();

    }

    public void submitMethod(WebElement element) {
        element.submit();

    }

    public List<WebElement> getElements(By locator) {
        List<WebElement> myElements = driver.findElements(locator);
        return myElements;

    }

    public void closeBrowser() {
        driver.close();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();

    }

    public String openWindowInNewTab() {
        return Keys.chord(Keys.CONTROL, Keys.ENTER);
    }

    public void switchToNewTab(String strHandle) {
        driver.switchTo().window(strHandle);
    }

    public void keyboardEventEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void mouseHover(By locator) {
        Actions action = new Actions(driver);
        action.moveToElement(explicitWait(locator)).build().perform();

    }

    public void mouseClick(By locator) {
        Actions action = new Actions(driver);
        action.moveToElement(explicitWait(locator)).click().build().perform();

    }

    public WebElement explicitWait(By locator) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;

    }

    public boolean explicitWaitText(By locator, String text) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        boolean bool = wait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
        return bool;

    }

    public void sendKeysMethod(By locator, String strName) {
        explicitWait(locator).sendKeys(strName);
    }

    public void browserBack() {
        driver.navigate().back();
    }

    public void refresh() {
        driver.navigate().refresh();
    }


}
