package bookinghouse.myExceptions;

public class HouseAlreadyBookedException extends RuntimeException {

    public HouseAlreadyBookedException(String message) {
        super("House already booked, Select other home!" + message);
    }

}
