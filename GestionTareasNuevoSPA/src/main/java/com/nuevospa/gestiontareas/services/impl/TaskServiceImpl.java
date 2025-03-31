package com.nuevospa.gestiontareas.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuevospa.gestiontareas.exceptions.CustomException;
import com.nuevospa.gestiontareas.models.Task;
import com.nuevospa.gestiontareas.models.TaskStatus;
import com.nuevospa.gestiontareas.models.User;
import com.nuevospa.gestiontareas.repositories.TaskRepository;
import com.nuevospa.gestiontareas.repositories.TaskStatusRepository;
import com.nuevospa.gestiontareas.repositories.UserRepository;
import com.nuevospa.gestiontareas.services.TaskService;

@Service
public class TaskServiceImpl implements  TaskService {

	private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskStatusRepository taskStatusRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository, TaskStatusRepository taskStatusRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskStatusRepository = taskStatusRepository;
    }

    @Override
    public Task createTask(Task task) {
    	
        User user = userRepository.findById(task.getUser().getId())
        	.orElseThrow(() ->  new CustomException("El Usuario no existe en la base de datos"));

        TaskStatus taskStatus = taskStatusRepository.findById(task.getTaskStatus().getId())
        	.orElseThrow(() -> new CustomException("El estado de tarea no existe en la base de datos"));

        task.setUser(user);
        task.setTaskStatus(taskStatus);

        return taskRepository.save(task);
    }
    
    @Override
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}

    @Override
    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new CustomException("La tarea no existe"));
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {

    	// Buscar la tarea por ID
        Optional<Task> taskOptional = taskRepository.findById(id);
        
        if (!taskOptional.isPresent()) {
        	new CustomException("La tarea no existe");
        }
        
        User user = userRepository.findById(updatedTask.getUser().getId())
            .orElseThrow(() ->  new CustomException("El Usuario no existe en la base de datos"));

        TaskStatus taskStatus = taskStatusRepository.findById(updatedTask.getTaskStatus().getId())
            .orElseThrow(() -> new CustomException("El estado de tarea no existe en la base de datos"));
            
        Task existingTask = taskOptional.get();
        
        existingTask.setName(updatedTask.getName());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setExpirationDate(updatedTask.getExpirationDate());
        existingTask.setTaskStatus(taskStatus);
        existingTask.setUser(user);
        
        
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    
}
