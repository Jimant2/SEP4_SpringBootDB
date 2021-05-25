package WebAPI.SensorType;

public class SensorTypeNotFoundException extends RuntimeException{
    SensorTypeNotFoundException(Long typeId) {
        super("Could not find Sensor Type with id " + typeId);
    }
}
