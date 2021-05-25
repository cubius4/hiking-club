package engine;

import java.util.ArrayList;

/**
 * This class represents the Hiking club
 */
public class HikingClub {
    /**
     * Stores all hikes to be done
     */
    private ArrayList<HikeInfo> hikes;
    /**
     * Stores all registered hikers that are part of this hiking club
     */
    private ArrayList<Hiker> registered;

    /**
     * Constructs a new HikingClub object
     */
    public HikingClub() {
        hikes = new ArrayList<HikeInfo>();
        registered = new ArrayList<Hiker>();
    }

    /**
     *
     * @return all hikes to be done
     */
    public ArrayList<HikeInfo> getHikes() {return hikes;}

    /**
     *
     * @return the list of registered hikers
     */
    public ArrayList<Hiker> getRegisteredHikers() {return registered;}

    /**
     * Adds a new hike to the list of hikes and sorts the list in abc order by hike
     * @param hikeLocation the location of the new hike
     * @param hikeTime the duration of the new hike
     * @param hikerName the name of the hiker that will participate in the hike
     */
    public void addHike(String hikeLocation, int hikeTime, String hikerName) {
        boolean added = false;
        for (int i = 0; i < hikes.size(); i++) {
            if (hikerName.compareTo(hikes.get(i).getHiker().getName()) <= 0 && !added) {
                hikes.add(i, new HikeInfo(this, hikeLocation, hikerName, hikeTime));
                added = true;
            }
        }
        if(!added) {
            hikes.add(new HikeInfo(this, hikeLocation, hikerName, hikeTime));
        }
    }

    /**
     * Removes a certain hike from the list of hikes
     * @param hikeLocation  The location of the hike
     * @param hikeTime the duration of the hike
     * @param hikerName the name of the hike
     */
    public void removeHike(String hikeLocation, int hikeTime, String hikerName) {
        for(HikeInfo h : hikes) {
            if(h.getHiker().getName().equalsIgnoreCase(hikerName) &&
                    h.getLoc().getLoc().equalsIgnoreCase(hikeLocation) && h.getTime() == hikeTime) {
                hikes.remove(h);
            }
        }
    }

    /**
     * Adds a registered hiker to the list of hikerss
     * @param h The hiker to be added
     */
    public void addRegisteredHiker(Hiker h) {
        registered.add(h);
    }

    /**
     *
     * @return A string representation of all the hikes
     */
    public String printHikingClub() {
        String hikerStr = "";
        for (HikeInfo h : hikes) {
            hikerStr += (h.toString() + " | ");
        }
        return hikerStr;
    }

    /**
     *
     * @param hName The name of the hiker
     * @return The total duration of hikes for a registered hiker
     */
    public int printHikerTime(String hName) {
        boolean found = false;
        int sum = 0;
        for(HikeInfo hike : hikes) {
            if(hike.getHiker().getName().equalsIgnoreCase(hName)) {
                sum += hike.getTime();
                found = true;
            }
        }
        if(!found) {
            return 0;
        }
        return sum;
    }

    /**
     *
     * @param hName The name of the location
     * @return The total duration of hikes for a certain location
     */
    public int printLocTime(String hName) {
        boolean found = false;
        int sum = 0;
        for(HikeInfo hike : hikes) {
            if(hike.getLoc().getLoc().equalsIgnoreCase(hName)) {
                sum += hike.getTime();
                found = true;
            }
        }
        if(!found) {
            return 0;
        }
        return sum;
    }

}
