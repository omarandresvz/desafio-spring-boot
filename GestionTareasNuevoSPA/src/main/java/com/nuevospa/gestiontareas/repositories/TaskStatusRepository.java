package com.nuevospa.gestiontareas.repositories;

import com.nuevospa.gestiontareas.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
	
}