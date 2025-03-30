package org.loop.troop.user.keycloak;

import org.loop.troop.user.dto.RegisterDto;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.loop.troop.user.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface KeyCloakService {
    UserDto createUser(RegisterDto registerDto);
    void deleteUser(String id);
    UserRepresentation getKeycloakUser(String username);
    RoleRepresentation getKeycloakDefaultRoles();
    boolean isUserExist(String username);
}
