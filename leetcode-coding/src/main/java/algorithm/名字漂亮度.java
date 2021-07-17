package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 名字漂亮度 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(1);
        list.add(2);
        
        int[] num = list.stream().mapToInt(Integer::intValue).toArray();
        
        for (int i : num) {
            System.out.print(i+" ");
        }
//        Scanner scanner = new Scanner(System.in);
//        名字漂亮度 m = new 名字漂亮度();
//        while (scanner.hasNext()) {
//            int num = scanner.nextInt();
//            scanner.nextLine();
//            for (int i = 0; i < num; i++) {
//                String str = scanner.nextLine();
//                System.out.println(m.search(str));
//
//            }
//        }

    }

    public int search(String str) {
        str = str.toLowerCase();
        char[] cs = str.toCharArray();
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            if (map.containsKey(cs[i])) {
                map.put(cs[i], map.get(cs[i]) + 1);
            } else {
                map.put(cs[i], 1);
            }
        }
        Collection<Integer> tmpList = map.values();

        int[] nums = new int[tmpList.size()];
        int index = 0;
        for (Integer i : tmpList) {
            nums[index] = i;
            index++;
        }
        Arrays.sort(nums);

        int max = 26;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i] * max;
            max--;
        }
        return sum;
    }

}
