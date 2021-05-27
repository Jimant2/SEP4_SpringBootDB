package WebAPI.SensorData;

import WebAPI.Sensor.Sensor;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "SensorData")
@Table(name = "sensorData")
public class SensorData {





    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sensorData_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @Column(name = "valueId")
    private Long valueId;
    @Column(name = "temperatureData")
    private int temperatureData;
    @Column(name = "C02Data")
    private int C02Data;
    @Column(name = "humidityData")
    private int humidityData;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "valueId", referencedColumnName = "sensor_id", insertable=false, updatable=false),
    @JoinColumn(name = "typeId", referencedColumnName = "typeId", insertable=false, updatable=false)})
    private Sensor sensorId;
    @Column(name = "naturalLightLevel")
    private int naturalLightLevel;
    @Column(name = "time")
    private Timestamp time;

    public SensorData( int temperatureData, int c02Data, int humidityData, int naturalLightLevel) {
        this.temperatureData = temperatureData;
        C02Data = c02Data;
        this.humidityData = humidityData;
        this.time = Timestamp.valueOf(LocalDateTime.now());
        this.naturalLightLevel = naturalLightLevel;
        this.sensorId = getSensorId();
    }

    public SensorData(){}

    public Sensor getSensorId() {
        return sensorId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setSensorId(Sensor sensorId) {
        this.sensorId = sensorId;
    }

    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    public int getTemperatureData() {
        return temperatureData;
    }

    public void setTemperatureData(int temperatureData) {
        this.temperatureData = temperatureData;
    }

    public int getC02Data() {
        return C02Data;
    }

    public void setC02Data(int c02Data) {
        C02Data = c02Data;
    }

    public int getHumidityData() {
        return humidityData;
    }

    public void setHumidityData(int humidityData) {
        this.humidityData = humidityData;
    }

    public int getNaturalLightLevel() {
        return naturalLightLevel;
    }

    public void setNaturalLightLevel(int naturalLightLevel) {
        this.naturalLightLevel = naturalLightLevel;
    }
}
