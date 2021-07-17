package algorithm;

import java.util.Objects;
import java.util.Scanner;

public class 扑克牌 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        扑克牌 m = new 扑克牌();
//        while (scanner.hasNext()) {
//            String str = scanner.nextLine();
//            m.search(str);
//
//        }
        m.search("A-10");
    }

    public void search(String str) {
        String[] strs = str.split("-");
        String str1 = strs[0];
        String str2 = strs[1];
        String[] s1s = str1.split(" ");
        String[] s2s = str2.split(" ");
        changeValue(s1s);
        changeValue(s2s);
        
        int s1Len = s1s.length;
        int s2Len = s2s.length;
        String joker = "joker JOKER";
        // 王炸
        if (Objects.equals(joker, str1) || Objects.equals(joker, str2)) {
            System.out.println(joker);
            return;
        }
        // 炸弹
        if (s1Len == 4 || s2Len == 4) {
            System.out.println(s1Len == 4 ? str1 : str2);
            return;
        }
        // 不匹配
        if (s1Len != s2Len) {
            System.out.println("ERROR");
            return;
        }
        String res = Integer.valueOf(s1s[0]) - Integer.valueOf(s2s[0]) > 0 ? str1 : str2;
        System.out.println(res);
    }
    
    public void changeValue( String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            
            if(strs[i].equals("J"))
                strs[i] = "11";
            else if(strs[i].equals("Q"))
                strs[i] = "12";
            else if(strs[i].equals("K"))
                strs[i] = "13";
            else if(strs[i].equals("A"))
                strs[i] = "14";
            else if(strs[i].equals("2"))
                strs[i] = "15";
        }
    }
    

}
