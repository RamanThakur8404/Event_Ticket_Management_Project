package com.Project.tickets.Controller;

import com.Project.tickets.domain.dtos.RegisterRequestDto;
import com.Project.tickets.domain.entities.User;
import com.Project.tickets.repositories.UserRepository;
import com.Project.tickets.services.UserService; // Import the UserService
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1.0")
@RequiredArgsConstructor
public class RegisterController {

    private final UserRepository userRepository;
    private final UserService userService; // Inject UserService

    @PostMapping("/register")
    public ResponseEntity<String> registerUser  (@RequestBody RegisterRequestDto dto) {
        if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required.");
        }

        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already registered.");
        }

        User user = new User();
        user.setId(UUID.randomUUID()); // Set a unique ID using UUID
        user.setName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user); // ID will be generated automatically
        return ResponseEntity.ok("User  registered successfully.");
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser  (@PathVariable UUID id, @RequestBody RegisterRequestDto dto) {
        // Fetch the existing user from the database
        User existingUser   = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User  not found"));

        // Update the fields
        existingUser .setName(dto.getFullName());
        existingUser .setEmail(dto.getEmail());
        existingUser .setUpdatedAt(LocalDateTime.now());

        try {
            userService.updateUser (existingUser ); // Call the updateUser  method
            return ResponseEntity.ok("User  updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating user: " + e.getMessage());
        }
    }
}
