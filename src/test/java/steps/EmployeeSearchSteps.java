package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class EmployeeSearchSteps {
        public WebDriver driver;

        @When("user clicks on PIM option and Employee list option")
        public void user_clicks_on_pim_option_and_employee_list_option() {
      //we are clicking on pim and emp list option
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimOption.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement EmpListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        EmpListOption.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        WebElement searchIdTextBox = driver.findElement(By.id("empsearch_id"));
        searchIdTextBox.sendKeys("54469A");

    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
       WebElement searchButton = driver.findElement(By.id("searchBtn"));
       searchButton.click();
    }

    @Then("user is able to see employee information")
    public void user_is_able_to_see_employee_information() {
        System.out.println("Employee is displayed");
    }
}
