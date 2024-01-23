package runnerPackage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features="src/test/java/features",
		glue ={"steps","hooks"},
		tags = "@book",
		dryRun = !true,
		snippets=SnippetType.CAMELCASE,
		monochrome = true,
		plugin = {"pretty"})
public class RunnerClass extends AbstractTestNGCucumberTests{
 
}
//