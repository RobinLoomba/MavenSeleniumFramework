package com.objectrepository;

import com.featuretesting.BaseClass;
import com.featuretesting.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class LogInPagePOM extends BaseClass {
    By btnRegister = By.xpath("//div[@class = 'mTxt'][text()='Recruiters']");
    By btnCompany = By.xpath("//div[@class = 'mTxt'][text() = 'Companies']");
    By btnBrowseAllRecruiters = By.xpath("//a[text()= 'Browse All Recruiters']");
    By lnkGoogleSearchResults = By.xpath("//a/h3");
    By txtGoogleSearch = By.xpath("//input[@name ='q' and @aria-label ='Search']");
    By btnSearchClick = By.xpath("//button[@type ='submit']");
    By btnLogInHome = By.xpath("//a[@id ='login_Layer']");
    By txtUserName = By.xpath("//input[@placeholder ='Enter your active Email ID / Username']");
    By txtPassword = By.xpath("//input[@placeholder ='Enter your password']");
    By btnLogIn = By.xpath("//button[@type ='submit']");
    By divProfileName = By.xpath("//div[@class='user-name roboto-bold-text']");
    By divInvalidText = By.xpath("//div[@class= 'server-err']");

    public void clickLogIn() {
        clickMethod(btnLogInHome);
    }

    public void enterUserName(String strUserName) {
        sendKeysMethod(txtUserName, strUserName);
    }

    public void enterPassword(String strPassword) {
        sendKeysMethod(txtPassword, strPassword);
    }
    public void logInToPortal(String strUserName, String strPassword)
    {
        enterUserName(strUserName);
        enterPassword(strPassword);

    }

    public void clickLogInButton() {
        clickMethod(btnLogIn);
    }

    public String getProfileName() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String strProfileName = explicitWait(divProfileName).getText();
        return strProfileName;
    }
    public String getErrorMessage()
    {
        return  explicitWait(divInvalidText).getText();
    }

    public void verificationMethod(String expectedResult, String actualResult) {
        Assert.assertEquals(expectedResult, actualResult);

    }


    public void clickRegister() {
        clickMethod(btnRegister);

    }

    public void openLinkinNewTab() {
        String parentWindow = getWindowHandle();
        String nextTab = openWindowInNewTab();
        sendKeysMethod(btnCompany, nextTab);
    }


    public void clickCompany() {
        clickMethod(btnCompany);
    }

    public void companyVerification() {
        String parentWindow = getWindowHandle();
        clickMethod(btnCompany);
        Set<String> windowHandles = getWindowHandles();
        int count = windowHandles.size();
        System.out.println("Count is " + count);
        for (String handles : windowHandles) {
            switchToNewTab(handles);
            String currentURL = getCurrentUrl();
            System.out.println("URL is " + currentURL);
            if (currentURL.equals("https://www.naukri.com/top-company-jobs")) {
                maximize();
                String expectedTitle = "Browse Jobs by Company - Jobs in Top Companies - Naukri.com";
                String actualTitle = getTitle();
                System.out.println("Actual title is " + actualTitle);
                verificationMethod(expectedTitle, actualTitle);
                break;
            }
        }


    }


    public void browseAllRecruiter() {
        mouseHover(btnRegister);
        mouseClick(btnBrowseAllRecruiters);


    }

    public void recruiterConnection() {

    }

    public void searchGoogle() {
        sendKeysMethod(txtGoogleSearch, "Robin Loomba");
        keyboardEventEnter(txtGoogleSearch);
    }

    public void clickAllGoogleSearchLinks() {
        List<WebElement> test = getElements(lnkGoogleSearchResults);
        int count = test.size();
        System.out.println("total Elements are " + count);
        for (WebElement ele : test) {
            clickMethod(ele);
            browserBack();
            refresh();
            count--;
            if (count == 5) {
                break;
            }
        }

    }

}
