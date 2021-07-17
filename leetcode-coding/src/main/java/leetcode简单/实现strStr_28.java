package leetcode简单;

public class 实现strStr_28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() <= haystack.length() && haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        // return haystack.indexOf(needle);
        return -1;
    }
}
