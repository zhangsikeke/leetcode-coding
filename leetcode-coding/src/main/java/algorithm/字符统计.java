package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 如果统计的个数相同，则按照ASCII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。<br>
 * 
 * 实现以下接口：<br>
 * 输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）<br>
 * 按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出<br>
 * 清空目前的统计结果，重新统计<br>
 * 调用者会保证：<br>
 * 输入的字符串以‘\0’结尾。<br>
 * 
 * @author keke
 * @date 2020/08/31
 */
public class 字符统计 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        字符统计 m = new 字符统计();
        // while (scanner.hasNext()) {
        // String str = scanner.nextLine();
        // m.count(str);
        //
        // }

        // 本地调试count1和count2 输出结果都一致，但牛客网上却不一致，初步怀疑是不是openJDK排序差异
        m.count2("zyxvtsrqpomlkjigedca9876543210whb");

    }

    public void count1(String str) {

        char[] cs = str.toCharArray();
        int len = cs.length;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int asc = (int)cs[i];
            if (asc < Byte.MIN_VALUE || asc > Byte.MAX_VALUE)
                continue;
            if (map.containsKey(cs[i])) {
                map.put(cs[i], 2);
            } else {
                map.put(cs[i], 1);
            }
        }
        Set<Character> set = map.keySet();
        List<Character> list = new ArrayList<Character>();
        for (char c : set) {
            list.add(c);

        }
        list.sort(new Comparator<Character>() {

            @Override
            public int compare(Character o1, Character o2) {
                if (map.get(o1) == map.get(o2)) {
                    return (int)o1 - (int)o2;
                }
                return map.get(o2) - map.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

    public void count2(String str) {
        char[] chars = str.toCharArray();
        int[] charNum = new int[150];
        for (int i = 0; i < chars.length; i++) {
            charNum[chars[i]]++;
        }
        int max = 0;
        for (int i = 0; i < charNum.length; i++) {
            if (charNum[i] > max)
                max = charNum[i];
        }
        StringBuilder sb = new StringBuilder();
        while (max != 0) {
            for (int i = 0; i < charNum.length; i++) {
                if (charNum[i] == max) {
                    sb.append((char)i);
                }
            }
            max--;
        }
        System.out.println(sb.toString());
    }

}
