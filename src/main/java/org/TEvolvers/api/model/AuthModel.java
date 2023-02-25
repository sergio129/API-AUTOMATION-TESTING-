package org.TEvolvers.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class AuthModel {
    private String username;
    private String password;
}
