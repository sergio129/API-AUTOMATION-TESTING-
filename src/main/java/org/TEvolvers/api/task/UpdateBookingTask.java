package org.TEvolvers.api.task;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.TEvolvers.api.interaction.UpdateBookingInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class UpdateBookingTask implements Task {
    private int reservation;

    public static UpdateBookingTask reservation(int reservation) {
        return instrumented(UpdateBookingTask.class, reservation);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                UpdateBookingInteraction.dataReservation(reservation));
    }
}