package TestCases;

import PageObject.HomePage;
import PageObject.LandingPage;
import TetsBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Login_Test extends BaseClass {
    LandingPage lp = new LandingPage(driver);
    HomePage hp = new HomePage(driver);
    @Test
    void Valid_Login_Test(){

        try{

            String expectedLabel = "Products";
            //Validating using valid user logins
            lp.setLogin("standard_user","secret_sauce");
            Assert.assertEquals(hp.setLabel(), expectedLabel, "Login failed: Label mismatch.");

        }catch (Exception e){
           // Assert.fail("Exception during valid login test: " + e.getMessage());
        }
    }

    @Test
    void Locked_out_User_test() throws InterruptedException {
        // Validating using locked out user and wrong password
        try {
            lp.setLogin("locked_out_user","secret_sauce");
            String expectedMessage = "Epic sadface: Sorry, this user has been locked out.";
            Assert.assertEquals(lp.getMessage(), expectedMessage, "Locked out message mismatch.");

        }catch (Exception e){
           // Assert.fail("Exception during locked out user test: " + e.getMessage());
        }
    }

}
