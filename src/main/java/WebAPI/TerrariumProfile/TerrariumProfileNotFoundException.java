package WebAPI.TerrariumProfile;

public class TerrariumProfileNotFoundException extends RuntimeException {
    TerrariumProfileNotFoundException(Long TerrariumProfileId) {
        super("Could not find TerrariumProfile with id " + TerrariumProfileId);
    }

}
