package org.TEvolvers.api.interaction;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.TEvolvers.api.builders.CreateReservationBuilder;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateBookingInteraction implements Interaction {

    public static CreateBookingInteraction dataReservation() {
        return instrumented(CreateBookingInteraction.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/booking")
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(CreateReservationBuilder.getRequest())));
    }
}