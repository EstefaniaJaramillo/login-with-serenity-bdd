package com.test.login.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/gmail_login.feature",
        glue = "com.test.login.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class GmailLogin {
}
