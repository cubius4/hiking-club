package engine;

/**
 * This class stores the data for a hiker
 */
public class Hiker {
    /**
     * The hike that this hiker will participate in
     */
    private HikeInfo info;
    /**
     * The name of this hiker
     */
    private String name;

    /**
     * Constructs a new Hiker object
     * @param h The hike that this hiker will participate in
     * @param n The name of this hiker
     */
    public Hiker(HikeInfo h, String n) {
        info = h;
        name = n;
    }

    /**
     *
     * @return The name of this hiker
     */
    public String getName() {return name;}

}
