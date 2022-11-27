package task1;

import java.util.Objects;

/**
 * The class that describe Station
 */
public class Station implements Comparable<Station> {
    private String name;
    private int amountOfPassengers;

    /**
     * <p>Station()</p>
     * Function creates Station object
     * @param name name of station
     * @param  amountOfPassengers amount of passengers
     */
    Station(String name, int amountOfPassengers) {
        this.name = name;
        this.amountOfPassengers = amountOfPassengers;
    }

    /**
     * <p>getNameOfStation()</p>
     * Function that gets access to name of station
     * @return returns name of the station
     */
    public String getNameOfStation() { return name; }

    /**
     * <p>getPassengers()</p>
     * Function that gets access to amount of passengers
     * @return returns amount of passengers on this station
     */
    public int getPassengers() { return amountOfPassengers; }

    /**
     * <p>getPassengers()</p>
     * Function that sets passengers
     * @param passengers amount of passengers
     */
    public void setPassengers(int passengers) { amountOfPassengers = passengers; }

    /**
     * <p>setNameOfStation()</p>
     * Function that sets name of station
     * @param station name of station
     */
    public void setNameOfStation(String station) { name = station; }

    /**
     * Overrode function toString()
     * @return Converts objects parameters into string format sentences and returns it.
     */
    @Override
    public String toString() {
        return name + " passengers: " + amountOfPassengers;
    }

    /**
     * <p>toLongFormString()</p>
     * Function that return long form of info about station
     * @return long form of info about station
     */
    public String toLongFormString() {
        return "Station Name: " +  name + " amount of passengers on this station: " + amountOfPassengers;
    }

    /**
     * Overrode function of Comparable interface<br>
     * Compares links and then parameters of objects.
     * @param station object to compare
     * @return true - equal<br>
     * false - not equal
     */
    @Override
    public boolean equals(Object station) {
        if (this == station) {
            return true;
        }
        if (station == null || !(station instanceof Station)) {
            return  false;
        }

        Station st = (Station)station;
        return name.equals(st.name) && amountOfPassengers == st.amountOfPassengers;
    }


    /**
     * Overrode function hashCode()
     * @return converts objects parameters into string format sentences and returns it
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, amountOfPassengers);
    }

    /**
     * Overrode function compareTo()
     * @param o object to compare
     * @return Returns some int < 0 if first string is less than second string, <br>0 if strings are equal, > 1 if first string is bigger than second.
     */
    @Override
    public int compareTo(Station o) {
        return name.compareTo(o.name);
    }
}
