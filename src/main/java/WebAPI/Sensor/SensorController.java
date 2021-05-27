package WebAPI.Sensor;


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


    @GetMapping("/Sensor/{sensorId}")
    Sensor one(@PathVariable Long sensorId){
        return sensorRepository.findById(sensorId).orElseThrow(
                () -> new SensorNotFoundException(sensorId)
        );
    }




    @PutMapping("/Sensor/{sensorId}")
    Sensor updateSensor(@RequestBody Sensor newSensor, @PathVariable Long sensorId)
    {
        return sensorRepository.findById(sensorId)
                .map(sensor -> {
                    sensor.setSensorId(newSensor.getSensorId());
                    sensor.setEUI(newSensor.getEUI());
                    sensor.setSensorsData(newSensor.getSensorsData());
                    sensor.setTypeId(newSensor.getTypeId());
                    sensor.setTerrariums(newSensor.getTerrariums());
                    return sensorRepository.save(newSensor);
                })
                .orElseGet(() -> sensorRepository.save(newSensor));
    }


    @DeleteMapping("Sensor/{sensorId}")
    void deleteSensor(@PathVariable Long sensorId)
    {
        sensorRepository.deleteById(sensorId);
    }
}
