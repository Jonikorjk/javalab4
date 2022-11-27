package task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TramRouteSortedSet extends AbstractTramRoute {

    SortedSet<Station> stations = new TreeSet<>(Comparator.comparing(Station::getPassengers).reversed());

    public TramRouteSortedSet(int num, int averageInterval, Station[] stations) {
        super(num, averageInterval);
        this.stations.addAll(Arrays.asList(stations));
    }

    @Override
    public Station[] nameOfStationSort() {
        var stations1 = new TreeSet<Station>(Comparator.comparing((Station::getNameOfStation)));
        stations1.addAll(stations);
        return  stations1.toArray(Station[]::new);
    }

    @Override
    public Station[] passengersSort() {
        var stations1 = new TreeSet<Station>(stations);
        return stations1.toArray(Station[]::new);
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    @Override
    public Station[] getTramRoute() {
        return stations.toArray(Station[]::new);
    }

    @Override
    public void setTramRouteWithArray(Station[] t) {
        var stations1 = new TreeSet<Station>(Comparator.comparing(Station::getPassengers).reversed());
        stations1.addAll(Arrays.asList(t));
        stations = stations1;
    }
}
