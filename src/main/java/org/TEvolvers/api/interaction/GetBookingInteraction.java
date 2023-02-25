package org.TEvolvers.api.interaction;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class GetBookingInteraction implements Interaction {
    private int reservation;

    public static GetBookingInteraction dataReservation(int reservation) {
        return instrumented(GetBookingInteraction.class, reservation);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("/booking/" + reservation));
    }
}