package com.nuevospa.gestiontareas.services;

import com.nuevospa.gestiontareas.models.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	User createUser(User user) throws IllegalArgumentException;;

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, User updatedUser);
    
    User getUserByUsername(String username);
}
