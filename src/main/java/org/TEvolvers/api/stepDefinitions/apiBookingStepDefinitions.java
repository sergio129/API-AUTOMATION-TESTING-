package org.TEvolvers.api.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.TEvolvers.api.model.ReservaModel;
import org.TEvolvers.api.questions.ResponseCode;
import org.TEvolvers.api.task.CreateReservationTask;
import org.TEvolvers.api.task.GetBookingTask;
import org.TEvolvers.api.task.Login;
import org.TEvolvers.api.task.UpdateBookingTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.TEvolvers.api.ConfiguracionGeneral.Configuration.UrlBase;
import static org.hamcrest.core.IsEqual.equalTo;


public class apiBookingStepDefinitions {
    Actor actor = Actor.named("T-EVolvers");
    ReservaModel model = new ReservaModel();

    @Before
    public void setUp() {
        actor.whoCan(CallAnApi.at(UrlBase));
    }

    @Given("Sergio se loguea en el aplicativo booking")
    public void loginUser() {
        actor.attemptsTo(Login.userApplication());
    }

    @Then("el valida que la respuesta del servicio sea: {int}")
    public void validateStatusCode(int statusCode) {
        actor.should(seeThat(new ResponseCode(), equalTo(statusCode)));
    }

    @When("Ingreso los datos de usuario y contraseña")
    public void ingreso_los_datos_de_usuario_y_contrasena() {
        actor.attemptsTo(Login.userApplication());
    }

    @Given("Sergio ingresa los datos para la creacion de una reserva")
    public void createReservation() {
        actor.attemptsTo(CreateReservationTask.inBooking());
    }

    @Then("Resultado del servicio debe ser estatus: {int}")
    public void se_genera_el_token_y_el_resultado_del_servicio_debe_ser_estatus(int arg0) {
        actor.should(seeThat(new ResponseCode(), equalTo(arg0)));

    }

    @Given("Numero de Reserva que desea actualizar {int}")
    public void numeroDeReservaQueDeseaActualizar(int arg0) {
        this.model.setNumeroReserva(arg0);
    }

    @Given("Dato que tengo la reserva: {int} y escribo los datos para la Actualizacion de la reserva")
    public void datoQueTengoLaReservaYEscriboLosDatosParaLaActualizacionDeLaReserva(int arg0) {
        actor.attemptsTo(Login.userApplication(), UpdateBookingTask.reservation(arg0));
    }

    @When("el ingresa los datos para actualizar la reserva : {int}")
    public void updateReservation(int numReservation) {
        actor.attemptsTo(UpdateBookingTask.reservation(numReservation));
    }

    @Given("Sergio quiere consultar la reserva: {int}")
    public void listReservation(int numReservation) {
        actor.attemptsTo(GetBookingTask.infoReservation(numReservation));
    }
}
