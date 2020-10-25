package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Testbase {

    public static WebDriver driver;
    public static Properties prop;


    public Testbase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initConfiguration() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }


    public void waitForElementToBeVisiable(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void switchToMainWindow(){
        driver.switchTo().defaultContent();
    }

    public static void quitBrowser() {
        driver.quit();
    }

    public void switchToActionFrame(){
        driver.switchTo().frame(0);
    }

    public static Set<String> getWindowHandles() {
        Set<String> wHandles = driver.getWindowHandles();
        return wHandles;
    }

    public String getWindowTitle() {
        String title = driver.getTitle();
        return title;
    }

    }
