package org.wecancodeit.backend.BOService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.backend.DataModels.UserModel;
import org.wecancodeit.backend.Repositories.UserRepository;

import jakarta.annotation.Resource;

@Component  // Marks this class as a Spring Component, making it a Spring-managed bean.
public class Populator implements CommandLineRunner {

    @Resource
    private final UserRepository users;  // Inject the UserRepository to interact with the database.

    // Constructor-based dependency injection for UserRepository
    public Populator(UserRepository users) {
        this.users = users;
    }

    // The run method will be called after the application context is initialized.
    @Override
    public void run(String... args) throws Exception {

        // Create a new UserModel object with sample data and save it to the database
        UserModel user = new UserModel(1L, "testUser1", "password123", 10);
        users.save(user);  // Persist the user to the repository (database)

        // Repeat for several other test users with different data
        user = new UserModel(2L, "testUser2", "securePass456", 12);
        users.save(user);

        user = new UserModel(3L, "testUser3", "mySecret789", 8);
        users.save(user);

        user = new UserModel(4L, "testUser4", "tootiFrooti123", 9);
        users.save(user);

        user = new UserModel(5L, "testUser5", "tedBundy124", 6);
        users.save(user);
    }
}
