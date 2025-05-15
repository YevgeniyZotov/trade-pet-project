package kz.project1.trade.service;

import kz.project1.trade.dto.RegisterRequest;
import kz.project1.trade.dto.UserDto;
import kz.project1.trade.exception.RegisterEmailExistsException;
import kz.project1.trade.exception.RegisterPasswordMismatchException;
import kz.project1.trade.mapper.UserMapper;
import kz.project1.trade.model.User;
import kz.project1.trade.model.enums.UserStatus;
import kz.project1.trade.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new RegisterPasswordMismatchException("Пароли не совпадают");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RegisterEmailExistsException("Пользователь с таким email уже существует");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setStatus(UserStatus.ACTIVE);
        return userMapper.toDto(userRepository.save(user));
    }
}
