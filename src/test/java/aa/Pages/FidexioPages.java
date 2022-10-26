package aa.Pages;

import aa.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FidexioPages {

    public FidexioPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement UsernameInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement PasswordInput;

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement LoginButton;

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement VerifyUser;

    @FindBy (xpath = "//p[@class='alert alert-danger']")
    public WebElement WrongCredentials;





}