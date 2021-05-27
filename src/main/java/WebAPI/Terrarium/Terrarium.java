package WebAPI.Terrarium;

import WebAPI.Sensor.Sensor;
import WebAPI.Task.Task;
import WebAPI.TaskList.TaskList;
import WebAPI.TerrariumProfile.TerrariumProfile;
import WebAPI.user.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "Terrarium")
@Table(name = "terrarium")
public class Terrarium {


    @OneToMany(mappedBy = "terrariumId",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TerrariumProfile> terrariumProfiles = new HashSet<>();


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
    @Column(name = "terrarium_Id", updatable = false)
    private Long TerrariumId;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "sensor_Id", referencedColumnName = "sensor_id"),
            @JoinColumn(name = "typeId", referencedColumnName = "typeId")})
    private Sensor sensor;
    @Column(nullable = false)
    private String TerrariumName;
    @ManyToOne
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id")
    private User user;



    public Terrarium(){}


    public Terrarium(String terrariumName) {
        this.TerrariumName = terrariumName;
        this.sensor = getSensor();
        this.user= getUser();
        this.terrariumProfiles = new HashSet<>();
    }

    public void addTerrariumProfileToTerrarium(TerrariumProfile terrariumProfile)
    {
        this.terrariumProfiles.add(terrariumProfile);
    }


    public Set<TerrariumProfile> getTerrariumProfiles() {
        return terrariumProfiles;
    }

    public void setTerrariumProfiles(Set<TerrariumProfile> terrariumProfiles) {
        this.terrariumProfiles = terrariumProfiles;
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
}
