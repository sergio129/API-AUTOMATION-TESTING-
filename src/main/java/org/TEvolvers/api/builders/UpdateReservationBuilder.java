package org.TEvolvers.api.builders;

import org.TEvolvers.api.model.CreateBookingBookingdatesModel;
import org.TEvolvers.api.model.CreateBookingModel;
import org.TEvolvers.api.utilities.DataCreateBooking;

public class UpdateReservationBuilder {
    private UpdateReservationBuilder() {

    }

    public static CreateBookingModel sendUpdateBookingBuilder() {
        return CreateBookingModel.builder()
                .firstname(DataCreateBooking.getDataCreateBooking("createBooking.firstname"))
                .lastname(DataCreateBooking.getDataCreateBooking("createBooking.lastname"))
                .totalprice(DataCreateBooking.getDataCreateBooking("createBooking.totalprice"))
                .depositpaid(DataCreateBooking.getDataCreateBooking("createBooking.depositpaid"))
                .bookingdates(getUpdatebookingdates())
                .additionalneeds(DataCreateBooking.getDataCreateBooking("createBooking.additionalneeds"))
                .build();
    }

    private static CreateBookingBookingdatesModel getUpdatebookingdates() {
        return CreateBookingBookingdatesModel.builder()
                .checkin(DataCreateBooking.getDataCreateBooking("createBooking.checkin"))
                .checkout(DataCreateBooking.getDataCreateBooking("createBooking.checkout"))
                .build();

    }

}