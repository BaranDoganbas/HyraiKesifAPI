package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/json-reports/cucumber.json",
                "rerun:target/failed_scenarios.txt"
        },
        monochrome = true,
        features = "./src/test/resources/apifeatures",
        glue = {"stepdefinitions", "hooks"},
        dryRun = false,
        tags = "@hyrai"
)
public class Runner {
}