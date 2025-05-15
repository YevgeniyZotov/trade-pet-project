package kz.project1.trade.controller;

import kz.project1.trade.dto.RegisterRequest;
import kz.project1.trade.dto.UserDto;
import kz.project1.trade.service.AuthService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public UserDto register(RegisterRequest request) {
        return authService.register(request);
    }
}
