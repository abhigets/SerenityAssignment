package net.gmbh.solutions.questions;

import net.gmbh.solutions.ui.AllUsers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;

public class AllUsersContainsUser implements Question<Boolean> {
    String userName;

    public AllUsersContainsUser(String userName) {
        this.userName = userName ;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Presence.of(AllUsers.locateUser(userName)).viewedBy(actor).asBoolean();
    }
}
