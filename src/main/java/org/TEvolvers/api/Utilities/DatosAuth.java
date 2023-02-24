package org.TEvolvers.api.Utilities;

import java.util.ResourceBundle;

public class DatosAuth {
    public static ResourceBundle resourceBundle() {
        if (System.getProperty("env") != null) {
            return ResourceBundle.getBundle(System.getProperty("env"));
        } else {
            return ResourceBundle.getBundle("Auth");
        }
    }

    public static String getDatosAuth(String keys) {
        return resourceBundle().getString(keys);
    }

}
