package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPage extends BasePage{
    public SummaryPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath="//div[normalize-space()='Sauce Labs Backpack']")
    WebElement backpack;
    @FindBy(xpath="//div[normalize-space()='Sauce Labs Bolt T-Shirt']") WebElement T_Shirt;
    @FindBy(xpath="//a[normalize-space()='FINISH']") WebElement btn_finish;
    @FindBy(xpath="//h2[normalize-space()='THANK YOU FOR YOUR ORDER']") WebElement checkout_message;
    public String setSauce_Backpack_ItemNames(){
        String item = backpack.getText();
        return  item;
    }
    public  String setSauce_T_Shirt(){
        String item = T_Shirt.getText();
        return  item;
    }

    public void setBtn_finish(){
        btn_finish.click();
    }
    public String getCheckoutMessage(){
        return  checkout_message.getText();
    }
}
