package org.TEvolvers.api.task;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.TEvolvers.api.interaction.CreateInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class Login implements Task {
    public static Login userApplication() {
        return instrumented(Login.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(CreateInteraction.successfulSession());
    }
}