package WebAPI.Terrarium;


import WebAPI.MotherboardData.MotherboardData;
import WebAPI.Task.Task;
import WebAPI.TerrariumProfile.TerrariumProfile;
import WebAPI.user.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Terrarium")
@Table(name = "terrarium")
@IdClass(TerrariumRelationshipClass.class)

public class Terrarium {


    @OneToMany(mappedBy = "terrarium", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MotherboardData> motherboardDataSet = new HashSet<>();





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

    @Id
    @Column(name = "terrariumId", updatable = false)
    private Long terrariumId;
    @Id
    @Column(name = "motherboardId",updatable = false)
    private Long motherboardId;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "taskid")
    private Task task;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileid")
    private TerrariumProfile terrariumProfile1;
    @ManyToOne
    @JoinColumn(name = "recordId")
    private MotherboardData motherboardData;



    public Terrarium( String  name) {
        this.name=name;
        this.motherboardDataSet = new HashSet<>();
        this.terrariumProfile1 = getTerrariumProfile1();
        this.task = getTask();
        this.motherboardId=getMotherboardId();
    }

    public Terrarium() {

    }


    public void addMotherboardDataToTerrarium(MotherboardData motherboardData)
    {
        this.motherboardDataSet.add(motherboardData);
    }


    public MotherboardData getMotherboardData() {
        return motherboardData;
    }

    public void setMotherboardData(MotherboardData motherboardData) {
        this.motherboardData = motherboardData;
    }

    public TerrariumProfile getTerrariumProfile1() {
        return terrariumProfile1;
    }

    public void setTerrariumProfile1(TerrariumProfile terrariumProfile1) {
        this.terrariumProfile1 = terrariumProfile1;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Set<MotherboardData> getMotherboardDataSet() {
        return motherboardDataSet;
    }

    public void setMotherboardDataSet(Set<MotherboardData> motherboardDataSet) {
        this.motherboardDataSet = motherboardDataSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getTerrariumId() {
        return terrariumId;
    }

    public void setTerrariumId(Long terrariumId) {
        this.terrariumId = terrariumId;
    }

    public Long getMotherboardId() {
        return motherboardId;
    }

    public void setMotherboardId(Long motherboardId) {
        this.motherboardId = motherboardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
