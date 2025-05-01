package TestCases;

import PageObject.CartPage;
import PageObject.HomePage;
import PageObject.LandingPage;
import TetsBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add_ToCart_Test extends BaseClass {
    LandingPage lp = new LandingPage(driver);
    HomePage hp = new HomePage(driver);
    CartPage cp = new CartPage(driver);
    @Test
    void addToCart() {
        try {
            String label = "Products";
            String bag = "Sauce Labs Backpack";
            String T_shirt = "Sauce Labs Bolt T-Shirt";
            //calling user logins method
            lp.setLogin("standard_user","secret_sauce");

            //Adding items to cart
            hp.setAddToCart();

            // verifying the total number of items added.
            int totalcount =2;
            if(totalcount == cp.getCartCount()) {
                Assert.assertTrue(true);
            }else {
                Assert.fail();
            }

            // validating added items
            hp.setCart();
            Thread.sleep(3000);
            if(bag.equals(cp.setSauce_Backpack_ItemNames()) & T_shirt.equals(cp.setSauce_T_Shirt()))
            {   Assert.assertTrue(true);
            }else {
                Assert.fail();
            }
            // validate quantity of items added

            if(cp.getBagQTY() ==1 && cp.getShirtQTY()==1){
                Assert.assertTrue(true);
            }else{
                Assert.fail();
            }

        } catch (Exception e) {

        }
    }
}
