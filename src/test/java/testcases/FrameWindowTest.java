package testcases;

import base.Testbase;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

    @Test(priority = 1, enabled = false)
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

    @Test(priority = 2, enabled = false)
    public void frameTest2() {
        switchToMainWindow();
        framewindow.openSeprateNewWindow();
        framewindow.switchToSeprateNewWindowFrame();
        framewindow.cpenFrameBtn();

        Set<String> wHandles = driver.getWindowHandles();
        Iterator<String> i = wHandles.iterator();

        String pWindow = i.next();
        String cWindow = i.next();

        driver.switchTo().window(cWindow);
        Assert.assertEquals(getWindowTitle(), "Open New Seprate Window");
        driver.switchTo().window(pWindow);
        Assert.assertEquals(getWindowTitle(),  "Welcome");

    }

    @Test(priority = 3)
    public void frameTest3() {
        switchToMainWindow();
        framewindow.clickFrameSetTab();
        framewindow.switchToFrameSetFrame();
        framewindow.cpenFrameBtn();

        Set<String> wHandles = driver.getWindowHandles();
        Iterator<String> i = wHandles.iterator();

        String pWindow = i.next();
        String cWindow = i.next();


        driver.switchTo().window(pWindow);
        Assert.assertEquals(getWindowTitle(),  "Welcome");
        driver.switchTo().window(cWindow);
        Assert.assertEquals(getWindowTitle(), "HTML Frames - Example 1");

        driver.switchTo().frame("topFrame");
        String backgroundColor = driver.findElement(By.tagName("body")).getCssValue("background-color");
        Assert.assertEquals(backgroundColor, "rgba(151, 163, 193, 1)");

    }



    @AfterMethod
    public void tearDown() {
        quitBrowser();
    }


}
