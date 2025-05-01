package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    //Constructor to initiate the web driver
    public HomePage(WebDriver driver){super(driver);}

    @FindBy(xpath="//div[@class='product_label']")
    WebElement label;
    @FindBy(xpath = "//div[@class='inventory_item' and .//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']]//button")
    WebElement addToCart_Backpack;
    @FindBy(xpath = "//div[@class='inventory_item' and .//div[@class='inventory_item_name' and text()='Sauce Labs Bolt T-Shirt']]//button")
    WebElement addToCart_T_shirt;
    @FindBy(xpath="//*[name()='path' and contains(@fill,'currentCol')]") WebElement cart;
    public String setLabel(){
        String actual = label.getText();
        return actual;
    }

    public void setAddToCart()
    {
        addToCart_Backpack.click();
        addToCart_T_shirt.click();
    }

    public void setCart() {
        cart.click();
    }

    {

    }
}
