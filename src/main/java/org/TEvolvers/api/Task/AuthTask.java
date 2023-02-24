package org.TEvolvers.api.Task;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.TEvolvers.api.Interaction.GenerarSesionInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class AuthTask implements Task {
    public static AuthTask datosToken() {
        return instrumented(AuthTask.class);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
        GenerarSesionInteraction.usuario());

    }

}
