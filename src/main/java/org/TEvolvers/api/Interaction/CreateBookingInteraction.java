package org.TEvolvers.api.Interaction;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.TEvolvers.api.Model.AuthModel;
import org.TEvolvers.api.Model.CreateBookingBookingdatesModel;
import org.TEvolvers.api.Model.CreateBookingModel;
import org.TEvolvers.api.Utilities.DatosAuth;
import org.TEvolvers.api.Utilities.DatosCreateBooking;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateBookingInteraction implements Interaction {
    public static CreateBookingInteraction datosReserva() {
        return instrumented(CreateBookingInteraction.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(PostInteraction.to("/booking")
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(sendCreateBookingBuilder())

                ));
    }

    private CreateBookingModel sendCreateBookingBuilder() {
        return CreateBookingModel.builder()
                .firstname(DatosCreateBooking.getDatosCreateBooking("createBooking.firstname"))
                .lastname(DatosCreateBooking.getDatosCreateBooking("createBooking.lastname"))
                .totalprice(DatosCreateBooking.getDatosCreateBooking("createBooking.totalprice"))
                .depositpaid(DatosCreateBooking.getDatosCreateBooking("createBooking.depositpaid"))
                .bookingdates(getbookingdates())
                .additionalneeds(DatosCreateBooking.getDatosCreateBooking("createBooking.additionalneeds"))
                .build();
    }

    private CreateBookingBookingdatesModel getbookingdates() {
        return CreateBookingBookingdatesModel.builder()
                .checkin(DatosCreateBooking.getDatosCreateBooking("createBooking.checkin"))
                .checkout(DatosCreateBooking.getDatosCreateBooking("createBooking.checkout"))
                .build();

    }
}
