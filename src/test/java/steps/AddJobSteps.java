package steps;

import io.cucumber.java.en.Then;
import pages.JobPage;
import utils.CommonMethods;

import static steps.PageInitializer.jobPage;

public class AddJobSteps extends CommonMethods {

    @Then("user clicks on the admin button")
    public void user_clicks_on_the_admin_button() {
    click(dashboardPage.adminButton);
    }
    @Then("user click on the job")
    public void user_click_on_the_job() {
     click(dashboardPage.adminJobButton);
    }
    @Then("user Click on Job Title")
    public void user_click_on_job_title() {
       click(dashboardPage.adminJobJobTitleButton);
    }
    @Then("user clicks on the add button")
    public void user_clicks_on_the_add_button() {

    }
    @Then("user enters job {string} title")
    public void user_enters_job_title(String string) {

    }
    @Then("user enters job description {string}")
    public void user_enters_job_description(String string) {

    }

    @Then("user enters job note {string}")
    public void user_enters_job_note(String string) {

    }
    @Then("user clicks on the save button")
    public void user_clicks_on_the_save_button() {

    }
    @Then("verify data is stored properly in database")
    public void verify_data_is_stored_properly_in_database() {

    }

}
