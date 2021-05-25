package WebAPI.SensorData;

public class SensorDataNotFoundException extends RuntimeException{
    SensorDataNotFoundException(Long valueId) {
        super("Could not find Sensor Data with id " + valueId);
    }
}
