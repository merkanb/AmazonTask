package com.amazon.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports.html",
                "rerun:target/rerun.txt"},            // create a rerun file, define failed TC in it
        features = "src/test/resources/Features",
        glue = "com/amazon/stepDefs",
//       dryRun = true,
        dryRun = false,

        tags = "@wip2"

)
public class CukesRunner {

}
