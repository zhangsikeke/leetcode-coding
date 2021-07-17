package leetcode简单;

public class 外观数列_38 {
    public static String countAndSay(int n) {
        String preString = "1";
        String curString = preString;
        StringBuilder sb = new StringBuilder();
        char leftChar = '0';
        for (int i = 2; i <= n; i++) {
            int left = 0;
            int right = 0;
            int count = 0;
            leftChar = preString.charAt(left);
            while (right < preString.length()) {
                char rightChar = preString.charAt(right);
                if (rightChar == leftChar) {
                    right++;
                    count++;
                    continue;
                } else {
                    sb.append(String.valueOf(count) + leftChar);
                    left = right;
                    leftChar = preString.charAt(left);
                    count = 0;
                }
            }
            if (count > 0) {
                curString = sb.toString() + count + leftChar;
                sb.delete(0, sb.length());
                count = 0;
            }
            System.out.println(i + "," + curString + ",pre=" + preString);
            preString = curString;
        }
        return curString;
    }

    public static void main(String[] args) {
        System.out.println("1");
        System.out.println(countAndSay(5));
         
        for (int i = 0; i < 127; i++) {
            System.out.println(Integer.toHexString(i)+",["+(char)i+"]");
        }
    }
}
