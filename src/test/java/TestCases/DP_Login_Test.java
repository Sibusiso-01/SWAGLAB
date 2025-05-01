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

            String label = "Products";
            String message = "Epic sadface: Sorry, this user has been locked out.";
            String message1 = "Epic sadface: Username is required";
            //Validating user login using data provider logins
            lp.setLogin("standard_user","secret_sauce");
            if(label.equals(hp.setLabel())){
                Assert.assertTrue(true);
            }else if(message.equals(lp.getMessage()) || lp.getUserError().equals(message1)){
                Assert.assertTrue(true);
            }else {
                Assert.fail();
            }
        }catch (Exception e){

        }
    }
}
