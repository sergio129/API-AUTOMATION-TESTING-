package org.TEvolvers.api.Model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateBookingModel {

    private String firstname;

    private String lastname;

    private String totalprice;

    private String depositpaid;
    private CreateBookingBookingdatesModel bookingdates;

    private String additionalneeds;
}
