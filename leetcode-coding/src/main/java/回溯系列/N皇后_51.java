package 回溯系列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N皇后_51 {
    public static void main(String[] args) {
        List<List<String>> list = solveNQueens(4);
        System.out.println(list.size());
       
      
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<char[]> list = new ArrayList<>();
        char[] chs = new char[n];
        for (int i = 0; i < n; i++) {
            chs[i] = '.';
        }
        for (int i = 0; i < n; i++) {
            list.add(Arrays.copyOf(chs,n));
        }
        help(res,list,0);
        return res;
    }

    public static void help(List<List<String>> res, List<char[]> list, int row) {
        if (row == list.size()) {
            List<String> tmpList = new ArrayList<>();
            for (char[] chs : list) {
                tmpList.add(new String(chs));
            }
            res.add(tmpList);
            //show(list);
            //System.out.println("-----------");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!isValid(list, row, i)) {
                continue;
            }
            list.get(row)[i] = 'Q';
            show(list);
            System.out.println(">>>>>>>>>");
            // 下一行继续放皇后
            help(res, list, row + 1);
            System.out.println("-----------");
            // 往上回溯
            list.get(row)[i] = '.';
            show(list);
            System.out.println("===============");
        }
    }

    private static boolean isValid(List<char[]> list, int row, int col) {
        // 判断列是否攻击
        for (int i = 0; i < list.size(); i++)
            if (list.get(i)[col] == 'Q')
                return false;

        // 判断左上是否攻击
        for (int i = row-1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (list.get(i)[j] == 'Q')
                return false;

        // 判断右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < list.size(); i--, j++)
            if (list.get(i)[j] == 'Q')
                return false;
        return true;
    }
    
    public static void show(List<char[]> list) {
        for (char[] cs : list) {
            for (char cs2 : cs) {
                System.out.print(cs2+" ");
            }
            System.out.println();
        }
    }
}
