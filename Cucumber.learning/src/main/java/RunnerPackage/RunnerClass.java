package RunnerPackage;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFile/openGoogle.feature", glue = "StepPackage")
public class RunnerClass {

}
@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFile/DataTableExample2.feature",glue = "StepPackage")
 class dataTableExample2 {
	
}
@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFile/DataTableExample1.feature",glue = "StepPackage")
 class dataTableExample1 {

}