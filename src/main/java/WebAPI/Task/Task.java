package WebAPI.Task;

import WebAPI.TaskList.TaskList;


import WebAPI.Terrarium.Terrarium;
import WebAPI.TerrariumProfile.TerrariumProfile;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity(name =  "Task")
@Table(name = "task")
public class Task {




    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "task_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )


    @Column(name = "task_Id", updatable = false)
    private Long taskId;
    @Column(name = "time", nullable = false)
    private Timestamp time;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "task_List_Id", referencedColumnName = "taskListId"),
                })
    private TaskList taskList;


    public Task()
    {

    }

    public Task(String name) {
        this.time = Timestamp.valueOf(LocalDateTime.now());
        this.name = name;
        this.taskList = getTaskList();

    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}