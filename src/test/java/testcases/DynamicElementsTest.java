package testcases;

import base.Testbase;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicElementsPage;
import pages.FrameWindowPage;
import pages.HomePage;
import pages.LoginPage;

public class DynamicElementsTest extends Testbase {
    LoginPage loginPage;
    HomePage homePage;
    DynamicElementsPage dynamicElementsPage;

    public DynamicElementsTest() {
        super();
    }

    @BeforeMethod
    public void setup(){
        initConfiguration();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        dynamicElementsPage = homePage.clickOnDynamicElementsLink();
    }

    @Test(priority = 1)
    public void startWithTest(){
        dynamicElementsPage.clickStartWithTab();
        switchToActionFrame();
        Assert.assertTrue(dynamicElementsPage.checkStartWithSubmitBtn());
    }

    @Test(priority = 2)
    public void endtWithTest(){
        dynamicElementsPage.clickEndWithTab();
        driver.switchTo().frame(1);
        Assert.assertTrue(dynamicElementsPage.checkEndWithSubmitBtn());
    }

    @Test(priority = 3)
    public void completeDynamicIDTest(){
        dynamicElementsPage.clickCompleteDynamicIDTab();
        switchToActionFrame();
        Assert.assertTrue(dynamicElementsPage.checkCompleteDynamicIDBtn());
    }


    @AfterMethod
    public void tearDown() {
        quitBrowser();
    }


}
