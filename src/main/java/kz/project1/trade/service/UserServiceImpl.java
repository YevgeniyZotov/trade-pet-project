package kz.project1.trade.service;

import kz.project1.trade.dto.RegisterRequest;
import kz.project1.trade.dto.UserDto;
import kz.project1.trade.exception.UserIdNotFoundException;
import kz.project1.trade.exception.UserStatusException;
import kz.project1.trade.mapper.UserMapper;
import kz.project1.trade.model.User;
import kz.project1.trade.model.enums.UserStatus;
import kz.project1.trade.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAllByStatus(UserStatus.ACTIVE).stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserIdNotFoundException("Пользователь с таким " + id + " не найден"));
        user.setStatus(UserStatus.DELETED);
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto banUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserIdNotFoundException("Пользователь с таким " + id + " не найден"));
        user.setStatus(UserStatus.BANNED);
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto unbanUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserIdNotFoundException("Пользователь с таким " + id + " не найден"));

        if (user.getStatus() == UserStatus.DELETED) {
            throw new UserStatusException("Пользователя с ID " + id + " нельзя разбанить, так как он удалён. Требуется восстановление.");
        }

        user.setStatus(UserStatus.ACTIVE);
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto restoreUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserIdNotFoundException("Пользователь с таким " + id + " не найден"));

        if (user.getStatus() != UserStatus.DELETED) {
            throw new UserStatusException("Пользователя с ID " + id + " не удалён - восстановаление невозможно.");
        }

        user.setStatus(UserStatus.ACTIVE);
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserIdNotFoundException("Пользователь с таким " + id + " не найден"));
        return UserMapper.toDto(user);
    }
}
