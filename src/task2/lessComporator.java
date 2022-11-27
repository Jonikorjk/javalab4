package task2;

import java.util.Comparator;

public class lessComporator implements Comparator<Integer> {

    static private Integer sumOfDigitsOfNumber(Integer a) {
        Integer sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(sumOfDigitsOfNumber(o1), sumOfDigitsOfNumber(o2));
    }
}
