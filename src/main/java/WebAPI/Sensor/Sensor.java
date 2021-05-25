package WebAPI.Sensor;

import WebAPI.SensorData.SensorData;
import WebAPI.Terrarium.Terrarium;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


import java.util.HashSet;
import java.util.Set;


@Entity(name = "Sensor")
@Table(name = "sensor")

public class Sensor {

    @OneToMany(mappedBy = "Sensor",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    @ManyToOne
    @JoinColumn(name = "sensorDataId", updatable = false)
    private SensorData sensorDataId;
    @Column(name = "EUI")
    private String EUI;


     public Sensor()
    {

    }

    public Sensor(SensorData sensorDataId, String EUI) {
        this.sensorDataId = sensorDataId;
        this.EUI = EUI;

    }

    public SensorData getSensorData() {
        return sensorDataId;
    }

    public void setSensorData(SensorData sensorData) {
        this.sensorDataId = sensorData;
    }


    public String getEUI() {
        return EUI;
    }

    public void setEUI(String EUI) {
        this.EUI = EUI;
    }

}
