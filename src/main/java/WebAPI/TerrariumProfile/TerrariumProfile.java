package WebAPI.TerrariumProfile;

import WebAPI.Task.Task;
import WebAPI.TaskList.TaskList;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "TerrariumProfile")
@Table(name = "terrariumProfile")
public class TerrariumProfile {

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TaskList> taskLists = new HashSet<>();
    @OneToMany(mappedBy = "terrariumProfile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Task> tasks = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "terrariumProfile_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    @Column(name = "profileId", updatable = false)
    private Long TerrariumProfileId;
    @Column(nullable = false)
    private String TerrariumProfileName;
    @Column(nullable = false)
    private int minAllowedTemp;
    @Column(nullable = false)
    private int maxAllowedTemp;
    @Column(nullable = false)
    private int minAllowedHumidity;
    @Column(nullable = false)
    private int minAllowedLightLevel;
    @Column(nullable = false)
    private int maxAllowedLightLevel;
    @Column(nullable = false)
    private int minAllowedC02;
    @Column(nullable = false)
    private int maxAllowedC02;
    @Column(nullable = false)
    private int maxAllowedHumidity;


    public TerrariumProfile() {
    }

    public TerrariumProfile(Long terrariumProfileId, String terrariumProfileName, int minAllowedTemp,
                            int maxAllowedTemp, int minAllowedHumidity, int minAllowedLightLevel,
                            int maxAllowedLightLevel, int minAllowedC02, int maxAllowedC02, int maxAllowedHumidity
                            ) {
        TerrariumProfileId = terrariumProfileId;
        TerrariumProfileName = terrariumProfileName;
        this.minAllowedTemp = minAllowedTemp;
        this.maxAllowedTemp = maxAllowedTemp;
        this.minAllowedHumidity = minAllowedHumidity;
        this.minAllowedLightLevel = minAllowedLightLevel;
        this.maxAllowedLightLevel = maxAllowedLightLevel;
        this.minAllowedC02 = minAllowedC02;
        this.maxAllowedC02 = maxAllowedC02;
        this.maxAllowedHumidity = maxAllowedHumidity;

    }


    public Long getTerrariumProfileId() {
        return TerrariumProfileId;
    }

    public void setTerrariumProfileId(Long terrariumProfileId) {
        TerrariumProfileId = terrariumProfileId;
    }

    public String getTerrariumProfileName() {
        return TerrariumProfileName;
    }

    public void setTerrariumProfileName(String terrariumProfileName) {
        TerrariumProfileName = terrariumProfileName;
    }

    public int getMinAllowedTemp() {
        return minAllowedTemp;
    }

    public void setMinAllowedTemp(int minAllowedTemp) {
        this.minAllowedTemp = minAllowedTemp;
    }

    public int getMaxAllowedTemp() {
        return maxAllowedTemp;
    }

    public void setMaxAllowedTemp(int maxAllowedTemp) {
        this.maxAllowedTemp = maxAllowedTemp;
    }

    public int getMinAllowedHumidity() {
        return minAllowedHumidity;
    }

    public void setMinAllowedHumidity(int minAllowedHumidity) {
        this.minAllowedHumidity = minAllowedHumidity;
    }

    public int getMinAllowedLightLevel() {
        return minAllowedLightLevel;
    }

    public void setMinAllowedLightLevel(int minAllowedLightLevel) {
        this.minAllowedLightLevel = minAllowedLightLevel;
    }

    public int getMaxAllowedLightLevel() {
        return maxAllowedLightLevel;
    }

    public void setMaxAllowedLightLevel(int maxAllowedLightLevel) {
        this.maxAllowedLightLevel = maxAllowedLightLevel;
    }

    public int getMinAllowedC02() {
        return minAllowedC02;
    }

    public void setMinAllowedC02(int minAllowedC02) {
        this.minAllowedC02 = minAllowedC02;
    }

    public int getMaxAllowedC02() {
        return maxAllowedC02;
    }

    public void setMaxAllowedC02(int maxAllowedC02) {
        this.maxAllowedC02 = maxAllowedC02;
    }

    public int getMaxAllowedHumidity() {
        return maxAllowedHumidity;
    }

    public void setMaxAllowedHumidity(int maxAllowedHumidity) {
        this.maxAllowedHumidity = maxAllowedHumidity;
    }

}
