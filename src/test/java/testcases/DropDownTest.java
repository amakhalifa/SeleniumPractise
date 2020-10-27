package testcases;

import base.Testbase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropDownPage;
import pages.HomePage;
import pages.LoginPage;

public class DropDownTest extends Testbase {
    LoginPage loginPage;
    HomePage homePage;
    DropDownPage dropDownPage;

    public DropDownTest() {
        super();
    }

    @BeforeMethod
    public void setup(){
        initConfiguration();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        dropDownPage = homePage.clickOnDropDownLink();
    }

    @Test(priority = 1)
    public void selectCountryTest() {
        switchToActionFrame();
        dropDownPage.selectCountry();
        Assert.assertEquals(dropDownPage.getSelectedCountry(), "Albania");
        switchToMainWindow();
    }


    @Test(priority = 2)
    public void enterCountryTest() {
        switchToMainWindow();
        dropDownPage.clickOnEnterCountryTab();
        driver.switchTo().frame(1);
        dropDownPage.clearSearchField();
        dropDownPage.typeInitialsOfEgyptCountry();
        dropDownPage.getCurrentList();
        Assert.assertEquals(dropDownPage.getCurrentList(), "bosnia and herzegowina\tegypt\tsenegal\t");
    }

    @AfterMethod
    public void tearDown() {
        quitBrowser();
    }

}
