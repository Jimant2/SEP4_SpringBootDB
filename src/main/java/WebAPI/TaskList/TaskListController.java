package WebAPI.TaskList;



import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaskListController {
    private final TaskListRepository taskListRepository;

    TaskListController(TaskListRepository taskListRepository)
    {
        this.taskListRepository = taskListRepository;
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
    TaskList updateTaskList(@RequestBody TaskList newTaskList, @PathVariable Long taskListId)
    {
        return taskListRepository.findById(taskListId)
                .map(taskList -> {
                    taskList.setTaskListId(newTaskList.getTaskListId());
                   taskList.setTerrariumProfile(newTaskList.getTerrariumProfile());
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
