package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LandingPage extends BasePage{

    public LandingPage(WebDriver driver){super(driver);}
    @FindBy(xpath="//input[@id='user-name']")
    WebElement username;
    @FindBy(xpath="//input[@id='password']") WebElement password;
    @FindBy(xpath="//input[@id='login-button']") WebElement login_btn;
    @FindBy(xpath="//h3[@data-test='error']") WebElement error_message;
    @FindBy(xpath="//h3[normalize-space()='Epic sadface: Username is required']") WebElement username_error;

    //Login method
    public void setLogin(String name, String Password){
        username.sendKeys(name);
        password.sendKeys(Password);
        login_btn.click();
    }
    //Locked out user with wrong password method
    String message;

    public String getMessage(){
        //Getting the actual error message
        String actual_message = error_message.getText();
        return actual_message;
    }
    public String getUserError(){
        String message = username_error.getText();
        return message;
    }
}
