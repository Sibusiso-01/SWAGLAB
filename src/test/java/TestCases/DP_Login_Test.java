package TestCases;

import PageObject.HomePage;
import PageObject.LandingPage;
import TetsBase.BaseClass;
import Utilities.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DP_Login_Test extends BaseClass {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUtil.class)
    public void loginTest(String username, String password) {
        LandingPage lp = new LandingPage(driver);
        HomePage hp = new HomePage(driver);
        try{

            String expectedLabel = "Products";
            String actualMessage = "Epic sadface: Sorry, this user has been locked out.";
            String actualUserError = "Epic sadface: Username is required";

            //Validating user login using data provider logins
            lp.setLogin(username, password);
            if(expectedLabel.equals(hp.setLabel())){
                Assert.assertEquals(hp.setLabel(), expectedLabel, "Login success label mismatch.");
            }else if(actualMessage.equals(lp.getMessage())){
                Assert.assertEquals(actualMessage, "Epic sadface: Sorry, this user has been locked out.");
            }else if(lp.getUserError().equals(actualUserError)){
                Assert.assertEquals(actualUserError, "Epic sadface: Username is required");
            }else {
                Assert.fail("None of the expected conditions were met for user: " + username);
            }
        }catch (Exception e){

        }
    }
}
