package task1;

import java.util.Arrays;
import java.util.Objects;

/**
 * Abstract class which describes tram route
 */
public abstract class AbstractTramRoute {
    protected int num = 0;
    protected int averageInterval = 0;

    public AbstractTramRoute(int num, int averageInterval) {
        this.num = num;
        this.averageInterval = averageInterval;
    }


    /**
     * <p>getNum()</p>
     * Function that get access to number of tram route
     * @return number of tram route
     */
    public int getNum() { return  num; }

    /**
     * <p>getAverageInterval()</p>
     * Function that get access to average interval between stations
     * @return average interval between stations
     */
    public int getAverageInterval() { return averageInterval; }

    /**
     * <p>setNum()</p>
     * Function that sets number of tram route
     * @param num number of tram route
     */
    public void setNum(int num) { this.num = num; }

    /**
     * <p>setAverageInterval()</p>
     * Function that sets average interval between stations
     * @param averageInterval average interval between stations
     */
    public void setAverageInterval(int averageInterval) { this.averageInterval = averageInterval; }

    /**
     * <p>append()</p>
     * Function that appends new element to array
     * @param arr array which appends
     * @param station new station
     * @return new array with new element
     */
    private Station[] append(Station[] arr, Station station) {
        Station[] newStations = new Station[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newStations[i] = arr[i];
        }
        newStations[newStations.length - 1] = station;
        return newStations;
    }


    /**
     * <p>getAllPassengers()</p>
     * Function returns all passengers
     * @return all passengers amount
     */
    public int getAllPassengers() {
        Station[] stations = getTramRoute().clone();
        Station minPassengers = stations[0];
        int allPassengers = 0;
        for (var i : stations) {
            allPassengers += i.getPassengers();
        }
        return allPassengers;
    }

    /**
     * <p>getStationsWithLeastNumberOfPassengers()</p>
     * Function returns all stations in way
     * @return all stations in way
     */
    public Station[] getStationsWithLeastNumberOfPassengers() {
        Station[] stations = getTramRoute().clone();
        Station minPassengers = stations[0];
        for (var i : stations) {
            if (minPassengers.getPassengers() > i.getPassengers()) {
                minPassengers = i;
            }
        }
        Station[] leastPassengers = new Station[1];
        leastPassengers[0] = minPassengers;
        for (int i = 0; i < stations.length; i++) {
            if ((leastPassengers[0].getPassengers() == stations[i].getPassengers()) &&
                    (!leastPassengers[0].equals(stations[i]))) {
                leastPassengers = append(leastPassengers, stations[i]);
            }
        }
        return leastPassengers;
    }

    /**
     * <p>getStationWithTheLargestName()</p>
     * Function returns stations with the largest name
     * @return stations with the largest name
     */
    public Station[] getStationWithTheLargestName() {
        Station[] stations = getTramRoute().clone();
        Station largestName = stations[0];
        for (var i : stations) {
            if (largestName.getNameOfStation().length() < i.getNameOfStation().length()) {
                largestName = i;
            }
        }
        Station[] largestNames = new Station[1];
        largestNames[0] = largestName;
        for (int i = 0; i < stations.length; i++) {
            if ((largestNames[0].getNameOfStation().length() == stations[i].getNameOfStation().length()) &&
                    (!largestNames[0].equals(stations[i]))) {
               largestNames = append(largestNames, stations[i]);
            }
        }
        return largestNames;
    }

    /**
     * <p>getTramRoute()</p>
     * Abstract method which returns the tram route
     * @return tram route
     */
    public abstract Station[] getTramRoute();
    /**
     * <p>setTramRouteWithArray()</p>
     * Abstract method which sets tram route
     * @param t tram route
     */
    public abstract void setTramRouteWithArray(Station[] t);

    /**
     * Overrode function toString()
     * @return Converts objects parameters into string format sentences and returns it.
     */
    @Override
    public String toString() {
        String info = "Number of all station: " + num + " Avarage time interval between stations: " + averageInterval + '\n';
        Station[] stations = getTramRoute();
        for (var i : stations) {
            info += i.toLongFormString() + '\n';
        }
        return info;
    }

    /**
     * Overrode function of Comparable interface<br>
     * Compares links and then parameters of objects.
     * @param obj object to compare
     * @return true - equal<br>
     * false - not equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbstractTramRoute c)) return false;
        if (num != c.num || averageInterval != c.averageInterval || getAllPassengers() != c.getAllPassengers()) return false;
        return Arrays.equals(getTramRoute(), c.getTramRoute());
    }

    /**
     * Overrode function hashCode()
     * @return converts objects parameters into string format sentences and returns it
     */
    @Override
    public int hashCode() {
        return Objects.hash(num, averageInterval);
    }

