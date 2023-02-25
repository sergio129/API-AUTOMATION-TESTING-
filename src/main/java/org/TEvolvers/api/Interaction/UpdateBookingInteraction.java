package org.TEvolvers.api.Interaction;

import io.restassured.http.ContentType;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.TEvolvers.api.Model.CreateBookingBookingdatesModel;
import org.TEvolvers.api.Model.CreateBookingModel;
import org.TEvolvers.api.Utilities.DatosCreateBooking;

import static net.serenitybdd.screenplay.Tasks.instrumented;
@AllArgsConstructor
public class UpdateBookingInteraction implements Interaction {
    private int reserva;
    public static UpdateBookingInteraction datosReserva(int reserva) {
        return instrumented(UpdateBookingInteraction.class,reserva);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(PutInteraction.to("/booking/"+reserva)
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .cookie("token=" + GenerarSesionInteraction.generatoken())
                        .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                        .body(sendUpdateBookingBuilder()

                        )

                ));
    }

    private CreateBookingModel sendUpdateBookingBuilder() {
        return CreateBookingModel.builder()
                .firstname(DatosCreateBooking.getDatosCreateBooking("createBooking.firstname"))
                .lastname(DatosCreateBooking.getDatosCreateBooking("createBooking.lastname"))
                .totalprice(DatosCreateBooking.getDatosCreateBooking("createBooking.totalprice"))
                .depositpaid(DatosCreateBooking.getDatosCreateBooking("createBooking.depositpaid"))
                .bookingdates(getUpdatebookingdates())
                .additionalneeds(DatosCreateBooking.getDatosCreateBooking("createBooking.additionalneeds"))
                .build();
    }

    private CreateBookingBookingdatesModel getUpdatebookingdates() {
        return CreateBookingBookingdatesModel.builder()
                .checkin(DatosCreateBooking.getDatosCreateBooking("createBooking.checkin"))
                .checkout(DatosCreateBooking.getDatosCreateBooking("createBooking.checkout"))
                .build();

    }


}
