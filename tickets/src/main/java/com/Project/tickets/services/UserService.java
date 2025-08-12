package com.Project.tickets.services;

import com.Project.tickets.domain.entities.User;
import com.Project.tickets.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void updateUser (User user) {
        try {
            // Fetch the existing user from the database
            User existingUser  = userRepository.findById(user.getId())
                    .orElseThrow(() -> new RuntimeException("User  not found"));

            // Update the fields you want to change
            existingUser .setName(user.getName());
            existingUser .setEmail(user.getEmail());
            // Update other fields as necessary

            // Save the updated user
            userRepository.save(existingUser );
        } catch (OptimisticLockingFailureException e) {
            // Handle the exception, e.g., log it and retry
            System.out.println("Optimistic locking failure: " + e.getMessage());
        }
    }
}
