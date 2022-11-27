package task1;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TramRouteWithDataFile extends TramRouteWithFile {
    public TramRouteWithDataFile(int num, int averageInterval, Station[] stations) {
        super(num, averageInterval, stations);
    }

    @Override
    public void readFromFile(String fileName) throws Exception {
        try (DataInputStream in = new DataInputStream(new FileInputStream(fileName))) {
            ArrayList<Station> list = new ArrayList<>();
            setNum(in.readInt());
            setAverageInterval(in.readInt());
            for (int i = 0; i < getTramRoute().length; i++) {
                String name = in.readUTF();
                int passengers = in.readInt();
                list.add(new Station(name, passengers));
            }
            setTramRouteWithArray(list.toArray(Station[]::new));
        }
    }

    @Override
    public void writeToFile(String fileName, Station[] stations) throws Exception {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            out.writeInt(getNum());
            out.writeInt(getAverageInterval());
            if (stations != null) {
                for (var station : stations) {
                    out.writeUTF(station.getNameOfStation() + " ");
                    out.writeInt(station.getPassengers());
                }

            }
            else {
                for (var station : getTramRoute()) {
                    out.writeUTF(station.getNameOfStation() + " ");
                    out.writeInt(station.getPassengers());
                }
            }
        }
    }
}
