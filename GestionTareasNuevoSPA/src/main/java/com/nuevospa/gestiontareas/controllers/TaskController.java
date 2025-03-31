package com.nuevospa.gestiontareas.controllers;

import com.nuevospa.gestiontareas.models.Task;
import com.nuevospa.gestiontareas.models.User;
import com.nuevospa.gestiontareas.services.TaskService;
import com.nuevospa.gestiontareas.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Tareas", description = "Endpoints para la gestión de tareas")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @Operation(summary = "Crear una nueva tarea", description = "Permite a un usuario autenticado crear una nueva tarea y asignarla a su usuario.")
    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task, Authentication authentication) {
        User user = userService.getUserByUsername(authentication.getName());
        task.setUser(user);
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @Operation(summary = "Listar todas las tareas", description = "Obtiene una lista de todas las tareas registradas en la base de datos.")
    @GetMapping("/list-tasks")
    public List<Task> listTask(Authentication authentication) {
        return taskService.getAllTask();
    }

    @Operation(summary = "Actualizar una tarea", description = "Permite actualizar una tarea específica por su ID.")
    @PutMapping("/update-task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task task = taskService.updateTask(id, updatedTask);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(task);
    }

    @Operation(summary = "Eliminar una tarea", description = "Elimina una tarea específica por su ID si existe.")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<String> deleteTask1(@PathVariable Long id) {
    	try {
            taskService.deleteTask(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Tarea eliminada exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se ha podido eliminar la tarea: " + e.getMessage());
        }
    }

    @Operation(summary = "Buscar una tarea por ID", description = "Obtiene los detalles de una tarea específica por su ID.")
    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id, Authentication authentication) {
        return taskService.getTaskById(id);
    }
}
