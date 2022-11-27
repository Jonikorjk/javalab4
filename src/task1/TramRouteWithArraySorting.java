package task1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The class which overriding sorting methods
 */
public class TramRouteWithArraySorting extends TramRouteWithArray {

    /**
     * <p>TramRouteWithArraySorting()</p>
     * Function creates TramRouteWithArraySorting object
     * @param num number of tram route
     * @param avarageInterval average interval between stations
     * @param stations stations
     */
    public TramRouteWithArraySorting(int num, int avarageInterval, Station[] stations) {
        super(num, avarageInterval, stations);
    }

    /**
     * <p>nameOfStationSort()</p>
     * Function that sorts array of station using Comparable-way
     * @return sorted stations
     */
    @Override
    public Station[] nameOfStationSort() {
        if (stations.length == 0 || stations == null) return null;
        Station[] sortedStations = stations.clone();
        Arrays.sort(sortedStations);
        return sortedStations;
    }

    /**
     * <p>passengersSort()</p>
     * Function that sorts array of station using Comparator-way
     * @return sorted stations
     */
    @Override
    public Station[] passengersSort() {
        if (stations.length == 0 || stations == null) return null;
        Station[] sortedStations = stations.clone();
        Arrays.sort(sortedStations, new Comparator<Station>() {
            @Override
            public int compare(Station o1, Station o2) {
                return o1.getNameOfStation().compareTo(o2.getNameOfStation());
            }
        });
        return sortedStations;
    }
}
