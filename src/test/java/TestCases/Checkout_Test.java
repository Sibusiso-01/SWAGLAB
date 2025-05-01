package TestCases;

import PageObject.CartPage;
import PageObject.CheckoutPage;
import PageObject.SummaryPage;
import TetsBase.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;




public class Checkout_Test extends BaseClass {


    @Test
    void checkoutTest(){
        try {

            CartPage cp = new CartPage(driver);
            SummaryPage sp = new SummaryPage(driver);
            CheckoutPage chp = new CheckoutPage(driver);

            cp.setCheckout_btn();
            chp.setFirstname();
            chp.setLastname();
            chp.setZipcode();
            chp.setContinue_btn();

            if(sp.setSauce_Backpack_ItemNames().equals("Sauce Labs Backpack")
                    && sp.setSauce_T_Shirt().equals("Sauce Labs Bolt T-Shirt")){
                Assert.assertTrue(true);
            }else {
                Assert.fail();
            }

            sp.setBtn_finish();
            if(sp.getCheckoutMessage().equals("THANK YOU FOR YOUR ORDER")){
                Assert.assertTrue(true);
            }else {
                Assert.fail();
            }
        }catch (Exception e){

        }


    }

}
