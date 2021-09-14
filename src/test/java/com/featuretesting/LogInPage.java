package com.featuretesting;

import com.objectrepository.LogInPagePOM;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LogInPage extends LogInPagePOM {

    final String url = "https://www.naukri.com/";

    @DataProvider(name = "data-provider")
    public Object[][] parameterMethod() {
        return new Object[][]
                {
                        {"loomba.robin786@gmail.com", "Testing786#"},
                };
    }

    @DataProvider(name = "data-providerInvalid")
    public Object[][] parameterMethodInvalid() {
        return new Object[][]
                {
                        {"rest.rest@test.com", "Testing786#"},
                        {"test.test@test.com", "tester"}

                };
    }

    @Test(dataProvider = "data-providerInvalid", groups = {"Regression Test"})

    public void invalidCredentialsTest(String strUserName, String strPassword) {
        getMethod(url);
        maximize();
        clickLogIn();
        logInToPortal(strUserName, strPassword);
        clickLogInButton();
        String invalidText = getErrorMessage();
        verificationMethod("Invalid details. Please check the Email ID - Password combination.", invalidText);

    }

    @Test(dataProvider = "data-provider", groups = {"Smoke Test", "Regression Test"})
    public void logInToNaukriSite(String strUserName, String strPassword) {
        getMethod(url);
        maximize();
        clickLogIn();
        logInToPortal(strUserName, strPassword);
        clickLogInButton();
        pageLoadTimeOut();
        String strProfileName = getProfileName();
        String expectedName = "Robin Loomba";
        verificationMethod(expectedName, strProfileName);
    }


    @Test(groups = {"Smoke Test", "RegressionTest"})
    public void homePageTest() {
        System.out.println("Test Group");
        getMethod(url);

    }

    @Test(groups = {"Regression Test"})
    public void registerClick() {

        getMethod(url);
        maximize();
        clickRegister();


    }

    @Test(groups = {"Regression Test"})
    public void companyURLVerification() {
        getMethod(url);
        //maximize();
        companyVerification();
    }

    @Test(groups = {"Regression Test"})
    public void openBrowserAllrecruiterPage() {
        getMethod(url);
        browseAllRecruiter();


    }


}
