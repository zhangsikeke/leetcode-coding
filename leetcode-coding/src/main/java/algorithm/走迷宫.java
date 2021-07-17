package algorithm;

/**
 * 矩阵中1表示有障碍物，0表示可通行，求从左上角出发到右下角的路径
 * 
 * @author keke
 * @date 2020/08/30
 */
public class 走迷宫 {

    public static void main(String[] args) {

        走迷宫 m = new 走迷宫();


        int[][] nums1 = new int[][] {
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 1, 0}, 
            {0, 0, 1, 0, 1, 1, 0, 1},
            {0, 1, 1, 1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 1, 1, 1, 1, 0, 0, 1},
            {1, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 0}
        };
         int[][] nums2 = new int[][] {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0}, 
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0}, 
            {0, 0, 0, 1, 0}
         };
         
        int[][] nums = nums1;
        m.search(nums, 0, 0,nums.length, nums[0].length);

    }

    /**
     * 走过的地方设置为8
     * @param nums
     * @param x
     * @param y
     * @param r
     * @param c
     */
    public void search(int[][] nums, int x, int y, int r, int c) {
        if (x == r - 1 && y == c - 1) {
            nums[x][y] = 8;
            show(nums);
            //回溯恢复路径
            nums[x][y] = 0;
            return;
        }

        // 往右走
        if (canGo(nums, x, y, x, y + 1, r, c)) {
            nums[x][y] = 8;
            search(nums, x, y + 1, r, c);
            nums[x][y] = 0;
        }
        // 往左走
        if (canGo(nums, x, y, x, y - 1, r, c)) {
            nums[x][y] = 8;
            search(nums, x, y - 1, r, c);
            //回溯恢复路径
            nums[x][y] = 0;
        }

        // 往下走
        if (canGo(nums, x, y, x + 1, y, r, c)) {
            nums[x][y] = 8;
            search(nums, x + 1, y, r, c);
            //回溯恢复路径
            nums[x][y] = 0;
        }
        // 往上走
        if (canGo(nums, x, y, x - 1, y, r, c)) {
            nums[x][y] = 8;
            search(nums, x - 1, y, r, c);
            //回溯恢复路径
            nums[x][y] = 0;
        }
    }

    public void show(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(nums[i][j] == 8 ? ". " : nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }

    /**
     * 从x,y是否可以走到tx，ty 
     * @param nums
     * @param x
     * @param y
     * @param tx
     * @param ty
     * @param r
     * @param c
     * @return
     */
    boolean canGo(int[][] nums, int x, int y, int tx, int ty, int r, int c) {
        // 超出边界
        if (tx < 0 || ty < 0 || tx >= r || ty >= c) {
            return false;
        }
        // 墙
        if (nums[tx][ty] == 1) {
            return false;
        }
        // 走过的路不能再走，否则会会横着来回走
        if (nums[tx][ty] == 8) {
            return false;
        }
        return true;
    }

}
