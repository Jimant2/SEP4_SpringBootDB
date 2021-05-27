package WebAPI.Sensor;

import java.io.Serializable;

public class SensorRelationship implements Serializable {
    private Long sensorID;
    private DataType typeId;

    public Long getSensorID() {
        return sensorID;
    }

    public void setSensorID(Long sensorID) {
        this.sensorID = sensorID;
    }

    public DataType getTypeId() {
        return typeId;
    }

    public void setTypeId(DataType typeId) {
        this.typeId = typeId;
    }
}
