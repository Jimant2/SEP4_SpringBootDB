package WebAPI.Terrarium;


import WebAPI.MotherboardData.MotherboardData;
import WebAPI.MotherboardData.MotherboardDataRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TerrariumController {

    private final TerrariumRepository terrariumRepository;
    private final MotherboardDataRepository motherboardDataRepository;


    public TerrariumController(TerrariumRepository terrariumRepository, MotherboardDataRepository motherboardDataRepository) {
        this.terrariumRepository = terrariumRepository;
        this.motherboardDataRepository = motherboardDataRepository;
    }

    @GetMapping("/Terrarium")
    List<Terrarium> all() {
        return terrariumRepository.findAll();
    }

    @GetMapping("/Terrarium/{terrariumid}")
    Terrarium one(@PathVariable Long terrariumid) {
        return terrariumRepository.findById(terrariumid).orElseThrow(
                () -> new TerrariumNotFoundException(terrariumid)
        );
    }

    @PutMapping("/Terrarium/{terrariumid}/MotherboardData/{recordid}")
    Terrarium addMotherboardDataToTerrarium(@PathVariable Long terrariumid, @PathVariable Long recordid){
        Terrarium terrarium = terrariumRepository.findById(terrariumid).get();
        MotherboardData motherboardData = motherboardDataRepository.findById(recordid).get();
        terrarium.addMotherboardDataToTerrarium(motherboardData);
        return terrariumRepository.save(terrarium);
    }

    @PutMapping("/Terrarium/{terrariumid}")
    Terrarium updateTerrarium(@RequestBody Terrarium newTerrarium, @PathVariable Long terrariumid) {
        return terrariumRepository.findById(terrariumid)
                .map(terrarium -> {
                    terrarium.setUser(newTerrarium.getUser());
                    terrarium.setTask(newTerrarium.getTask());
                    terrarium.setName(newTerrarium.getName());
                    terrarium.setMotherboardDataSet(newTerrarium.getMotherboardDataSet());
                    terrarium.setTerrariumProfile1(newTerrarium.getTerrariumProfile1());
                    terrarium.setMotherboardData(newTerrarium.getMotherboardData());
                    terrarium.setMotherboardId(newTerrarium.getMotherboardId());
                    return terrarium;
                })
                .orElseGet(() -> {
                    newTerrarium.setTerrariumId(terrariumid);
                    return terrariumRepository.save(newTerrarium);
                });
    }

    @PostMapping("/Terrarium")
    Terrarium newTerrarium(@RequestBody Terrarium newTerrarium) {
        return terrariumRepository.save(newTerrarium);
    }

    @DeleteMapping("/Terrarium/{terrariumid}")
    void deleteTerrarium(@PathVariable Long terrariumid) {
        terrariumRepository.deleteById(terrariumid);
    }


}
