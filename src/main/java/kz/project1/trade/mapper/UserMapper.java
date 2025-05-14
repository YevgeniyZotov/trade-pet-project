package kz.project1.trade.mapper;

import kz.project1.trade.dto.CreateUserRequest;
import kz.project1.trade.dto.UserDto;
import kz.project1.trade.model.User;
import kz.project1.trade.model.enums.UserStatus;

public class UserMapper {
    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setStatus(user.getStatus());
        return dto;
    }

    public static User fromCreateRequest (CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setStatus(UserStatus.ACTIVE);
        return user;
    }
}
