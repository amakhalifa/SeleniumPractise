package pages;

import base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Testbase {

    @FindBy(linkText = "Signin")
    WebElement signinLnk;
    @FindBy(css="div#login > form > fieldset:nth-of-type(1) > input")
    WebElement usernameFld;
    @FindBy(css="div#login > form > fieldset:nth-of-type(2) > input")
    WebElement passwordFld;
    @FindBy(css="div#login > form > div > div.span_1_of_4 > input.button")
    public WebElement submit;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickSignBtn() {
        signinLnk.click();
    }

    public void username(String user) {
        usernameFld.sendKeys(user);
    }

    public void password(String pass) {
        passwordFld.sendKeys(pass);
    }

    public void submit() {
        submit.click();
    }

    public HomePage login(String un, String pw) {
        clickSignBtn();
        usernameFld.sendKeys(un);
        passwordFld.sendKeys(pw);
        submit.click();
        return new HomePage();
    }

}
