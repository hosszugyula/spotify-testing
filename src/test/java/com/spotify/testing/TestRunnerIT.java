package com.spotify.testing;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.spotify.testing",
        stepNotifications = true,
        plugin = {"pretty", "html:target/test-report.html"}
)
public class TestRunnerIT {

}
