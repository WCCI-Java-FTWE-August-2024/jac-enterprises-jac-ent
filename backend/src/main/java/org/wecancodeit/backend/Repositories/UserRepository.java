package org.wecancodeit.backend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecancodeit.backend.DataModels.UserModel;

// Repository interface for managing User entities
public interface UserRepository extends JpaRepository<UserModel, Long> {

    // Method to find a user by their username
    List<UserModel> findByUsernameIgnoreCase(String username);

}
