package WebAPI.Task;

public class TaskNotFoundException extends RuntimeException{
    TaskNotFoundException(Long taskId) {
        super("Could not find Task with id " + taskId);
    }

}
