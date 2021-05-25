package WebAPI.SensorType;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SensorTypeController {
    private final SensorTypeRepository sensorTypeRepository;

    SensorTypeController(SensorTypeRepository sensorTypeRepository)
    {
        this.sensorTypeRepository = sensorTypeRepository;
    }

    @GetMapping("/SensorType")
    List<SensorType> all(){return sensorTypeRepository.findAll();}

    @PostMapping("/SensorType")
    SensorType newSensorData (@RequestBody SensorType sensorType)
    {
        return sensorTypeRepository.save(sensorType);
    }
    @GetMapping("/SensorType/{typeId}")
    SensorType one(@PathVariable Long typeId){
        return sensorTypeRepository.findById(typeId).orElseThrow(
                () -> new SensorTypeNotFoundException(typeId)
        );
    }
    SensorType updateSensorType(@RequestBody SensorType newSensorType, @PathVariable Long typeId)
    {
        return sensorTypeRepository.findById(typeId)
                .map(sensorType -> {
                    sensorType.setSensorTypeId(newSensorType.getSensorTypeId());
                    sensorType.setC02(newSensorType.getC02());
                    sensorType.setHumidity(newSensorType.getHumidity());
                    sensorType.setTemperature(newSensorType.getTemperature());
                    sensorType.setNaturalLightLevel(newSensorType.getNaturalLightLevel());
                    return sensorTypeRepository.save(newSensorType);
                })
                .orElseGet(() -> {
                    newSensorType.setSensorTypeId(typeId);
                    return sensorTypeRepository.save(newSensorType);
                });
    }
    @DeleteMapping("SensorType/{typeId}")
    void deleteSensorType(@PathVariable Long typeId)
    {
        sensorTypeRepository.deleteById(typeId);
    }
}
