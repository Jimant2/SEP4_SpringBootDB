package WebAPI.Terrarium;

public class TerrariumNotFoundException extends RuntimeException{
    TerrariumNotFoundException(Long terrariumid) {
        super("Could not find Terrarium with id " + terrariumid);
    }
}
