package com.test.login.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Login {
    public static final Target USERNAME_INPUT = Target.the("Username input").locatedBy("//input[@id=\"identifierId\"]");
    public static final Target PASSWORD_INPUT = Target.the("Password input").locatedBy("//input[@name=\"password\"]");
    public static final Target USERNAME_ERROR_TEXT = Target.the("Username Error text").locatedBy("//div[@class=\"o6cuMc\"]");
    public static final Target PASSWORD_ERROR_TEXT = Target.the("Password Error text").locatedBy("//div[@jsname=\"B34EJ\"]/span");
}
