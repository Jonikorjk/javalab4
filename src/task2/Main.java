package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;



public class Main {

    static private Integer sumOfDigitsOfNumber(Integer a) {
        Integer sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    static void printToFile(String fileName, ArrayList arrayList) {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            while (!arrayList.isEmpty()) {
                pw.print(arrayList.remove(0));
                pw.print(" ");
            }
        }
        catch (FileNotFoundException o) {
            o.getStackTrace();
        }
    }

    static void readWrite() {
        var list = new ArrayList<Integer>();
        try (Scanner scanner = new Scanner(new FileReader("data.txt"))) {
            while (scanner.hasNext()) {
                list.add(scanner.nextInt());
            }
        }
        catch (FileNotFoundException a) {
            System.out.println(a.getStackTrace());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(sumOfDigitsOfNumber(o2), sumOfDigitsOfNumber(o1));
            }
        });
        printToFile("result1.txt", (ArrayList) list.clone());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(sumOfDigitsOfNumber(o1), sumOfDigitsOfNumber(o2));
            }
        });
        printToFile("result2.txt", list);
    }

    public static void main(String[] args) {
        readWrite();
    }
}
