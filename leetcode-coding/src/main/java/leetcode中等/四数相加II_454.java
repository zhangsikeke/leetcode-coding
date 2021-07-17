 package leetcode中等;

import java.util.HashMap;
import java.util.Map;

public class 四数相加II_454 {
     public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
         Map<Integer,Integer> abMap = new HashMap<>();
         for(int a: A){
             for(int b: B){
                 int key = a+b;
                 abMap.put(key,abMap.getOrDefault(key,0)+1);
             }
         }
         int count = 0;
         for(int c: C){
             for(int d: D){
                 if(abMap.containsKey(-c-d)){
                     count+=abMap.get(-c-d);
                 }
             }
         }
         return count;
     }
}
