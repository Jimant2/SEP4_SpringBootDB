package WebAPI.Task;

import WebAPI.TaskList.TaskList;


import WebAPI.Terrarium.Terrarium;
import WebAPI.TerrariumProfile.TerrariumProfile;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity(name =  "Task")
@Table(name = "task")
public class Task {


    @OneToMany(mappedBy = "terrarium", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Terrarium> terrariums = new HashSet<>();


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

    @Column(name = "taskId", updatable = false)
    private Long taskId;
    @Column(name = "time", nullable = false)
    private LocalDateTime time;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "taskListId", referencedColumnName = "taskListId"),
                })
    private TaskList taskList;
    @ManyToOne
    @JoinColumn(name = "profileid", referencedColumnName = "profileid")
    private TerrariumProfile terrariumProfile;


    public Task()
    {

    }

    public Task(Long taskId, LocalDateTime time, String name, TaskList taskList, TerrariumProfile terrariumProfile) {
        this.taskId = taskId;
        this.time = time;
        this.name = name;
        this.taskList = taskList;
        this.terrariumProfile = terrariumProfile;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
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

    public TerrariumProfile getTerrariumProfile() {
        return terrariumProfile;
    }

    public void setTerrariumProfile(TerrariumProfile terrariumProfile) {
        this.terrariumProfile = terrariumProfile;
    }
}
