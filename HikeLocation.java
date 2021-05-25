package engine;

/**
 * This class represents a location for a hike
 */
public class HikeLocation {
//    private final String loc1 = "Everglades Trail";
//    private final String loc2 = "The Beach";
//    private final String loc3 = "Biscayne";
//    private final String loc4 = "The Hill";

    /**
     * The name of the location
     */
    private String location;

    /**
     * Constructs a new HikeLocation Object
     * @param loc the location
     */
    public HikeLocation(String loc) {
        location = loc;
    }

    /**
     *
     * @return The name of the location
     */
    public String getLoc() {return location;}

    /**
     *
     * @return A string representation of the location
     */
    public String toString() {
        return location;
    }

}
