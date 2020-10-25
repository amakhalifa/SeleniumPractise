package pages;

import base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrameWindowPage extends Testbase {

    @FindBy(xpath = "//a[text()='New Browser Tab']")
    WebElement newBrowserTab;


    public FrameWindowPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickNewBrowserTab() {
        newBrowserTab.click();
    }



}
