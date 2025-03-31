package com.nuevospa.gestiontareas.services;

import com.nuevospa.gestiontareas.models.TaskStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface TaskStatusService {

	TaskStatus createTaskStatus(TaskStatus taskStatus);

    List<TaskStatus> getAllTaskStatuses();
    
}
