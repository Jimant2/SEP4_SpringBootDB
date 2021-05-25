package WebAPI.SensorData;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SensorDataController {
    private final SensorDataRepository sensorDataRepository;

    SensorDataController(SensorDataRepository sensorDataRepository)
    {
        this.sensorDataRepository = sensorDataRepository;
    }

    @GetMapping("/SensorType")
    List<SensorData> all(){return sensorDataRepository.findAll();}

    @PostMapping("/SensorType")
    SensorData newSensorData (@RequestBody SensorData sensorData)
    {
        return sensorDataRepository.save(sensorData);
    }
    @GetMapping("/SensorType/{valueId}")
    SensorData one(@PathVariable Long valueId){
        return sensorDataRepository.findById(valueId).orElseThrow(
                () -> new SensorDataNotFoundException(valueId)
        );
    }
    SensorData updateSensorData(@RequestBody SensorData newSensorData, @PathVariable Long valueId)
    {
        return sensorDataRepository.findById(valueId)
                .map(sensorData -> {
                    sensorData.setValueId(newSensorData.getValueId());
                    sensorData.setTemperatureData(newSensorData.getTemperatureData());
                    sensorData.setC02Data(newSensorData.getC02Data());
                    sensorData.setHumidityData(newSensorData.getHumidityData());
                    sensorData.setNaturalLightLevel(newSensorData.getNaturalLightLevel());
                    return sensorDataRepository.save(newSensorData);
                })
                .orElseGet(() -> {
                    newSensorData.setValueId(valueId);
                    return sensorDataRepository.save(newSensorData);
                });
    }
    @DeleteMapping("SensorType/{valueId}")
    void deleteSensorData(@PathVariable Long valueId)
    {
        sensorDataRepository.deleteById(valueId);
    }
}
