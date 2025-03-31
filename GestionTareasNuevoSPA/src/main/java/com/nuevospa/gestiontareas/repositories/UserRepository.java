package com.nuevospa.gestiontareas.repositories;

import com.nuevospa.gestiontareas.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUsername(String username);
    
    User getUserByUsername(String username);
    
    boolean existsByUsername(String username);
    
}