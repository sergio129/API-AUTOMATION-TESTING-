package org.TEvolvers.api.Model;

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
