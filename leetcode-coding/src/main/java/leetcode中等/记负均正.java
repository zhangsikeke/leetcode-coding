
package leetcode中等;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 记负均正 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();

        while (scanner.hasNext()) {
            int num = Integer.parseInt(scanner.nextLine());
            String[] strs = scanner.nextLine().split(" ");
            int num1 = 0;
            int num2 = 0;
            int sum = 0;
            for (int i = 0; i < strs.length; i++) {
                int tmpNum = Integer.parseInt(strs[i]);
                if (tmpNum < 0) {
                    num1++;
                } else if(tmpNum>0) {
                    num2++;
                    sum += tmpNum;
                }
            }
           
            DecimalFormat format=new DecimalFormat("#.0");
            System.out.println(num1+" "+format.format(sum*1.0/num2));

        }
        scanner.close();
        

        // Scanner scanner = new Scanner(System.in);
        // List<Integer> list = new ArrayList<Integer>();
        //
        // while (scanner.hasNext()) {
        // String str = scanner.nextLine();
        // list.add(Integer.valueOf(str));
        //
        // }
        // scanner.close();
        // int num1 = 0;
        // int num2 = 0;
        // int sum = 0;
        // for (Integer i : list) {
        // if(i<0) {
        // num1++;
        // }
        // else {
        // num2++;
        // sum+=i;
        // }
        // }
        // System.out.println(num1);
        // System.out.printf("%.1f",sum*1.0/num2);

    }

}