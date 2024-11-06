package org.wecancodeit.backend.Repositories;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for managing User entities
public interface UserRepository extends JpaRepository<User, Long> {

    // Method to find a user by their username
    User findByUsername(String username);

    // // Method to find a user by their ID
    // User findByID(Long id);
}

