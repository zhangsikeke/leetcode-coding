package algorithm;

import java.util.Scanner;

public class 输出7有关的数 {
    public static void main(String[] args) {

        输出7有关的数 m = new 输出7有关的数();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            m.search(num);
        }

    }

    public void search(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if(i%7 ==0 || (i+"").contains("7")) {
                sum++;
            }
        }
        System.out.println(sum);
    }

}
