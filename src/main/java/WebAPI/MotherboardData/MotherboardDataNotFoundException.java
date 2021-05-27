package WebAPI.MotherboardData;

public class MotherboardDataNotFoundException extends RuntimeException{
    MotherboardDataNotFoundException(Long motherboardid) {
        super("Could not find Motherboard Data with id " + motherboardid);
    }
}
