package com.test.login.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CallUrl implements Task {
    private String url;

    public CallUrl(String url) {
        this.url = url;
    }

    public static CallUrl toBrowse(String url) {
        return instrumented(CallUrl.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
}
