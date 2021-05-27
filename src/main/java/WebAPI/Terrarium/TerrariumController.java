package WebAPI.Terrarium;


import WebAPI.Task.Task;
import WebAPI.TaskList.TaskList;
import WebAPI.TerrariumProfile.TerrariumProfile;
import WebAPI.TerrariumProfile.TerrariumProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TerrariumController {
    private final TerrariumRepository terrariumRepository;
    private final TerrariumProfileRepository terrariumProfileRepository;

    TerrariumController(TerrariumRepository terrariumRepository, TerrariumProfileRepository terrariumProfileRepository)
    {
        this.terrariumRepository = terrariumRepository;
        this.terrariumProfileRepository = terrariumProfileRepository;
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

    @PutMapping("/Terrarium/{terrariumId}/TerrariumProfile/{profileId}")
    Terrarium addTerrariumProfileToTerrarium(@PathVariable Long terrariumId, @PathVariable Long profileId) {
        Terrarium terrarium = terrariumRepository.findById(terrariumId).get();
        TerrariumProfile terrariumProfile = terrariumProfileRepository.findById(profileId).get();
        terrarium.addTerrariumProfileToTerrarium(terrariumProfile);
        return terrariumRepository.save(terrarium);
    }



    @PutMapping("/Terrarium/{terrariumId}")
    Terrarium updateTerrarium(@RequestBody Terrarium newTerrarium, @PathVariable Long terrariumId)
    {
        return terrariumRepository.findById(terrariumId)
                .map(terrarium -> {
                    terrarium.setTerrariumId(newTerrarium.getTerrariumId());
                    terrarium.setSensor(newTerrarium.getSensor());
                    terrarium.setTerrariumName(newTerrarium.getTerrariumName());
                    terrarium.setUser(newTerrarium.getUser());
                    terrarium.setTerrariumProfiles(newTerrarium.getTerrariumProfiles());
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
