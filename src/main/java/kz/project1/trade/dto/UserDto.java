package kz.project1.trade.dto;

import kz.project1.trade.model.enums.UserStatus;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private UserStatus status;
}
