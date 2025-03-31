package com.nuevospa.gestiontareas.config;

import com.nuevospa.gestiontareas.models.TaskStatus;
import com.nuevospa.gestiontareas.models.User;
import com.nuevospa.gestiontareas.repositories.TaskStatusRepository;
import com.nuevospa.gestiontareas.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    private final UserRepository userRepository;
    private final TaskStatusRepository taskStatusRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, TaskStatusRepository taskStatusRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.taskStatusRepository = taskStatusRepository;
		this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
    	if (taskStatusRepository.count() == 0) {
            TaskStatus pending = new TaskStatus();
            pending.setName("Pending");
            taskStatusRepository.save(pending);
            
            TaskStatus in_Progress = new TaskStatus();
            in_Progress.setName("in Progress");
            taskStatusRepository.save(in_Progress);

            TaskStatus completed = new TaskStatus();
            completed.setName("Completed");
            taskStatusRepository.save(completed);
        }

        if (userRepository.count() == 0) {
            User user1 = new User();
            user1.setUsername("user1");
            user1.setPassword(passwordEncoder.encode("password1"));
            user1.setRole("USER");
            user1.setEmail("user1@test.com");
            user1.setName("juan");
            user1.setLastName("Pérez");
            userRepository.save(user1);
            
            User user2 = new User();
            user2.setUsername("user2");
            user2.setPassword(passwordEncoder.encode("password2"));
            user2.setRole("USER");
            user2.setEmail("user2@test.com");
            user2.setName("Pedro");
            user2.setLastName("Rodríguez");
            userRepository.save(user2);
            
            User user3 = new User();
            user3.setUsername("user3");
            user3.setPassword(passwordEncoder.encode("password3"));
            user3.setRole("USER");
            user3.setEmail("user3@test.com");
            user3.setName("Luisa");
            user3.setLastName("Pérez");
            userRepository.save(user3);
        }
    }
}