package task1;

import java.util.*;

public class TramRouteArrayList extends AbstractTramRoute {
    private List<Station> stations = new ArrayList<>();

    public TramRouteArrayList(int num, int averageInterval, Station[] stations) {
        super(num, averageInterval);
        this.stations.addAll(Arrays.asList(stations.clone()));
    }

    public void addStation(Station station) {
        if (stations.contains(station)) { return; }
        stations.add(station);
    }

    @Override
    public Station[] passengersSort() {
        stations.sort(Comparator.comparing(Station::getPassengers).reversed());
        return stations.toArray(Station[]::new);
    }

    @Override
    public Station[] nameOfStationSort() {
        Collections.sort(stations);
        return stations.toArray(Station[]::new);
    }

    @Override
    public Station[] getTramRoute() {
        return stations.toArray(Station[]::new);
    }

    @Override
    public void setTramRouteWithArray(Station[] t) {
        stations.clear();
        stations.addAll(Arrays.asList(t));
    }
}
