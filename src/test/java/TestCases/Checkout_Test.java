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

            // Start checkout process
            cp.setCheckout_btn();

            // Fill checkout details
            chp.setFirstname();
            chp.setLastname();
            chp.setZipcode();
            chp.setContinue_btn();

            // Assertions for item names
            String actualItem1 = sp.setSauce_Backpack_ItemNames();
            String actualItem2 = sp.setSauce_T_Shirt();
            Assert.assertEquals(actualItem1, "Sauce Labs Backpack", "Item 1 name is incorrect.");
            Assert.assertEquals(actualItem2, "Sauce Labs Bolt T-Shirt", "Item 2 name is incorrect.");


            // Complete checkout
            sp.setBtn_finish();
            // Assert checkout success message
            String actualMessage = sp.getCheckoutMessage();
            Assert.assertEquals(actualMessage, "THANK YOU FOR YOUR ORDER", "Order confirmation message mismatch.");
        }catch (Exception e){

        }


    }

}
