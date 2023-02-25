package org.TEvolvers.api.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.TEvolvers.api.interaction.CreateBookingInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateReservationTask implements Task {
    public static CreateReservationTask inBooking() {
        return instrumented(CreateReservationTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CreateBookingInteraction.dataReservation());
    }
}