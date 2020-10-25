package testcases;

import base.Testbase;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.HomePage;
import pages.LoginPage;

public class AlertTest extends Testbase {
    LoginPage loginPage;
    HomePage  homePage;
    AlertPage alertPage;

    public AlertTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initConfiguration();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        alertPage = homePage.clickOnAlertLink();

    }

    @Test
    public void testSimpleAlert() {
        switchToActionFrame();
        alertPage.clickAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        switchToMainWindow();
    }

    @AfterMethod
    public void tearDown() {
        quitBrowser();
    }
}
