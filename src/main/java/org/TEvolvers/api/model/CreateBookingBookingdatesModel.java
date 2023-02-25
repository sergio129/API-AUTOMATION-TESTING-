package org.TEvolvers.api.model;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateBookingBookingdatesModel {
    private String checkin;
    private String checkout;
}
