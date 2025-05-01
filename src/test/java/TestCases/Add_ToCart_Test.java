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

            //calling user logins method
            lp.setLogin("standard_user","secret_sauce");

            //Adding items to cart
            hp.setAddToCart();

            // verifying the total number of items added.
            int expectedCount = 2;
            int actualCount = cp.getCartCount();
            Assert.assertEquals(actualCount, expectedCount, "Cart item count mismatch.");

            // Navigate to cart page
            hp.setCart();

            // Verify item names
            String expectedBag = "Sauce Labs Backpack";
            String expectedShirt = "Sauce Labs Bolt T-Shirt";
            Assert.assertEquals(cp.setSauce_Backpack_ItemNames(), expectedBag, "Backpack name mismatch.");
            Assert.assertEquals(cp.setSauce_T_Shirt(), expectedShirt, "T-Shirt name mismatch.");

            // validate quantity of items added

            Assert.assertEquals(cp.getBagQTY(), 1, "Bag quantity should be 1.");
            Assert.assertEquals(cp.getShirtQTY(), 1, "T-Shirt quantity should be 1.");

        } catch (Exception e) {

        }
    }
}
