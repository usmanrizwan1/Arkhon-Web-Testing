package com.arkhon.webtesting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = {"src/test/resources/features"},
        features = {"src/test/resources/access_user_settings.feature"},
        plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport.json", "rerun:target/rerun.txt"},
        tags = "@EducationTraining"
)
public class TestRunner {

}
