package ch.zli.m223.ksh19a.mj.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import ch.zli.m223.ksh19a.mj.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    UserDTO getUser(@PathVariable("id") Long id) {
        return new UserDTO(userService.getUser(id));
    }

    @PostMapping("/users")
    UserDTO insertUser(@RequestBody UserInputDTO userData) {
        return new UserDTO(userService.insertUser(userData.name));
    }

    @DeleteMapping("/users/{name}")
    Long deleteUser(@PathVariable("name") String name) {
        return userService.deleteUser(name);
    }


}