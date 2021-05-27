package WebAPI.TaskList;



import WebAPI.Task.Task;
import WebAPI.Task.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaskListController {
    private final TaskListRepository taskListRepository;
    private final TaskRepository taskRepository;

    TaskListController(TaskListRepository taskListRepository, TaskRepository taskRepository)
    {
        this.taskListRepository = taskListRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/TaskList")
    List<TaskList> all(){return taskListRepository.findAll();}

    @PostMapping("/TaskList")
    TaskList newTaskList(@RequestBody TaskList taskList)
    {
        return taskListRepository.save(taskList);
    }
    @GetMapping("/TaskList/{taskListId}")
    TaskList one(@PathVariable Long taskListId){
        return taskListRepository.findById(taskListId).orElseThrow(
                () -> new TaskListNotFoundException(taskListId)
        );
    }

    @PutMapping("/TaskList/{taskListid}/Task/{taskid}")
    TaskList addTaskToTaskList(@PathVariable Long taskListid, @PathVariable Long taskid) {
        TaskList taskList = taskListRepository.findById(taskListid).get();
        Task task = taskRepository.findById(taskid).get();
        taskList.addTaskToTaskList(task);
        return taskListRepository.save(taskList);
    }




    @PutMapping("/TaskList/{taskListId}")
    TaskList updateTaskList(@RequestBody TaskList newTaskList, @PathVariable Long taskListId)
    {
        return taskListRepository.findById(taskListId)
                .map(taskList -> {
                    taskList.setTaskListId(newTaskList.getTaskListId());
                    taskList.setTerrariums(newTaskList.getTerrariums());
                    taskList.setTasks(newTaskList.getTasks());
                    return taskListRepository.save(newTaskList);
                })
                .orElseGet(() -> {
                    newTaskList.setTaskListId(taskListId);
                    return taskListRepository.save(newTaskList);
                });
    }
    @DeleteMapping("TaskList/{taskListId}")
    void deleteTerrariumProfile(@PathVariable Long taskListId)
    {
        taskListRepository.deleteById(taskListId);
    }
}
