package com.cucumberoptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		stepNotifications=true,
		features="src/test/java/features",
		glue="stepdefinitions",
		plugin = { "pretty", "html:target/cucumber-reports" },
		monochrome = true,
		tags="@TC5"
		)
public class TestRunner {

}
