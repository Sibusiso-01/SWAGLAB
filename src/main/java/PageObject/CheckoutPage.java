package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@id='first-name']")
    WebElement firstname;
    @FindBy(xpath="//input[@id='last-name']") WebElement lastname;
    @FindBy(xpath="//input[@id='postal-code']") WebElement zipcode;
    @FindBy(xpath="//input[@value='CONTINUE']") WebElement continue_btn;
    @FindBy(xpath="//div[normalize-space()='Sauce Labs Backpack']") WebElement sauce_backpack;
    @FindBy(xpath="//div[normalize-space()='Sauce Labs Bolt T-Shirt']") WebElement sauce_t_shirt;
    @FindBy(xpath="//a[normalize-space()='FINISH']") WebElement finish_btn;

    public void setFirstname(){
        firstname.sendKeys("Sizwe");
    }
    public void setLastname(){
        lastname.sendKeys("Nkosi");
    }
    public void setZipcode(){
        zipcode.sendKeys("1777");
    }
    public void setContinue_btn(){
        continue_btn.click();
    }
    public String setSauceBag(){
        String item = sauce_backpack.getText();
        return  item;
    }
    public  String setSauce_T_Shirt(){
        String item = sauce_t_shirt.getText();
        return  item;
    }

    public void setFinish_btn() {
       finish_btn.click();
    }
}
