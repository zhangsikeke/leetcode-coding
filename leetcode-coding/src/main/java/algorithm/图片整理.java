package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 图片整理 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] cs = scanner.nextLine().toCharArray();
            List<Character> list = new ArrayList<Character>();
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] >= 'a' && cs[i] <= 'z' || cs[i] >= 'A' && cs[i] <= 'Z' || cs[i] >= '0' && cs[i] <= '9')
                    list.add(cs[i]);
            }
            Collections.sort(list, new Comparator<Character>() {

                @Override
                public int compare(Character o1, Character o2) {
                    return (int)o1.charValue() - (int)o2.charValue();
                }
            });

            StringBuilder sb = new StringBuilder();
            for (Character character : list) {
                sb.append(character);
            }
            System.out.println(sb.toString());

        }
    }

}
