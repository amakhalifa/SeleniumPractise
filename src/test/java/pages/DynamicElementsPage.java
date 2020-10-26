package pages;

import base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicElementsPage extends Testbase {

    @FindBy(css = "div.internal_navi > ul > li:nth-child(1) > a")
    WebElement startWithTab;

    @FindBy(css = "div.internal_navi > ul > li:nth-child(2) > a")
    WebElement endWithTab;

    @FindBy(css = "div.internal_navi > ul > li:nth-child(3) > a")
    WebElement completeDynamicIDTab;

    @FindBy(xpath = "//input[@type='button']")
    WebElement submitBtn;

    @FindBy(xpath = "//input[starts-with(@id, 'submit')]")
    WebElement startWithBtn;

    @FindBy(css = "input[id$='1111']")
    WebElement endWithBtn;

    @FindBy(xpath ="//input[@type='button'][@name='submit']")
    WebElement completeDynamicIDBtn;

    public DynamicElementsPage() {
        PageFactory.initElements(driver, this);
    }


    public void clickSubmitBtn() {
        waitForElementToBeClickable(submitBtn, 10);
        submitBtn.click();
    }

    public void clickStartWithTab() {
        startWithTab.click();
    }

    public void clickEndWithTab() {
        endWithTab.click();
    }

    public void clickCompleteDynamicIDTab() {
        completeDynamicIDTab.click();
    }

    public boolean checkStartWithSubmitBtn() {
        boolean startWithBtnCheck = startWithBtn.isEnabled();
        return startWithBtnCheck;
    }

    public boolean checkEndWithSubmitBtn() {
        boolean  endWithBtnCheck = endWithBtn.isEnabled();
        return endWithBtnCheck;
    }


    public boolean checkCompleteDynamicIDBtn() {
        boolean  completeDynamicIDBtnCheck = completeDynamicIDBtn.isEnabled();
        return completeDynamicIDBtnCheck;
    }





}
