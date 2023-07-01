package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    //this is object repository of POM

    @FindBy(xpath="//*[@id='txtUsername']")
    public WebElement usernameField;

    @FindBy(id="txtPassword")
    public WebElement passwordField;

    @FindBy(id="btnLogin")
    public WebElement loginButton;

    @FindBy(id="spanMessage")
    public WebElement errorMessageField;

   //to initialize all the elements of this page we have to call them inside constructor
   public LoginPage(){
       PageFactory.initElements(driver, this);
   }

}
