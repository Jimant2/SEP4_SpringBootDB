package WebAPI.Task;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaskController {
    private final TaskRepository taskRepository;

    TaskController(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/SensorType")
    List<Task> all(){return taskRepository.findAll();}

    @PostMapping("/SensorType")
    Task newTask(@RequestBody Task task)
    {
        return taskRepository.save(task);
    }
    @GetMapping("/SensorType/{taskId}")
    Task one(@PathVariable Long taskId){
        return taskRepository.findById(taskId).orElseThrow(
                () -> new TaskNotFoundException(taskId)
        );
    }
    Task updateTask(@RequestBody Task newTask, @PathVariable Long taskId)
    {
        return taskRepository.findById(taskId)
                .map(task -> {
                    task.setTaskId(newTask.getTaskId());
                    task.setTime(newTask.getTime());
                    task.setName(newTask.getName());
                    task.setTaskList(newTask.getTaskList());
                    task.setTerrariumProfile(newTask.getTerrariumProfile());
                    return taskRepository.save(newTask);
                })
                .orElseGet(() -> {
                    newTask.setTaskId(taskId);
                    return taskRepository.save(newTask);
                });
    }
    @DeleteMapping("SensorType/{taskId}")
    void deleteTerrariumProfile(@PathVariable Long taskId)
    {
        taskRepository.deleteById(taskId);
    }
}
