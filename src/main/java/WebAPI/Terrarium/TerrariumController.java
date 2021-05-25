package WebAPI.Terrarium;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TerrariumController {
    private final TerrariumRepository terrariumRepository;

    TerrariumController(TerrariumRepository terrariumRepository)
    {
        this.terrariumRepository = terrariumRepository;
    }

    @GetMapping("/Terrarium")
    List<Terrarium> all(){return terrariumRepository.findAll();}

    @PostMapping("/Terrarium")
    Terrarium newTerrarium(@RequestBody Terrarium terrarium)
    {
        return terrariumRepository.save(terrarium);
    }
    @GetMapping("/Terrarium/{terrariumId}")
    Terrarium one(@PathVariable Long terrariumId){
        return terrariumRepository.findById(terrariumId).orElseThrow(
                () -> new TerrariumNotFoundException(terrariumId)
        );
    }
    Terrarium updateTerrarium(@RequestBody Terrarium newTerrarium, @PathVariable Long terrariumId)
    {
        return terrariumRepository.findById(terrariumId)
                .map(terrarium -> {
                    terrarium.setTerrariumId(newTerrarium.getTerrariumId());
                    terrarium.setSensor(newTerrarium.getSensor());
                    terrarium.setTask(newTerrarium.getTask());
                    terrarium.setTerrariumName(newTerrarium.getTerrariumName());
                    terrarium.setUser(newTerrarium.getUser());
                    return terrariumRepository.save(newTerrarium);
                })
                .orElseGet(() -> {
                    newTerrarium.setTerrariumId(terrariumId);
                    return terrariumRepository.save(newTerrarium);
                });
    }
    @DeleteMapping("Terrarium/{terrariumId}")
    void deleteTerrarium(@PathVariable Long terrariumId)
    {
        terrariumRepository.deleteById(terrariumId);
    }
}
