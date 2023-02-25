package org.TEvolvers.api.task;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.TEvolvers.api.interaction.GetBookingInteraction;

@AllArgsConstructor
public class GetBookingTask implements Task {
    private int reservation;

    public static GetBookingTask infoReservation(int reservation) {
        return new GetBookingTask(reservation);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetBookingInteraction.dataReservation(reservation));

    }
}