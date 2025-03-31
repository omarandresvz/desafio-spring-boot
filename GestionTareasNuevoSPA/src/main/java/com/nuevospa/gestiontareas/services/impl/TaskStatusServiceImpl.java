package com.nuevospa.gestiontareas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuevospa.gestiontareas.models.TaskStatus;
import com.nuevospa.gestiontareas.services.TaskStatusService;
import com.nuevospa.gestiontareas.repositories.TaskStatusRepository;

@Service
public class TaskStatusServiceImpl implements TaskStatusService{
    
	@Autowired
    TaskStatusRepository taskStatusRepository;

    @Override
    public TaskStatus createTaskStatus(TaskStatus taskStatus) {
        return taskStatusRepository.save(taskStatus);
    }

    @Override
    public List<TaskStatus> getAllTaskStatuses() {
        return taskStatusRepository.findAll();
    }

}