    /**
     * <p>passengersSort()</p>
     * Fuction that return sorted array of Station, (Sort bubble)
     * @return sorted array of stations
     */
    public Station[] passengersSort() {
        boolean mustSort = false;
        Station[] stations = getTramRoute().clone();
        if (stations.length == 0 || stations == null) return null;
        do {
            mustSort = false;
            for (int i = 0; i < stations.length - 1; i++) {
                if (stations[i].getPassengers() < stations[i + 1].getPassengers()) {
                    Station buffer = stations[i];
                    stations[i] = stations[i + 1];
                    stations[i + 1] = buffer;
                    mustSort = true;
                }
            }
        } while(mustSort);
        return stations;
    }

    /**
     * <p>nameOfStationSort()</p>
     * Fuction that return sorted array of Station, (Insert sort)
     * @return sorted array of stations
     */
    public Station[] nameOfStationSort() {
        Station[] stations = getTramRoute().clone();
        if (stations.length == 0 || stations == null) return null;
        for (int i = 1; i < stations.length; ++i) {
            Station key = stations[i];
            int j = i - 1;
            while (j >= 0 && stations[j].getNameOfStation().compareTo(key.getNameOfStation()) > 0) {
                stations[j + 1] = stations[j];
                j = j - 1;
            }
            stations[j + 1] = key;
        }
        return stations;
    }

    /**
     * <p>test()</p>
     * Function that tests functional of classes
     */
    public static void test() {

        Station[] stations = {
                new Station("Porkovsk", 15),
                new Station("Dobropolie", 2),
                new Station("Kramatorsk", 37),
                new Station("Slavyansk", 33),
                new Station("Izum", 15),
                new Station("Chygyev", 2),
                new Station("Kharkov", 74)
        };

        TramRouteWithArray tramRouteWithArray = new TramRouteWithArray(127, 15, stations);
        tramRouteWithArray.addStation(new Station("Kiev", 73));
        System.out.print(tramRouteWithArray);

        System.out.println("Total number of passengers: " + tramRouteWithArray.getAllPassengers());
        System.out.println("The station with the least number of passengers: " + Arrays.deepToString(tramRouteWithArray.getStationsWithLeastNumberOfPassengers()));
        System.out.println("With the longest name: " + Arrays.deepToString(tramRouteWithArray.getStationWithTheLargestName()));

        System.out.println("Bubble sort (in abstract class): " +  Arrays.deepToString(tramRouteWithArray.passengersSort()));
        System.out.println("Insert sort (in abstract class): " + Arrays.deepToString(tramRouteWithArray.nameOfStationSort()));

        System.out.println();
        TramRouteWithArraySorting tramRouteWithArraySorting = new TramRouteWithArraySorting(128, 15, stations);
        tramRouteWithArraySorting.addStation(new Station("Kiev", 73));
        System.out.println(tramRouteWithArraySorting);
        System.out.println("Comparable way: " + Arrays.deepToString(tramRouteWithArraySorting.nameOfStationSort()));
        System.out.println("Comparator way: " + Arrays.deepToString(tramRouteWithArraySorting.passengersSort()));

        System.out.println();

        TramRouteArrayList tramRouteArrayList = new TramRouteArrayList(129, 15, stations);
        tramRouteArrayList.addStation(new Station("Kiev", 73));
        System.out.print(tramRouteArrayList);
        System.out.println("Total number of passengers: " + tramRouteArrayList.getAllPassengers());
        System.out.println("The station with the least number of passengers: " + Arrays.deepToString(tramRouteArrayList.getStationsWithLeastNumberOfPassengers()));
        System.out.println("With the longest name: " + Arrays.deepToString(tramRouteArrayList.getStationWithTheLargestName()));
        System.out.println("Interface List way: " + Arrays.deepToString(tramRouteArrayList.passengersSort()));
        System.out.println("Сollections way: " + Arrays.deepToString(tramRouteArrayList.nameOfStationSort()));


        System.out.println();

        TramRouteSortedSet tramRouteSortedSet = new TramRouteSortedSet(130, 15, stations);
        tramRouteSortedSet.addStation(new Station("Kiev", 73));
        System.out.print(tramRouteSortedSet);
        System.out.println("Total number of passengers: " + tramRouteSortedSet.getAllPassengers());
        System.out.println("The station with the least number of passengers: " + Arrays.deepToString(tramRouteSortedSet.getStationsWithLeastNumberOfPassengers()));
        System.out.println("With the longest name: " + Arrays.deepToString(tramRouteSortedSet.getStationWithTheLargestName()));
        System.out.println("Sort by passengers: " + Arrays.deepToString(tramRouteSortedSet.passengersSort()));
        System.out.println("Sort by stations: " + Arrays.deepToString(tramRouteSortedSet.nameOfStationSort()));

        new TramRouteWithTextFile(203, 3, stations.clone()).test("source.txt", "stationSort.txt", "passengers.txt");
        new TramRouteWithDataFile(204, 5, stations.clone()).test("source1.dat", "stationSort1.dat", "passengers1.dat");
    }
}


