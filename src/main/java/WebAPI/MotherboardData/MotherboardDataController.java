package WebAPI.MotherboardData;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotherboardDataController {

    private final MotherboardDataRepository motherboardDataRepository;

    MotherboardDataController(MotherboardDataRepository motherboardDataRepository) {
        this.motherboardDataRepository = motherboardDataRepository;
    }

    @GetMapping("/MotherboardData")
    List<MotherboardData> all() {
        return motherboardDataRepository.findAll();
    }

    @PostMapping("/MotherboardData")
    MotherboardData newMotherboardData(@RequestBody MotherboardData newMotherboardData) {
        return motherboardDataRepository.save(newMotherboardData);
    }

    @GetMapping("/MotherboardData/{recordid}")
    MotherboardData one(@PathVariable Long recordid) {
        return motherboardDataRepository.findById(recordid).orElseThrow(
                () -> new MotherboardDataNotFoundException(recordid)
        );
    }

    @PutMapping("/MotherboardData/{recordid}")
    MotherboardData updateMotherboardData(@RequestBody MotherboardData newMotherboardData, @PathVariable Long recordid) {
        return motherboardDataRepository.findById(recordid)
                .map(motherboardData -> {
                    motherboardData.setCo2(newMotherboardData.getCo2());
                    motherboardData.setEui(newMotherboardData.getEui());
                    motherboardData.setFrequencydata(newMotherboardData.getFrequencydata());
                    motherboardData.setHumidity(newMotherboardData.getHumidity());
                    motherboardData.setLightLevel(newMotherboardData.getLightLevel());
                    motherboardData.setSequencedata(newMotherboardData.getSequencedata());
                    motherboardData.setTemperature(newMotherboardData.getTemperature());
                    motherboardData.setTime(newMotherboardData.getTime());
                    motherboardData.setTerrarium(newMotherboardData.getTerrarium());
                    motherboardData.setTerrariumSet(newMotherboardData.getTerrariumSet());
                    return motherboardDataRepository.save(motherboardData);
                })
                .orElseGet(() -> {
                    newMotherboardData.setRecordId(recordid);
                    return motherboardDataRepository.save(newMotherboardData);
                });
    }

    @DeleteMapping("MotherboardData/{recordid}")
    void deleteEmployee(@PathVariable Long recordid) {
        motherboardDataRepository.deleteById(recordid);
    }

}
