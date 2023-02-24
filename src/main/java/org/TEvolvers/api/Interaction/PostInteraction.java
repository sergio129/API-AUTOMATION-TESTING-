package org.TEvolvers.api.Interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;


public class PostInteraction extends RestInteraction {

    private final String resource;

    public PostInteraction(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().post(as(actor).resolve(resource)).then().log().all();
    }

    public static PostInteraction to(String resource) {
        return instrumented(PostInteraction.class, resource);
    }
}
