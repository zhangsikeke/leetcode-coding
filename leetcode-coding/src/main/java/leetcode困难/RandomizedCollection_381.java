 package leetcode困难;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedCollection_381 {
    // 保存每个元素的索引
    private Map<Integer, List<Integer>> indexMap;
     private List<Integer> dataList;

     /** Initialize your data structure here. */
     public RandomizedCollection_381() {
         indexMap = new HashMap<>();
         dataList = new ArrayList<>();
     }
     
     /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
     public boolean insert(int val) {
         dataList.add(val);
         List<Integer> indexList = indexMap.getOrDefault(val,new ArrayList<>());
         boolean res = true;
         if(indexList.isEmpty()) {
             res =false;
         }
         indexList.add(dataList.size()-1);
         return res;
     }
     
     /** Removes a value from the collection. Returns true if the collection contained the specified element. */
     public boolean remove(int val) {
         if(!indexMap.containsKey(val)){
             return false;
         }
         List<Integer> indexList = indexMap.get(val);
         if(indexList.isEmpty()){
             return false;
         }
         int index = indexList.remove(indexList.size()-1);
         dataList.remove(index);
         return true;
     }
     
     /** Get a random element from the collection. */
     public int getRandom() {
         return dataList.get((int)(Math.random()*dataList.size()));
     }
}
