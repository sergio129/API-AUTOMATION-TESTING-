package org.TEvolvers.api.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;


public class PutInteraction extends RestInteraction {

    private final String resource;

    public PutInteraction(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().put(as(actor).resolve(resource)).then().log().all();
    }

    public static PutInteraction to(String resource) {
        return instrumented(PutInteraction.class, resource);
    }
}
