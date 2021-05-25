package WebAPI.SensorType;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity(name = "SensorType")
@Table(name = "sensorType")
public class SensorType {


    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sensorType_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @Column(name = "typeId", updatable = false)
    private Long sensorTypeId;
    @Column(name = "c02")
    private int c02;
    @Column(name = "temperature")
    private int temperature;
    @Column(name = "humidity")
    private int humidity;
    @Column(name = "naturalLightLevel")
    private int naturalLightLevel;


    public SensorType(){}

    public SensorType(Long sensorTypeId, int c02, int temperature,
                      int humidity, int naturalLightLevel) {
        this.sensorTypeId = sensorTypeId;
        this.c02 = c02;
        this.temperature = temperature;
        this.humidity = humidity;
        this.naturalLightLevel = naturalLightLevel;
    }

    public Long getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(Long sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public int getC02() {
        return c02;
    }

    public void setC02(int c02) {
        this.c02 = c02;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getNaturalLightLevel() {
        return naturalLightLevel;
    }

    public void setNaturalLightLevel(int naturalLightLevel) {
        this.naturalLightLevel = naturalLightLevel;
    }
}
