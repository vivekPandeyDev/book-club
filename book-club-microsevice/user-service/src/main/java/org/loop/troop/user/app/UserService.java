package org.loop.troop.user.app;

import org.loop.troop.user.dto.RegisterDto;
import org.loop.troop.user.dto.UserDto;

import java.util.UUID;

public interface UserService {
    UserDto saveUser(RegisterDto registerDto);
    UserDto getUserByUsername(String username);
    void deleteUserById(String id);
    boolean isUserExist(String username);
}
