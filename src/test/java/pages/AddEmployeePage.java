package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id="firstName")
    public WebElement firstNameField;

    @FindBy(id="lastName")
    public WebElement lastNameField;

    @FindBy(id="middleName")
    public WebElement middleNameField;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(id="photofile")
    public WebElement photograph;

    @FindBy(id="employeeId")
    public WebElement employeeIdField;

    @FindBy(id="chkLogin")
    public WebElement checkBoxLocator;

    @FindBy(id="user_name")
    public WebElement usernameTextFieldBox;

    @FindBy(id="user_password")
    public WebElement passwordTextFieldBox;

    @FindBy(id="re_password")
    public WebElement confirmPasswordBox;

    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }
}
