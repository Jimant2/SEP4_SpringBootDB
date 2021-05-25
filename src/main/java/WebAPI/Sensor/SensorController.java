package WebAPI.Sensor;


import WebAPI.SensorData.SensorData;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SensorController {

    private final SensorRepository sensorRepository;

    SensorController(SensorRepository sensorRepository)
    {
        this.sensorRepository = sensorRepository;
    }

    @GetMapping("/Sensor")
    List<Sensor> all(){return sensorRepository.findAll();}

    @PostMapping("/Sensor")
    Sensor newSensor (@RequestBody Sensor sensor)
    {
        return sensorRepository.save(sensor);
    }
    @GetMapping("/Sensor/{sensorDataId}")
    Sensor one(@PathVariable SensorData sensorDataId){
        return sensorRepository.findById(sensorDataId).orElseThrow(
                () -> new SensorNotFoundException(sensorDataId)
        );
    }
    Sensor updateSensor(@RequestBody Sensor newSensor, @PathVariable SensorData sensorDataId)
    {
        return sensorRepository.findById(sensorDataId)
                .map(sensor -> {
                    sensor.setSensorData(newSensor.getSensorData());
                    sensor.setEUI(newSensor.getEUI());
                    return sensorRepository.save(newSensor);
                })
                .orElseGet(() -> sensorRepository.save(newSensor));
    }
    @DeleteMapping("SensorType/{sensorDataId}")
    void deleteSensor(@PathVariable SensorData sensorDataId)
    {
        sensorRepository.deleteById(sensorDataId);
    }
}
