package testcases;

import base.Testbase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DragPage;
import pages.HomePage;
import pages.LoginPage;
import util.WebEventListener;

@Listeners(WebEventListener.class)
public class DragTest extends Testbase {

    public DragTest() {
        super();
    }

    HomePage homePage;
    LoginPage loginPage;
    DragPage dragPage;

    @BeforeMethod
    public void setup() {
        initConfiguration();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        dragPage = homePage.clickOnDragLink();
    }

    @Test
    public void doDrag() {
        switchToActionFrame();
        dragPage.dragMe();
    }


    @AfterMethod
    public void tearDown() {
        quitBrowser();
    }

}
