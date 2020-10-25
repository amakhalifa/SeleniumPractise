package testcases;

import base.Testbase;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import util.WebEventListener;

@Listeners(WebEventListener.class)
public class LoginTest extends Testbase {

    LoginPage loginPage;

    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initConfiguration();
        loginPage = new LoginPage();
    }


    @Test
    public void signIn() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}

