package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.CommonMethods;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class AddJobSteps extends CommonMethods {

    String jTitleFE;
    String jDescFE;
    String jNoteFE;

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
        sendText(title, jobPage.jobTitleF);
        jTitleFE = title;
    }

    @Then("user enters job description {string}")
    public void user_enters_job_description(String jobDescription) {
        sendText(jobDescription, jobPage.jobDescF);
        jDescFE = jobDescription;
    }

    @Then("user enters job note {string}")
    public void user_enters_job_note(String note) {
        sendText(note, jobPage.jobNoteF);
        jNoteFE = note;
    }

    @Then("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        click(jobPage.jobSvBtn);
    }

    @Then("verify data is stored properly in database")
    public void verify_data_is_stored_properly_in_database() {
        String query = "select * from ohrm_job_title where job_title='" + jTitleFE + "' and job_description='" + jDescFE + "' and note='" + jNoteFE + "';";
        List<Map<String, String>> data = DBUtils.fetch(query);
        Map<String,String> firstROw=data.get(0);
        String jTitleBE=firstROw.get("job_title");
        String jDescBE=firstROw.get("job_description");
        String jNoteBE=firstROw.get("note");

        Assert.assertEquals(jTitleFE,jTitleBE);
        Assert.assertEquals(jDescFE,jDescBE);
        Assert.assertEquals(jNoteFE,jNoteBE);

    }

}
