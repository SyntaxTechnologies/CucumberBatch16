package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
      features = "src/test/resources/features/",
      //glue keyword we use to provide the package where step defs are available
      glue = "steps"
)



public class RunnerClass {

}
