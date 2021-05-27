package WebAPI.TaskList;


import WebAPI.Task.Task;
import WebAPI.Terrarium.Terrarium;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity (name =  "TaskList")
@Table(name = "taskList")
public class TaskList {

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> tasks = new HashSet<>();
    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Terrarium> terrariums = new HashSet<>();

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "taskList_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    @Column(name = "tasklistid", updatable = false)
    private Long taskListId;




    public TaskList(){

    }


    public void addTaskToTaskList(Task task)
    {
        this.tasks.add(task);
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Terrarium> getTerrariums() {
        return terrariums;
    }

    public void setTerrariums(Set<Terrarium> terrariums) {
        this.terrariums = terrariums;
    }



    public Long getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(Long taskListId) {
        this.taskListId = taskListId;
    }

}
