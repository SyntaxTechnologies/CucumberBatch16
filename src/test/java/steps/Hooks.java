package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void start(){
        openBrowserAndNavigateToURL();
    }

    @After
    public void end(Scenario scenario){
        //we need this variable because my ss method returns array of byte
        byte[] pic;
        //here we are going to capture the screenshot and attaching it to the report
        if(scenario.isFailed()) {
            pic = takeScreenshot("failed/" + scenario.getName());
        }else {
            pic = takeScreenshot("passed/" + scenario.getName());
        }
        //attach this screenshot in the report
        scenario.attach(pic,"image/png",scenario.getName());
        closeBrowser();
    }
}
