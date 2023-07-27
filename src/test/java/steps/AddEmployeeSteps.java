package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.DBUtils;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    String fnFirstName;
    String fnMiddleName;
    String fnLastName;
    String empId;

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

        this.fnFirstName = firstName;
        this.fnMiddleName = middleName;
        this.fnLastName = lastName;
        sendText(firstName, addEmployeePage.firstNameField);
        sendText(middleName, addEmployeePage.middleNameField);
        sendText(lastName, addEmployeePage.lastNameField);
        empId = addEmployeePage.employeeIdField.getAttribute("value");
    }


    @When("user enters {string} and {string} and {string} in data driven format")
    public void user_enters_and_and_in_data_driven_format(String firstName, String middleName, String lastName) {
        sendText(firstName, addEmployeePage.firstNameField);
        sendText(middleName, addEmployeePage.middleNameField);
        sendText(lastName, addEmployeePage.lastNameField);
    }

    @When("user enters firstname and middlename and lastname and verify employee has added")
    public void user_enters_firstname_and_middlename_and_lastname_and_verify_employee_has_added
            (io.cucumber.datatable.DataTable dataTable) {
        //we need list of maps to get multiple values from datatable which is coming
        // from feature file
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        for (Map<String, String> employee : employeeNames
        ) {
            //getting the values against the key in map
            String firstNameValue = employee.get("firstName");
            String middleNameValue = employee.get("middleName");
            String lastNameValue = employee.get("lastName");

            //filling the name in the fields
            sendText(firstNameValue, addEmployeePage.firstNameField);
            sendText(middleNameValue, addEmployeePage.middleNameField);
            sendText(lastNameValue, addEmployeePage.lastNameField);
            click(addEmployeePage.saveButton);
            //after adding one employee, we will add another employee
            //for this, we are clicking on add employee button in the loop ittself
            click(dashboardPage.addEmployeeButton);
        }
    }

    @When("user adds multiple employees using excel from {string} and verify it")
    public void user_adds_multiple_employees_using_excel_from_and_verify_it
            (String sheetName) throws InterruptedException {
        //here we are getting the data from excel file using parameters
        List<Map<String, String>> newEmployees =
                ExcelReader.read(sheetName, Constants.EXCEL_READER_PATH);

        Iterator<Map<String, String>> itr = newEmployees.iterator();

        //it will check whether we have new element/value or not
        while (itr.hasNext()) {

            //in this map, we have data from every single employee one by one it will give us that data
            Map<String, String> mapNewEmp = itr.next();
            //we are filling the employee data now using mapNewEmp variable
            //BATCH 16, KEYS WHAT WE ARE PASSING HERE SHOULD MATCH WITH THE KEYS IN EXCEL
            sendText(mapNewEmp.get("firstName"), addEmployeePage.firstNameField);
            sendText(mapNewEmp.get("lastName"), addEmployeePage.lastNameField);
            sendText(mapNewEmp.get("middleName"), addEmployeePage.middleNameField);
            sendText(mapNewEmp.get("photograph"), addEmployeePage.photograph);

            //we can enter username and password only after selecting the checkbox
            if (!addEmployeePage.checkBoxLocator.isSelected()) {
                click(addEmployeePage.checkBoxLocator);
            }
            sendText(mapNewEmp.get("username"), addEmployeePage.usernameTextFieldBox);
            sendText(mapNewEmp.get("password"), addEmployeePage.passwordTextFieldBox);
            sendText(mapNewEmp.get("confirmPassword"), addEmployeePage.confirmPasswordBox);

            //here we are fetching the employee id from the UI using get attribute method
            String empIdValue = addEmployeePage.employeeIdField.getAttribute("value");
            Assert.assertTrue(addEmployeePage.saveButton.isDisplayed());
            click(addEmployeePage.saveButton);
            Thread.sleep(3000);
            //we have to verify that the employee has been added
            click(dashboardPage.empListOption);
            //searching the employee using emp id which we just got
            sendText(empIdValue, employeeSearchPage.idTextField);
            click(employeeSearchPage.searchButton);

            //print the value from the table row
            List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for (int i = 0; i < rowData.size(); i++) {
                System.out.println("I am inside the loop");
                //it will return one by one all the data from the row
                String rowText = rowData.get(i).getText();
                //it will print the complete row data
                //output of this will be empid firstname middlename lastname
                System.out.println(rowText);
                //we have to verify this data against the data coming from excel

                String expectedData = empIdValue + " " + mapNewEmp.get("firstName") + " " +
                        mapNewEmp.get("middleName") + " " + mapNewEmp.get("lastName");

                Assert.assertEquals(expectedData, rowText);
                //you can use below code too to verify the data
                //  Assert.assertTrue(expectedData.equals(rowText));
            }
            //to add more employees we need to click on add employee button
            click(dashboardPage.addEmployeeButton);
        }

    }


    @Then("verify employee is stored in database")
    public void verifyEmployeeIsStoredInDatabase() {
        String query = "select emp_firstName,emp_middle_name,emp_lastname from hs_hr_employees where employee_id=" + empId + ";";
        System.out.println(query);
        List<Map<String, String>> mapList = DBUtils.fetch(query);
        Map<String, String> firstRow = mapList.get(0);
        String dbFirstName=firstRow.get("emp_firstName");
        String dbMiddleName=firstRow.get("emp_middle_name");
        String dbLastName=firstRow.get("emp_lastname");

        Assert.assertEquals("FirstName from frontend does not match the firstname from database", fnFirstName,dbFirstName);
        Assert.assertEquals("MiddleName from frontend does not match the MiddleName from database", fnMiddleName,dbMiddleName);
        Assert.assertEquals("LastName from frontend does not match the LastName from database", fnLastName,dbLastName);


    }
}
