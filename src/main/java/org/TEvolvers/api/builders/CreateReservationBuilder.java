package org.TEvolvers.api.builders;

import org.TEvolvers.api.model.CreateBookingBookingdatesModel;
import org.TEvolvers.api.model.CreateBookingModel;
import org.TEvolvers.api.utilities.DataCreateBooking;

public class CreateReservationBuilder {

    public static CreateBookingModel getRequest() {
        return CreateBookingModel.builder()
                .firstname(DataCreateBooking.getDataCreateBooking("createBooking.firstname"))
                .lastname(DataCreateBooking.getDataCreateBooking("createBooking.lastname"))
                .totalprice(DataCreateBooking.getDataCreateBooking("createBooking.totalprice"))
                .depositpaid(DataCreateBooking.getDataCreateBooking("createBooking.depositpaid"))
                .bookingdates(getBookingData())
                .additionalneeds(DataCreateBooking.getDataCreateBooking("createBooking.additionalneeds"))
                .build();
    }

    private static CreateBookingBookingdatesModel getBookingData() {
        return CreateBookingBookingdatesModel.builder()
                .checkin(DataCreateBooking.getDataCreateBooking("createBooking.checkin"))
                .checkout(DataCreateBooking.getDataCreateBooking("createBooking.checkout"))
                .build();
    }
}