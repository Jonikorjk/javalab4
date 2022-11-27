package task1;

/**
 * The class which solve the task
 */
public class TramRouteWithArray extends AbstractTramRoute {
    protected Station[] stations;

    /**
     * <p>TramRouteWithArray()</p>
     * Function creates TramRouteWithArray object
     * @param num num of the tram route
     * @param averageInterval average interval between stations
     * @param stations stations
     */
    public TramRouteWithArray(int num, int averageInterval, Station[] stations) {
        super(num, averageInterval);
        this.stations = stations.clone();
    }

    /**
     * <p>addStation()</p>
     * Function that adds station to array of stations
     * @param station station
     */
    public void addStation(Station station) {
        Station[] temp = new Station[stations.length + 1];
        for (int i = 0; i < stations.length; i++) {
            temp[i] = stations[i];
        }
        temp[temp.length - 1] = station;
        stations = temp;
    }

    /**
     * <p>getTramRoute()</p>
     * Function that returns array of station (tram route)
     * @return tram route
     */
    @Override
    public Station[] getTramRoute() {
        return stations;
    }

    /**
     * <p>setTramRouteWithArray()</p>
     * Function that sets array of stations
     * @param t - array of stations
     */
    @Override
    public void setTramRouteWithArray(Station[] t) {
        stations = t;
    }

}
