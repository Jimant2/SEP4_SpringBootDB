package WebAPI.user;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(Long userid) {
        super("Could not find User with id " + userid);
    }

}
