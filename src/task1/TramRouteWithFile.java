package task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

public abstract class TramRouteWithFile extends TramRouteArrayList {
    public TramRouteWithFile(int num, int averageInterval, Station[] stations) {
        super(num, averageInterval, stations);
    }
    public abstract void readFromFile(String fileName) throws Exception;

    public abstract void writeToFile(String fileName, Station[] stations) throws Exception;

    public void test(String from, String toByStationSort, String toByPassengersSort) {
        try {
            writeToFile(from, null);
        }
        catch (IOException e) {
            System.err.println("Write failed");
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("Wrong format");
        }
        try {
            Station[] stations = null;
            readFromFile(from);
            stations = nameOfStationSort();
            writeToFile(toByStationSort, stations);
            stations = passengersSort();
            writeToFile(toByPassengersSort, stations);
        }
        catch (FileNotFoundException e) {
            System.err.println("Read failed");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.err.println("Write failed");
            e.printStackTrace();
        }
        catch (InputMismatchException e) {
            e.printStackTrace();
            System.err.println("Wrong format");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("Wrong format");
        }
    }
}
