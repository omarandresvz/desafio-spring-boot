package com.nuevospa.gestiontareas.services;

import com.nuevospa.gestiontareas.models.Task;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface TaskService {
	
	Task createTask(Task task);
	
	List<Task> getAllTask();
	
    List<Task> getTasksByUser(Long userId);
    
    Task getTaskById(Long id);
    
    Task updateTask(Long id, Task updatedTask);
    
    void deleteTask(Long id);
    
}