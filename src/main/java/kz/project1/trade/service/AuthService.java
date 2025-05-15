package kz.project1.trade.service;

import kz.project1.trade.dto.RegisterRequest;
import kz.project1.trade.dto.UserDto;

public interface AuthService {
    UserDto register(RegisterRequest request);
}
