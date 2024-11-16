package org.wecancodeit.backend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecancodeit.backend.DataModels.UserModel;

// Repository interface for managing User entities
public interface UserRepository extends JpaRepository<UserModel, Long> {

    // Method to find a user by their username
    List<UserModel> findByUsernameIgnoreCase(String username);

    /**
 * Finds a user by their authentication token.
 * This method queries the database to locate a user based on the provided token.
 *
 * @param token The authentication token associated with the user.
 * @return A UserModel instance if a user with the given token is found;
 *         otherwise, returns null.
 */
    UserModel findByToken(String token);

}
