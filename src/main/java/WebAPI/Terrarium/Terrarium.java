package WebAPI.Terrarium;

import WebAPI.Sensor.Sensor;
import WebAPI.Task.Task;
import WebAPI.user.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity(name = "Terrarium")
@Table(name = "terrarium")
public class Terrarium {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "terrarium_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(updatable = false)
    private Long TerrariumId;
    @ManyToOne
    @JoinColumn(name = "valueid")
    private Sensor sensor;
    @Column(nullable = false)
    private String TerrariumName;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumns({@JoinColumn (name = "taskid", referencedColumnName = "taskid"), @JoinColumn (name = "profileid",
    referencedColumnName = "profileid"), @JoinColumn(name = "taskListId", referencedColumnName = "taskListId")})
    private Task task;


    public Terrarium(){}


    public Terrarium(Long terrariumId, Sensor sensor, String terrariumName, User user, Task task) {
        TerrariumId = terrariumId;
        this.sensor = sensor;
        TerrariumName = terrariumName;
        this.user = user;
        this.task = task;
    }

    public Long getTerrariumId() {
        return TerrariumId;
    }

    public void setTerrariumId(Long terrariumId) {
        TerrariumId = terrariumId;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getTerrariumName() {
        return TerrariumName;
    }

    public void setTerrariumName(String terrariumName) {
        TerrariumName = terrariumName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
