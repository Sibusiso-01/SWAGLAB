package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//span[@class='fa-layers-counter shopping_cart_badge']")
    WebElement cartbadge;

    @FindBy(xpath="//div[normalize-space()='Sauce Labs Backpack']") WebElement sauce_backpack;
    @FindBy(xpath="//div[normalize-space()='Sauce Labs Bolt T-Shirt']") WebElement sauce_T_shirt;

    @FindBy(xpath="(//div[@class='cart_quantity'][normalize-space()='1'])[1]")
    WebElement backpackQuantity;

    @FindBy(xpath="(//div[@class='cart_quantity'][normalize-space()='1'])[2]")
    WebElement shirtQuantity;
    @FindBy(xpath="//a[normalize-space()='CHECKOUT']") WebElement checkout_btn;
    @FindBy(xpath="//div[@id='cart_contents_container']//div[3]//div[2]//div[2]//button[1]") WebElement btn_remove_item;
    @FindBy(xpath="//div[@class='cart_list']")
    List <WebElement>  cart_items;
    public String setSauce_Backpack_ItemNames(){
        String item = sauce_backpack.getText();
        return  item;
    }
    public  String setSauce_T_Shirt(){
        String item = sauce_T_shirt.getText();
        return  item;
    }

    //Get the item list

    // Items count
    public int getCartCount(){
        return Integer.parseInt(cartbadge.getText());
    }

    public void setBtn_remove_item(){btn_remove_item.click();}

    public void setCheckout_btn(){
        checkout_btn.click();
    }

    //Quantity check
    public int getBagQTY(){
        return Integer.parseInt(backpackQuantity.getText());
    }
    public int getShirtQTY(){
        return Integer.parseInt(shirtQuantity.getText());
    }


}
