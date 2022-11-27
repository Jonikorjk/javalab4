package task1;

public class Main {

    public static void main(String args[]) {
        Station[] stations = {
                new Station("Porkovsk", 15),
                new Station("Dobropolie", 2),
                new Station("Kramatorsk", 37),
                new Station("Slavyansk", 33),
                new Station("Izum", 15),
                new Station("Chygyev", 2),
                new Station("Kharkov", 74)
        };
        AbstractTramRoute.test(stations.clone());
        new TramRouteWithTextFile(203, 3, stations.clone()).test("source.txt", "stationSort.txt", "passengers.txt");
        new TramRouteWithDataFile(203, 5, stations.clone()).test("source1.dat", "stationSort1.dat", "passengers1.dat");
    }
}
