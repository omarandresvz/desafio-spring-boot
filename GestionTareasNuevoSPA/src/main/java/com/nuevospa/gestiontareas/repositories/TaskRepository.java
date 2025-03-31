package com.nuevospa.gestiontareas.repositories;

import com.nuevospa.gestiontareas.models.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	List<Task> findByUserId(Long userId); 
	
}