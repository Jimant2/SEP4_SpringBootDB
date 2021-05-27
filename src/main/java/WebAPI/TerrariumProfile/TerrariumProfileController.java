package WebAPI.TerrariumProfile;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TerrariumProfileController {
    private final TerrariumProfileRepository terrariumProfileRepository;


    TerrariumProfileController(TerrariumProfileRepository terrariumProfileRepository)
    {
        this.terrariumProfileRepository = terrariumProfileRepository;
    }

    @GetMapping("/TerrariumProfile")
    List<TerrariumProfile> all(){return terrariumProfileRepository.findAll();}

    @PostMapping("/TerrariumProfile")
    TerrariumProfile newTerrariumProfile(@RequestBody TerrariumProfile terrariumProfile)
    {
        return terrariumProfileRepository.save(terrariumProfile);
    }
    @GetMapping("/TerrariumProfile/{profileId}")
    TerrariumProfile one(@PathVariable Long profileId){
        return terrariumProfileRepository.findById(profileId).orElseThrow(
                () -> new TerrariumProfileNotFoundException(profileId)
        );
    }

    @PutMapping("/TerrariumProfile/{profileId}")
    TerrariumProfile updateTerrariumProfile(@RequestBody TerrariumProfile newTerrariumProfile, @PathVariable Long profileId)
    {
        return terrariumProfileRepository.findById(profileId)
                .map(terrariumProfile -> {
                    terrariumProfile.setTerrariumProfileName(newTerrariumProfile.getTerrariumProfileName());
                    terrariumProfile.setTerrariumProfileId(newTerrariumProfile.getTerrariumProfileId());
                    terrariumProfile.setMaxAllowedC02(newTerrariumProfile.getMaxAllowedC02());
                    terrariumProfile.setMaxAllowedHumidity(newTerrariumProfile.getMaxAllowedHumidity());
                    terrariumProfile.setMinAllowedHumidity(newTerrariumProfile.getMinAllowedHumidity());
                    terrariumProfile.setMaxAllowedC02(newTerrariumProfile.getMaxAllowedC02());
                    terrariumProfile.setMinAllowedC02(newTerrariumProfile.getMinAllowedC02());
                    terrariumProfile.setMaxAllowedLightLevel(newTerrariumProfile.getMaxAllowedLightLevel());
                    terrariumProfile.setMinAllowedLightLevel(newTerrariumProfile.getMinAllowedLightLevel());
                    terrariumProfile.setMaxAllowedTemp(newTerrariumProfile.getMaxAllowedTemp());
                    terrariumProfile.setMinAllowedTemp(newTerrariumProfile.getMinAllowedTemp());
                    terrariumProfile.setTerrariumProfileId(newTerrariumProfile.getTerrariumProfileId());
                    return terrariumProfileRepository.save(newTerrariumProfile);
                })
                .orElseGet(() -> {
                    newTerrariumProfile.setTerrariumProfileId(profileId);
                    return terrariumProfileRepository.save(newTerrariumProfile);
                });
    }
    @DeleteMapping("TerrariumProfile/{profileId}")
    void deleteTerrariumProfile(@PathVariable Long profileId)
    {
        terrariumProfileRepository.deleteById(profileId);
    }
}
