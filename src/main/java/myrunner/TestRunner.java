package myrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\DesktopApplication\\fdsf\\src\\main\\java\\features\\whatsapp.feature",  
glue = {"stepdevination"},
plugin = {"html:target/cucumber-html-report" },
//strict = true,
//dryRun = true,
monochrome = true)
public class TestRunner{

}

// ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as
// @SmokeTest OR @RegressionTest
// ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests
// tagged as @SmokeTest AND @RegressionTest
/*
 * format= {"pretty","html:test-outout", "json:json_output/cucumber.json",
 * "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
 * monochrome = true, //display the console output in a proper readable format
 * strict = true, //it will check if any step is not defined in step definition
 * file dryRun = false //to check the mapping is proper between feature file and
 * step def file //tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}
 */
//plugin = {"pretty", "html:target/cucumber-html-report" },