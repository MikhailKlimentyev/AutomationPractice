package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"classpath:features"},
    glue = "steps",
    tags = "@regression",
    plugin = {"pretty", "html:target/cucumber.html",
        "json:target/cucumber.json"}
)
public class RegressionTest extends AbstractTestNGCucumberTests {
}
