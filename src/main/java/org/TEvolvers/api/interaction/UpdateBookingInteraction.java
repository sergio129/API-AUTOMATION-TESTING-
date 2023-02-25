package org.TEvolvers.api.interaction;

import io.restassured.http.ContentType;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.TEvolvers.api.builders.UpdateReservationBuilder;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class UpdateBookingInteraction implements Interaction {
    private int reservation;

    public static UpdateBookingInteraction dataReservation(int reservation) {
        return instrumented(UpdateBookingInteraction.class, reservation);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to("/booking/" + reservation)
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .cookie("token=" + CreateInteraction.generateToken())
                        .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                        .body(UpdateReservationBuilder.sendUpdateBookingBuilder())));
    }
}
