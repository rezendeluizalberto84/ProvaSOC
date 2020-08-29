package ProvaSocCucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Buscar_no_blog.feature",
        glue = "",
        //tags = {},
        plugin = {"pretty", "html:target/report-html", "json:target/report.jason"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
        //strict = false
)

public class RunnerTest {

}
