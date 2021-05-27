package WebAPI.Task;



import WebAPI.Terrarium.Terrarium;
import WebAPI.TerrariumProfile.TerrariumProfile;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity(name =  "Task")
@Table(name = "tasks")
public class Task {


    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
    @Column(name = "tasktime", nullable = false)
    private Timestamp time;
    @Column(name = "name")
    private String taskname;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileid")
    private TerrariumProfile terrariumProfile;


    public Task()
    {

    }

    public Task(Timestamp time, String taskname) {
        this.time = time;
        this.taskname=taskname;
    }

    public TerrariumProfile getTerrariumProfile() {
        return terrariumProfile;
    }

    public void setTerrariumProfile(TerrariumProfile terrariumProfile) {
        this.terrariumProfile = terrariumProfile;
    }

    public Task(String name) {
        this.time = Timestamp.valueOf(LocalDateTime.now());

    }

    public Set<Terrarium> getTerrariums() {
        return terrariums;
    }

    public void setTerrariums(Set<Terrarium> terrariums) {
        this.terrariums = terrariums;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
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

}