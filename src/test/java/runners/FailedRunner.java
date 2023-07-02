package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //in failed runner just 2 things are required, features and glue
        //features we use to provide the path of all the feature files
        features = "@target/failed.txt",
        //glue keyword we use to provide the package where step defs are available
        glue = "steps",
        //when dry run is true, it stops actual execution, it quickly scans all the steps and will
        //provide the missing step definition
       // dryRun = false,
       // tags = "@login1",
        //it means sometimes the console output for cucumber test is having some
        //irrelevant information, when you set it to true, it removes all that
        //irrelevant information from the console and will give you simple output
      //  monochrome = true,
        //it used to print all the steps in console
        //html plugin is generating the report, this report will be generated under target folder
        plugin = {"pretty"}
)

public class FailedRunner {


}
