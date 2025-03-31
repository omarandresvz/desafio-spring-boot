package com.nuevospa.gestiontareas.controllers;

import com.nuevospa.gestiontareas.models.TaskStatus;
import com.nuevospa.gestiontareas.services.TaskStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-statuses")
@Tag(name = "Estados de Tareas", description = "Endpoints para gestionar los estados de las tareas")
public class TaskStatusController {

    @Autowired
    private TaskStatusService taskStatusService;

    @GetMapping("/list-statuses")
    @Operation(
        summary = "Listar todos los estados de las tareas",
        description = "Devuelve una lista con todos los estados posibles de las tareas."
    )
    public List<TaskStatus> getAllTaskStatuses() {
        return taskStatusService.getAllTaskStatuses();
    }
}
