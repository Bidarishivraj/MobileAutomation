package com.qa.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "summary"}
        ,features = {"src/test/resources"}
        ,glue = {"com.qa.stepdef"}
        ,snippets = CAMELCASE
        ,dryRun=true
        ,monochrome=true
        //,tags = "@foo and not @bar"
        //"html:target/cucumber.html"


)
public class MyRunnerTest {

}
