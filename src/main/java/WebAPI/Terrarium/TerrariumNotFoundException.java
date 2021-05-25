package WebAPI.Terrarium;

public class TerrariumNotFoundException extends RuntimeException{
    TerrariumNotFoundException(Long TerrariumId) {
        super("Could not find Terrarium with id " + TerrariumId);
    }
}
