package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
      //  WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
     //   pimOption.click();
        click(dashboardPage.pimOption);
    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
     //   WebElement addEmployeeBUtton = driver.findElement(By.id("menu_pim_addEmployee"));
       // addEmployeeBUtton.click();
        click(dashboardPage.addEmployeeButton);
    }

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
      //  WebElement firstNameTextField = driver.findElement(By.id("firstName"));
       // firstNameTextField.sendKeys("aendro");
        sendText("aendro", addEmployeePage.firstNameField);

       // WebElement lastNameTextField = driver.findElement(By.id("lastName"));
       // lastNameTextField.sendKeys("farewell");
        sendText("farewell", addEmployeePage.lastNameField);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
     //   WebElement saveButton = driver.findElement(By.id("btnSave"));
       // saveButton.click();
        click(addEmployeePage.saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstName, String middleName, String lastName) {
       sendText(firstName, addEmployeePage.firstNameField);
       sendText(middleName, addEmployeePage.middleNameField);
       sendText(lastName, addEmployeePage.lastNameField);
    }

}
