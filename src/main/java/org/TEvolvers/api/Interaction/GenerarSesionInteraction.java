package org.TEvolvers.api.Interaction;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.TEvolvers.api.Model.AuthModel;
import org.TEvolvers.api.Utilities.DatosAuth;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GenerarSesionInteraction implements Interaction {


    public static GenerarSesionInteraction usuario() {
        return instrumented((GenerarSesionInteraction.class));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(PostInteraction.to("/auth")
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(sendCreateTokenBuilder())

                ));
        Serenity.setSessionVariable("token").to(Capturartoken());
    }

    private AuthModel sendCreateTokenBuilder() {
        return AuthModel.builder()
                .password(DatosAuth.getDatosAuth("auth.password"))
                .username(DatosAuth.getDatosAuth("auth.username"))
                .build();
    }

    public static String Capturartoken() {
        String cadena = (SerenityRest.lastResponse().body().jsonPath().getString("token"));
        return cadena;
    }

    public static String generatoken() {
        return Serenity.sessionVariableCalled("token");
    }
}
