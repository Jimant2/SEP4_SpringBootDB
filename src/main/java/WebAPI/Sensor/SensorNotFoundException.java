package WebAPI.Sensor;

import WebAPI.SensorData.SensorData;

public class SensorNotFoundException extends RuntimeException{
    SensorNotFoundException(SensorData sensorDataId) {
        super("Could not find Sensor with id " + sensorDataId);
    }
}
