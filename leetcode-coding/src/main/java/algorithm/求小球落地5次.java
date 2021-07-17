package algorithm;

import java.util.Scanner;

public class 求小球落地5次 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double h = scanner.nextDouble();
            get(h, 0, 0);

        }
    }

    public static double get(double heigh, int index, double total) {
        if (index == 5) {
            System.out.println(total - heigh);
            System.out.println(heigh);

            return heigh;
        }
        index++;
        total += heigh + heigh / 2;
        return get(heigh / 2, index++, total);
    }

}
