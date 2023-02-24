package org.TEvolvers.api.Utilities;

import java.util.ResourceBundle;

public class DatosCreateBooking {
    public static ResourceBundle resourceBundle() {
        if (System.getProperty("env") != null) {
            return ResourceBundle.getBundle(System.getProperty("env"));
        } else {
            return ResourceBundle.getBundle("CreateBooking");
        }
    }
    public static String getDatosCreateBooking(String keys) {
        return resourceBundle().getString(keys);
    }
}
