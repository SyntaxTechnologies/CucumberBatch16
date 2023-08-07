package steps;

import io.cucumber.java.en.Then;
import pages.JobPage;
import utils.CommonMethods;

import static steps.PageInitializer.jobPage;

public class AddJobSteps extends CommonMethods {

    String jTitle;
    String jDesc;
    String jNote;
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
        click(jobPage.addButton);
    }
    @Then("user enters job {string} title")
    public void user_enters_job_title(String title) {
        sendText(title,jobPage.jobTitleF);
        jTitle=title;
    }
    @Then("user enters job description {string}")
    public void user_enters_job_description(String jobDescription) {
        sendText(jobDescription,jobPage.jobDescF);
        jDesc=jobDescription;
    }

    @Then("user enters job note {string}")
    public void user_enters_job_note(String note) {
        sendText(note,jobPage.jobNoteF);
        jNote=note;
    }
    @Then("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        click(jobPage.jobSvBtn);
    }
    @Then("verify data is stored properly in database")
    public void verify_data_is_stored_properly_in_database() {

    }

}
