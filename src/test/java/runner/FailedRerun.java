package runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"pretty","html:TestOutput/cucumber-reports.html","rerun:TestOutput/failedrerun.txt"},
features = {"@TestOutput/failedrerun.txt"},
glue = {"stepDefinition","hooks"},
monochrome=true
)

public class FailedRerun {

}
