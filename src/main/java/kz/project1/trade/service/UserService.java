package kz.project1.trade.service;

import kz.project1.trade.dto.CreateUserRequest;
import kz.project1.trade.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(CreateUserRequest request);
    List<UserDto> getAllUsers();
    UserDto deleteUser(Long id);
    UserDto banUser(Long id);
    UserDto unbanUser(Long id);
    UserDto restoreUser(Long id);
}
