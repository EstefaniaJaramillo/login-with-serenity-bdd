package com.test.login.stepdefinitions;

import com.test.login.tasks.CallUrl;
import com.test.login.tasks.Login;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;
import java.util.Map;

import static com.test.login.userinterfaces.Inbox.WRITE_BUTTON;
import static com.test.login.userinterfaces.Login.PASSWORD_ERROR_TEXT;
import static com.test.login.userinterfaces.Login.USERNAME_ERROR_TEXT;
import static com.test.login.userinterfaces.Url.GMAIL_LOGIN_URL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GmailLoginStepDefinition {

    private static final String ACTOR = "User";

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^The user was on the Gmail Login page$")
    public void theUserWasOnTheGmailLoginPage() {
        theActorCalled(ACTOR).attemptsTo(
                CallUrl.toBrowse(GMAIL_LOGIN_URL)
        );
    }


    @When("^He enters his correct username and password$")
    public void heEntersHisCorrectUsernameAndPassword(List<Map<String, String>> credentials) {
        theActorInTheSpotlight().attemptsTo(
                Login.toGmail(credentials.get(0).get("username"), credentials.get(0).get("password"))
        );
    }

    @Then("^The user should access his inbox$")
    public void theUserShouldAccessHisInbox() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(WRITE_BUTTON).isDisplayed()
        );
    }

    @When("^He enters a invalid (.*)$")
    public void heEntersAInvalidUsername(String username) {
        theActorInTheSpotlight().attemptsTo(
                Login.toGmail(username)
        );
    }

    @Then("^The user should see the error (.*)$")
    public void theUserShouldSeeTheError(String errorMessage) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(USERNAME_ERROR_TEXT).text().isEqualTo(errorMessage)
        );
    }

    @When("^He enters his correct (.*) and invalid (.*)$")
    public void heEntersHisCorrectUsernameAndInvalidPassword(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.toGmail(username, password)
        );
    }

    @Then("^The user should see the incorrect password error (.*)$")
    public void theUserShouldSeeTheIncorrectPasswordError(String errorMessage) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(PASSWORD_ERROR_TEXT).text().startsWith(errorMessage)
        );
    }
}
