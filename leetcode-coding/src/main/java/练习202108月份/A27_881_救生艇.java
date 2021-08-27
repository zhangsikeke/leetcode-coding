package 练习202108月份;

import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: keke
 * @date: 2021/8/27 23:22
 */
public class A27_881_救生艇 {
    public static void main(String[] args) {
        A27_881_救生艇 test = new A27_881_救生艇();
        int res = test.numRescueBoats(new int[]{5, 1, 4, 2}, 6);
        System.out.println(res);
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            count++;
        }
        return count;
    }
}