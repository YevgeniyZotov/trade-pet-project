package kz.project1.trade.mapper;

import kz.project1.trade.dto.RegisterRequest;
import kz.project1.trade.dto.UserDto;
import kz.project1.trade.model.User;
import kz.project1.trade.model.enums.UserStatus;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    }

    public static User fromCreateRequest(RegisterRequest request) {
        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .status(UserStatus.ACTIVE)
                .build();
    }
}
