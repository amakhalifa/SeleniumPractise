package testcases;

import base.Testbase;
import org.apache.hc.core5.reactor.Command;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.thread.IThreadWorkerFactory;
import pages.FrameWindowPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.Iterator;
import java.util.Set;

public class FrameWindowTest extends Testbase {

    LoginPage loginPage;
    HomePage homePage;
    FrameWindowPage framewindow;
    public FrameWindowTest() {
        super();
    }

    @BeforeMethod
    public void setup(){
        initConfiguration();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        framewindow = homePage.clickOnFrameWindLink();
    }

    @Test(enabled = false)
    public void frameTest1() {
        switchToActionFrame();
        framewindow.clickNewBrowserTab();
        Set<String> wHandles = driver.getWindowHandles();
        Iterator<String> i = wHandles.iterator();
        String pWindow = i.next();
        String cWindow = i.next();

        driver.switchTo().window(cWindow);
        Assert.assertEquals(getWindowTitle(), "jQuery UI Datepicker - Default functionality");
        driver.switchTo().window(pWindow);
        Assert.assertEquals(getWindowTitle(),  "Welcome");
    }

    @Test
    public void frameTest2() {
        switchToMainWindow();
        framewindow.openSeprateNewWindow();
        framewindow.switchToSeprateNewWindowFrame();
        framewindow.clickSeprateNewWindowBtn();

        Set<String> wHandles = driver.getWindowHandles();
        Iterator<String> i = wHandles.iterator();

        String pWindow = i.next();
        String cWindow = i.next();

        driver.switchTo().window(cWindow);
        Assert.assertEquals(getWindowTitle(), "Open New Seprate Window");
        driver.switchTo().window(pWindow);
        Assert.assertEquals(getWindowTitle(),  "Welcome");

    }

    public void tearDown() {
        quitBrowser();
    }


}
