package com.test.login.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.test.login.userinterfaces.Login.PASSWORD_INPUT;
import static com.test.login.userinterfaces.Login.USERNAME_INPUT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login(String username) {
        this.username = username;
    }

    public static Login toGmail(String username, String password){
        return instrumented(Login.class, username, password);
    }

    public static Login toGmail(String username){
        return instrumented(Login.class, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(username).into(USERNAME_INPUT).thenHit(Keys.ENTER));
        if (password != null)
            actor.attemptsTo(
                    Enter.theValue(password).into(PASSWORD_INPUT).thenHit(Keys.ENTER)
            );
    }
}
