 package 数组系列;

 public class 原地删除_27_easy {
     public int removeElement(int[] nums, int val) {
         int n = nums.length;
         int i = 0;
         while(i<n) {
             if(nums[i] == val) {
                 nums[i] = nums[n-1];
                 n--;
             }else {
                 i++;
             }
         }
         return n;
     }
}
