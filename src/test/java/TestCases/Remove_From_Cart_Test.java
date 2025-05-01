package TestCases;

import PageObject.CartPage;
import PageObject.HomePage;
import PageObject.LandingPage;
import TetsBase.BaseClass;
import org.testng.Assert;

public class Remove_From_Cart_Test extends BaseClass {

    void remove_from_cart(){
        try {
            CartPage cp = new CartPage(driver);
            LandingPage lp = new LandingPage(driver);
            lp.setLogin("standard_user","secret_sauce");
            HomePage hp = new HomePage(driver);
            hp.setAddToCart();
            hp.setCart();
            cp.setBtn_remove_item();
            int totalcount =1;
            if(totalcount == cp.getCartCount()) {
                Assert.assertTrue(true);
            }else {
                Assert.fail();
            }

        } catch (Exception e) {

        }
    }
}
