package org.TEvolvers.api.Task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.TEvolvers.api.Interaction.CreateBookingInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateBookingTask implements Task {
    public static CreateBookingTask datos() {
        return instrumented(CreateBookingTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CreateBookingInteraction.datosReserva()
        );

    }
}
