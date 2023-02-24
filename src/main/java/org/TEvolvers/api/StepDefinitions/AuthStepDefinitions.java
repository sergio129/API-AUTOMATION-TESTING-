package org.TEvolvers.api.StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.TEvolvers.api.Questions.ResponseCode;
import org.TEvolvers.api.Task.AuthTask;
import org.TEvolvers.api.Task.CreateBookingTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.TEvolvers.api.ConfiguracionGeneral.Configuracion.UrlBase;
import static org.hamcrest.core.IsEqual.equalTo;


public class AuthStepDefinitions {
    Actor actor = Actor.named("T-EVolvers");

    @Before
    public void setUp() {
        actor.whoCan(CallAnApi.at(UrlBase));
    }

    @Given("Me autentico en en la api Auth - CreateToken")
    public void me_autentico_en_en_la_api_auth_create_token() {
    }

    @When("Ingreso los datos de usuario y contraseña")
    public void ingreso_los_datos_de_usuario_y_contrasena() {
        // actor.attemptsTo(AuthTask.datosAuth());
        actor.attemptsTo(AuthTask.datosToken());
    }

    @Then("Se genera el token y el resultado del servicio debe ser estatus: {int}")
    public void se_genera_el_token_y_el_resultado_del_servicio_debe_ser_estatus(int arg0) {
        actor.should(seeThat(new ResponseCode(), equalTo(arg0)));

    }


    @Given("Escribo los datos para la creacion de la reserva")
    public void escriboLosDatosParaLaCreacionDeLaReserva() {
        actor.attemptsTo(CreateBookingTask.datos());
    }
}
