package TestCases;

import PageObject.CartPage;
import PageObject.HomePage;
import PageObject.LandingPage;
import TetsBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Remove_From_Cart_Test extends BaseClass {
    @Test
    void remove_from_cart(){
        try {
            CartPage cp = new CartPage(driver);
            LandingPage lp = new LandingPage(driver);
            HomePage hp = new HomePage(driver);
            // Step 1: Login
            lp.setLogin("standard_user","secret_sauce");
            // Step 2: Add items to cart
            hp.setAddToCart();
            hp.setCart();
            // Step 3: Remove one item
            cp.setBtn_remove_item();
            int expectedCartCount = 1;
            int actualCartCount = cp.getCartCount();
            Assert.assertEquals(actualCartCount, expectedCartCount, "Cart item count after removal is incorrect.");

        } catch (Exception e) {

        }
    }
}
