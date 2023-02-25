package org.TEvolvers.api.Interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;


public class GetInteraction extends RestInteraction {

    private final String resource;

    public GetInteraction(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().get(as(actor).resolve(resource)).then().log().all();
    }

    public static GetInteraction resource(String resource) {
        return instrumented(GetInteraction.class, resource);
    }
}
