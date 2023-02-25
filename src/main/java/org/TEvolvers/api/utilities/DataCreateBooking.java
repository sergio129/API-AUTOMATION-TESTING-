package org.TEvolvers.api.utilities;

import java.util.ResourceBundle;

public class DataCreateBooking {
    public static ResourceBundle resourceBundle() {
        if (System.getProperty("env") != null) {
            return ResourceBundle.getBundle(System.getProperty("env"));
        } else {
            return ResourceBundle.getBundle("CreateBooking");
        }
    }
    public static String getDataCreateBooking(String keys) {
        return resourceBundle().getString(keys);
    }
}
