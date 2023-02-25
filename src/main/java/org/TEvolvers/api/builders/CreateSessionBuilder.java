package org.TEvolvers.api.builders;

import org.TEvolvers.api.model.AuthModel;
import org.TEvolvers.api.utilities.DatosAuth;

public class CreateSessionBuilder {
    private CreateSessionBuilder() {
    }

    public static AuthModel getToken() {
        return AuthModel.builder()
                .password(DatosAuth.getDatosAuth("auth.password"))
                .username(DatosAuth.getDatosAuth("auth.username"))
                .build();
    }
}