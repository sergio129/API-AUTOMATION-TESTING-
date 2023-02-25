package org.TEvolvers.api.Task;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.TEvolvers.api.Interaction.GetBookingInteraction;

@AllArgsConstructor
public class GetBookingTask implements Task {
    private int reserva;
    public static GetBookingTask datosGetBooking(int reserva){
        return new GetBookingTask(reserva);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetBookingInteraction.dataInteraction(reserva));

    }
}
