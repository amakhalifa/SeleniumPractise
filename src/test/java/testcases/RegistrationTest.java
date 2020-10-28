package testcases;

import base.Testbase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTest extends Testbase {

    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage rp;

    public RegistrationTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initConfiguration();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        rp = homePage.clickOnRegistrationLink();
    }


    @Test
    public void registerUser()
    {
        //verify on Registration page
//        Assert.assertTrue(rp.isPageOpen());
        rp.setFirstName("test");
        rp.setLastName("test");
        rp.setMaritalStatus("Married");
        rp.setHobby("Reading");
        rp.setPhone("123456789");
        rp.setEmail("test@yahoo.com");
        rp.setUsername("test");
        rp.setPassword("testtest");
        rp.setCpassword("testtest");
        rp.setAbout("I love football");
        rp.setCountry("India");
        rp.setMonth("1");
        rp.setDay("1");
        rp.setYear("2014");
        /*try {
            rp.uploadFile("/Users/admin/amandaprofilepic.jpg");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        rp.setSubmitBtn();
    }

    @AfterMethod
    public void tearDown() {
        quitBrowser();
    }
}
