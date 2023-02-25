package org.TEvolvers.api.Interaction;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.json.Json;

import static net.serenitybdd.screenplay.Tasks.instrumented;
@AllArgsConstructor
public class GetBookingInteraction implements Interaction {
    private int reserva;
    public static GetBookingInteraction dataInteraction(int reserva){
        return instrumented(GetBookingInteraction.class,reserva);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetInteraction.resource("/booking/"+reserva)


        );
    }
}
