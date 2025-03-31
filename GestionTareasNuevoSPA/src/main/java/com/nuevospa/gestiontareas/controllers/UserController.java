package com.nuevospa.gestiontareas.controllers;

import com.nuevospa.gestiontareas.models.User;
import com.nuevospa.gestiontareas.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuarios", description = "Endpoints para gestionar los usuarios del sistema")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @Operation(
        summary = "Crear un nuevo usuario",
        description = "Permite crear un nuevo usuario en el sistema."
    )
    public ResponseEntity<User> createUser(@RequestBody User user, Authentication authentication) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdUser);
    }

    @GetMapping("/list-users")
    @Operation(
        summary = "Listar todos los usuarios",
        description = "Devuelve una lista de todos los usuarios registrados en el sistema."
    )
    public List<User> listUsers(Authentication authentication) {
        return userService.getAllUsers();
    }
}
