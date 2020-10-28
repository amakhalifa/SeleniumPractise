package pages;

import base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class RegistrationPage extends Testbase {

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "form#register_form fieldset:nth-of-type(1) p input[name='name']")
    WebElement firstName;

    @FindBy(css = "form#register_form fieldset:nth-of-type(1) p:nth-of-type(2) input")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='m_status']")
    List<WebElement> maritalStatus;

    @FindBy(xpath = "//input[@name='hobby']")
    List<WebElement> hobby;


    @FindBy(css = "input[name='phone']")
    WebElement phone;

    @FindBy(css = "input[name='username']")
    WebElement username;

    @FindBy(css = "input[name='email']")
    WebElement email;

    @FindBy(css = "input[name='password']")
    WebElement password;

    @FindBy(css = "input[name='c_password']")
    WebElement cpassword;

    @FindBy(xpath = "//label[contains(text(),'About Yourself')]/following-sibling::textarea")
    WebElement about;

    @FindBy(xpath = "//label[contains(text(),'Country')]/following-sibling::select")
    WebElement country;

    @FindBy(css = "div.registration_form > form > fieldset:nth-child(5) > div:nth-child(2) > select")
    WebElement month;

    @FindBy(css = "div.registration_form > form > fieldset:nth-child(5) > div:nth-child(3) > select")
    WebElement day;

    @FindBy(css = "div.registration_form > form > fieldset:nth-child(5) > div:nth-child(4) > select")
    WebElement year;

    @FindBy(css = "input[type='submit']")
    WebElement submitBtn;


    public Select selectCountry(){
        return new Select(country);
    }

    public Select selectDay(){
        return new Select(day);
    }

    public Select selectYear(){
        return new Select(year);
    }

    public Select selectMonth(){
        return new Select(month);
    }


    public void setFirstName(String fname) {
        firstName.clear();
        firstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        lastName.clear();
        lastName.sendKeys(lname);
    }

    public void setMaritalStatus(String mstates) {
        Iterator<WebElement> it = maritalStatus.listIterator();
        while (it.hasNext()) {
            if(it.next().getText().equals(mstates)) {
                it.next().click();
            }
        }
    }

    public void setHobby(String hb) {
        Iterator<WebElement> it = hobby.listIterator();
        while (it.hasNext()) {
            if(it.next().getText().equals(hb)) {
                it.next().click();
            }
        }
    }


    public void setPhone(String ph) {
        phone.clear();
        phone.sendKeys(ph);
    }

    public void setUsername(String un) {
        username.clear();
        username.sendKeys(un);
    }

    public void setEmail(String em) {
        email.clear();
        email.sendKeys(em);
    }

    public void setPassword(String pw) {
        password.clear();
        password.sendKeys(pw);
    }

    public void setCpassword(String cpw) {
        cpassword.clear();
        cpassword.sendKeys(cpw);
    }

    public void setAbout(String ab) {
        about.clear();
        about.sendKeys(ab);
    }

    public void setCountry(String cn) {
        selectCountry().selectByVisibleText(cn);
    }

    public void setMonth(String mn) {
        selectMonth().selectByVisibleText(mn);
    }

    public void setDay(String dy) {
        selectDay().selectByVisibleText(dy);
    }

    public void setYear(String yr) {
        selectYear().selectByVisibleText(yr);
    }

    public void setSubmitBtn() {
        submitBtn.click();
    }

}
