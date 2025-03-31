package com.nuevospa.gestiontareas.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.nuevospa.gestiontareas.exceptions.CustomException;
import com.nuevospa.gestiontareas.models.User;
import com.nuevospa.gestiontareas.repositories.UserRepository;
import com.nuevospa.gestiontareas.services.UserService;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder,UserRepository userRepository) {
        this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
        
    }

    @Override
    public User createUser(User user) {
    	if (userRepository.existsByUsername(user.getUsername())) {
            throw new CustomException("El nombre de usuario ya existe");
        }
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException("Usuario no existe"));
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setRole(updatedUser.getRole());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
    
}
