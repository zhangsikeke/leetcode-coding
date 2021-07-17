package algorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 查找偶数最接近的差值最小素数 {

    Set<Integer> setPrimeNum = new HashSet<>();

    public static void main(String[] args) {

        查找偶数最接近的差值最小素数 m = new 查找偶数最接近的差值最小素数();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = Integer.valueOf(scanner.nextLine());
            m.search(num);
        }

    }

    public void search(int sum) {
        Set<Integer> setData = new HashSet<>();
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            int x = sum - i;
            if (!setData.contains(i)) {
                setData.add(i);
            }
            if (setData.contains(x)) {
                if (isPrimeNum(i) && isPrimeNum(x)) {
                    if (Math.abs(i - x) < diff) {
                        diff = Math.abs(i - x);
                        if (i < x) {
                            System.out.println(i);
                            System.out.println(x);
                        } else {
                            System.out.println(x);
                            System.out.println(i);
                        }

                    }

                }

            } else {
                setData.add(x);
            }

        }
    }

    /**
     * 判断是素数
     * 
     * @param num
     * @return
     */
    public boolean isPrimeNum(int num) {
        if (setPrimeNum.contains(num)) {
            return true;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        if (!setPrimeNum.contains(num)) {
            setPrimeNum.add(num);
        }
        return true;
    };
}
