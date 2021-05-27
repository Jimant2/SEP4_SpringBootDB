package WebAPI.Sensor;



public class SensorNotFoundException extends RuntimeException{
    SensorNotFoundException(Long valueId) {
        super("Could not find Sensor with id " + valueId);
    }
}
