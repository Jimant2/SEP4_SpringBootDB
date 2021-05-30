package WebAPI.MotherboardData;

import WebAPI.Terrarium.Terrarium;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "MotherboardData")
@Table(name = "motherboardData")
public class MotherboardData {


    @OneToMany(mappedBy = "motherboardData" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Terrarium> terrariumSet = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "motherboardData_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )


    @Column(name = "recordId", updatable = false)
    private Long recordId;
    @Column(name = "time",nullable = false)
    private Timestamp time;
    @Column(name = "temperature", nullable = false)
    private int temperature;
    @Column(name = "humidity", nullable = false)
    private int humidity;
    @Column(name = "co2", nullable = false)
    private int co2;
    @Column(name = "lightlevel", nullable = false)
    private int lightLevel;
    @Column(name = "sequencedata", nullable = false)
    private int sequencedata;
    @Column(name = "frequencydata", nullable = false)
    private int frequencydata;
    @Column(name = "eui", nullable = false)
    private int eui;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "motherboardId", referencedColumnName = "motherboardId", insertable = false, updatable = false),
            @JoinColumn(name = "terrariumid", referencedColumnName = "terrariumid", insertable = false, updatable = false)})
    private Terrarium terrarium;


    public MotherboardData( int temperature,
                           int humidity, int co2, int lightLevel,
                           int sequencedata, int frequencydata, int eui) {
        this.time = Timestamp.valueOf(LocalDateTime.now());
        this.temperature = temperature;
        this.humidity = humidity;
        this.co2 = co2;
        this.lightLevel = lightLevel;
        this.sequencedata = sequencedata;
        this.frequencydata = frequencydata;
        this.eui = eui;
        this.terrariumSet=new HashSet<>();
    }

    public MotherboardData() {

    }


    public Set<Terrarium> getTerrariumSet() {
        return terrariumSet;
    }

    public void setTerrariumSet(Set<Terrarium> terrariumSet) {
        this.terrariumSet = terrariumSet;
    }

    public Terrarium getTerrarium() {
        return terrarium;
    }

    public void setTerrarium(Terrarium terrarium) {
        this.terrarium = terrarium;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public int getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel;
    }

    public int getSequencedata() {
        return sequencedata;
    }

    public void setSequencedata(int sequencedata) {
        this.sequencedata = sequencedata;
    }

    public int getFrequencydata() {
        return frequencydata;
    }

    public void setFrequencydata(int frequencydata) {
        this.frequencydata = frequencydata;
    }

    public int getEui() {
        return eui;
    }

    public void setEui(int eui) {
        this.eui = eui;
    }
}
