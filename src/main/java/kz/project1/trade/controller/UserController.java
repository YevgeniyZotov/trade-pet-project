package kz.project1.trade.controller;

import kz.project1.trade.dto.CreateUserRequest;
import kz.project1.trade.dto.UserDto;
import kz.project1.trade.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public UserDto deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/{id}/ban")
    public UserDto banUser(@PathVariable Long id) {
        return userService.banUser(id);
    }

    @PostMapping("/{id}/unban")
    public UserDto unbanUser(@PathVariable Long id) {
        return userService.unbanUser(id);
    }

    @PostMapping("/{id}/restore")
    public UserDto restoreUser(@PathVariable Long id) {
        return userService.restoreUser(id);
    }
}
