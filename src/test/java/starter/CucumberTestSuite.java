package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/",
        dryRun = false,
        monochrome = true,
        tags = "@temp12"
       // glue="stepdefinations"
)
public class CucumberTestSuite {}
