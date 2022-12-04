package com.tmt.cucumber;

import io.cucumber.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.tmt.cucumber"},
        plugin = {
                "pretty", "html:target/cucumber-reports/html/report.html",
                "json:target/cucumber-reports/json/report.json",
                "junit:target/cucumber-reports/junit/report.xml"
        }
)
public class CucumberTest {
}
