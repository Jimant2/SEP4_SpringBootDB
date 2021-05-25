package WebAPI.SensorData;

import WebAPI.Sensor.Sensor;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity(name = "SensorData")
@Table(name = "sensorData")
public class SensorData {

    @OneToMany(mappedBy = "sensor",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Sensor> sensors = new HashSet<>();


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
    @Column(name = "valueId", updatable = false)
    private Long valueId;
    @Column(name = "temperatureData")
    private int temperatureData;
    @Column(name = "C02Data")
    private int C02Data;
    @Column(name = "humidityData")
    private int humidityData;
    @Column(name = "naturalLightLevel")
    private int naturalLightLevel;

    public SensorData(Long valueId, int temperatureData, int c02Data, int humidityData, int naturalLightLevel) {
        this.valueId = valueId;
        this.temperatureData = temperatureData;
        C02Data = c02Data;
        this.humidityData = humidityData;
        this.naturalLightLevel = naturalLightLevel;
    }

    public SensorData(){}

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
