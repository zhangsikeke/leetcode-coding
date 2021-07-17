package leetcode中等;

import java.util.List;

public class 单词拆分_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i = 0;i<wordDict.size();i++) {
            if(wordBreak(s,wordDict,i)) {
                return true;
            }
        }
        return false;
     }

    public boolean wordBreak(String s, List<String> wordDict, int pos) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = pos; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            int start = sb.indexOf(word);
            while (start != -1) {
                sb.delete(start, start + word.length());
                start = sb.indexOf(word);
            }
        }
        return !wordDict.isEmpty() && sb.length() == 0;
    }
}
