package WebAPI.Sensor;

import WebAPI.SensorData.SensorData;
import WebAPI.Terrarium.Terrarium;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



import java.util.HashSet;
import java.util.Set;


@Entity(name = "Sensor")
@Table(name = "sensor")

@IdClass(SensorRelationship.class)
public class Sensor {

    @OneToMany(mappedBy = "sensor",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Terrarium> terrariums = new HashSet<>();
    @OneToMany(mappedBy = "sensorId",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SensorData> sensorsData = new HashSet<>();


    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sensor_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )


    @Column(name = "sensor_id", updatable = false)
    private Long sensorID;
    @Enumerated(EnumType.STRING)
    @Id
    @Column (name = "typeid")
    private DataType typeId;
    @Column(name = "EUI")
    private String EUI;



    public Sensor()
    {
    }

    public Sensor(String EUI) {
        this.EUI = EUI;
        this.sensorsData= new HashSet<>();
    }

    public Set<SensorData> getSensorsData() {
        return sensorsData;
    }

    public void setSensorsData(Set<SensorData> sensorsData) {
        this.sensorsData = sensorsData;
    }

    public DataType getTypeId() {
        return typeId;
    }

    public void setTypeId(DataType typeId) {
        this.typeId = typeId;
    }

    public Long getSensorId() {
        return sensorID;
    }

    public void setSensorId(Long sensorId) {
        this.sensorID = sensorId;
    }

    public Set<Terrarium> getTerrariums() {
        return terrariums;
    }

    public void setTerrariums(Set<Terrarium> terrariums) {
        this.terrariums = terrariums;
    }

    public String getEUI() {
        return EUI;
    }

    public void setEUI(String EUI) {
        this.EUI = EUI;
    }

}
