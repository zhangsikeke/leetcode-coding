package leetcode困难;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 未实现
 * 
 * @author keke
 * @date 2020/08/31
 */
public class 素数伴侣 {

    Set<Integer> setPrimeNum = new HashSet<>();

    public static void main(String[] args) {

        素数伴侣 m = new 素数伴侣();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = Integer.valueOf(scanner.nextLine());
            m.search(num);
        }

    }

    public void search(int sum) {

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
