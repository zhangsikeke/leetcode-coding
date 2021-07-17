
package leetcode困难;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class 简单错误记录 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            String name = strs[0];
            String errIndex = strs[1];
            name = name.substring(name.lastIndexOf("\\") + 1);
            if (name.length() > 16)
                name = name.substring(name.length() - 16);

            String key = name + " " + errIndex;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        scanner.close();
        int count = 0;
        int total = map.size();
        for (String tmpK : map.keySet()) {
            count++;
            if (count > total - 8) {
                System.out.println(tmpK + " " + map.get(tmpK));
            }
        }
    }

}