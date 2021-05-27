package WebAPI.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/user")
    List<User> all() { return repository.findAll(); }

    @PostMapping("/user")
    User newUser(@RequestBody User user) {
        return repository.save(user);
    }
    @GetMapping("/user/{userId}")
            User one(@PathVariable Long userId)
    {
        return repository.findById(userId).orElseThrow(() ->
                new UserNotFoundException(userId)
                );
    }
        @PutMapping("user/{userId}")
        User updateUser(@RequestBody User newUser, @PathVariable Long userId)
        {
            return repository.findById(userId)
                    .map(user -> {
                        user.setUserId(newUser.getUserId());
                        user.setUsername(newUser.getUsername());
                        user.setTerrarium(newUser.getTerrarium());
                        return repository.save(newUser);
                    })
                    .orElseGet(() -> {
                        newUser.setUserId(userId);
                        return repository.save(newUser);
                    });
        }
        @DeleteMapping("user/{userId}")
            void deleteUser(@PathVariable Long userId)
            {
                repository.deleteById(userId);
            }
 }
