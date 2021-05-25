package WebAPI.TaskList;

public class TaskListNotFoundException extends RuntimeException{
    TaskListNotFoundException(Long taskListId) {
        super("Could not find Task List with id " + taskListId);
    }
}
