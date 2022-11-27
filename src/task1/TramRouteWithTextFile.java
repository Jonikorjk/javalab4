package task1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class TramRouteWithTextFile extends TramRouteWithFile {
    public TramRouteWithTextFile(int num, int averageInterval, Station[] stations) {
        super(num, averageInterval, stations);
    }

    @Override
    public void readFromFile(String fileName) throws Exception {
        ArrayList<Station> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            setNum(scanner.nextInt());
            setAverageInterval(scanner.nextInt());
            while (scanner.hasNext()) {
                String name = scanner.next();
                int passengers = scanner.nextInt();
                list.add(new Station(name, passengers));
            }
            setTramRouteWithArray(list.toArray(Station[]::new));
        }
    }

    @Override
    public void writeToFile(String fileName, Station[] stations) throws Exception {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.println(getNum());
            out.println(getAllPassengers());
            if (stations == null) {
                for (var st : getTramRoute()) {
                    out.print(st.getNameOfStation() + " " + st.getPassengers() + " ");
                }
            }
            else {
                for (var st : stations) {
                    out.print(st.getNameOfStation() + " " + st.getPassengers() + " ");
                }
            }
        }
    }
}
