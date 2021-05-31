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
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "terrariumId", updatable = false, insertable = false),
    @JoinColumn(name = "motherboardId", updatable = false, insertable = false)})
    private Terrarium terrarium;
    @Column(name = "toggleVent")
    private boolean toggleVent;
    @Column(name = "toggleLight")
    private boolean toggleLight;


    public Task()
    {

    }

    public Task(Timestamp time, String taskname) {
        this.time = time;
        this.taskname=taskname;
    }


    public Task(String name, boolean toggleLight, boolean toggleVent) {
        this.time = Timestamp.valueOf(LocalDateTime.now());
        this.toggleLight = toggleLight;
        this.toggleVent = toggleVent;
    }


    public Terrarium getTerrarium() {
        return terrarium;
    }

    public void setTerrarium(Terrarium terrarium) {
        this.terrarium = terrarium;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getTaskname() {
        return taskname;
    }

    public boolean isToggleVent() {
        return toggleVent;
    }

    public void setToggleVent(boolean toggleVent) {
        this.toggleVent = toggleVent;
    }

    public boolean isToggleLight() {
        return toggleLight;
    }

    public void setToggleLight(boolean toggleLight) {
        this.toggleLight = toggleLight;
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