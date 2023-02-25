package org.TEvolvers.api.interaction;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.TEvolvers.api.builders.CreateSessionBuilder;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateInteraction implements Interaction {


    public static CreateInteraction successfulSession() {
        return instrumented((CreateInteraction.class));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/auth")
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(CreateSessionBuilder.getToken())));
        Serenity.setSessionVariable("token").to(saveToken());
    }

    public static String saveToken() {
        String tokenSession = (SerenityRest.lastResponse().body().jsonPath().getString("token"));
        return tokenSession;
    }

    public static String generateToken() {

        return Serenity.sessionVariableCalled("token");
    }
}