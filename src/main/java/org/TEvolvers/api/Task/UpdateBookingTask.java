package org.TEvolvers.api.Task;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.TEvolvers.api.Interaction.UpdateBookingInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
@AllArgsConstructor
public class UpdateBookingTask implements Task {
    private int reserva;
    public static UpdateBookingTask datos(int reserva) {
        return instrumented(UpdateBookingTask.class,reserva);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                UpdateBookingInteraction.datosReserva(reserva)
        );

    }
}
