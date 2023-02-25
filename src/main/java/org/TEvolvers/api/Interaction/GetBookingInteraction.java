package org.TEvolvers.api.Interaction;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
@AllArgsConstructor
public class GetBookingInteraction implements Interaction {
    private int reserva;
    public static GenerarSesionInteraction dataInteraction(int reserva){
        return instrumented(GenerarSesionInteraction.class,reserva);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetInteraction.resource("/booking/"+reserva)
        );
    }
}
