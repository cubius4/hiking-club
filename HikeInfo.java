package engine;

/**
 * A class which stores the information for an individual hike, including the Hiking club, the hiker, the
 * location to be hiked in, the name of the hiker, and the time that the hike is expected to take.
 */
public class HikeInfo {
    /**
     * The hiking club for this hike
     */
    private HikingClub club;
    /**
     * The hiker for this hike
     */
    private Hiker hiker;
    /**
     * The location for this hike
     */
    private HikeLocation loc;
    /**
     * The name of the hiker for this hike
     */
    private String hikerName;
    /**
     * The duration for this hike
     */
    private int time;

    /**
     * Constructs a new HikeInfo object
     * @param c The hiking club for this hike
     * @param hikeLoc the location for this hike
     * @param name The name of the hiker for this hike
     * @param hikeTime The duration of this hike
     */
    public HikeInfo(HikingClub c, String hikeLoc, String name, int hikeTime) {
        club = c;
        time = hikeTime;
        hikerName = name;
        setHiker();
        loc = new HikeLocation(hikeLoc);
    }

    /**
     *
     * @return The hiker for this hike
     */
    public Hiker getHiker() {return hiker;}

    /**
     *
     * @return The location for this hike
     */
    public HikeLocation getLoc() {return loc;}

    /**
     *
     * @return The duration for this hike
     */
    public int getTime() {return time;}

    /**
     * Sets the hiker for this hike
     * @return true if the hiker already exists, false if a new hiker was created.
     */
    public boolean setHiker() {
        for(int i = 0; i < club.getRegisteredHikers().size(); i++) {
            if (club.getRegisteredHikers().get(i).getName().equalsIgnoreCase(hikerName)) {
                hiker = club.getRegisteredHikers().get(i);
                return true;
            }
        }
        hiker = new Hiker(this, hikerName);
        club.addRegisteredHiker(hiker);
        return false;
    }

    /**
     *
     * @return A string representation of this hike
     */
    public String toString() {
        return "Hiker: " + hikerName + "; Location: " + loc + "; Duration: " + time;
    }

}
