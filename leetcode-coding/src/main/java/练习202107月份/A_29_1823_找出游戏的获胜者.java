package 练习202107月份;

import java.sql.Time;

public class A_29_1823_找出游戏的获胜者 {
	public static void main(String[] args) {
		int res = findTheWinner(5, 3);
		System.out.println(res);
	}

	/**
	 * 模拟方式实现
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static int findTheWinner(int n, int k) {
		int start = 1;
		int index = -1;
		int totalTime = 0;
		int totalRemove = 0;
		int[] deleted = new int[n + 1];
		while (totalRemove < n - 1) {
			if (start > n) {
				start = 1;
			}
			if (deleted[start] == 0) {
				index = start;
				totalTime++;
				if (totalTime == k) {
					deleted[index] = 1;
					totalRemove += 1;
					totalTime = 0;
					System.out.println("remove:" + index + ",next:" + (index + 1));
				}
			}
			start++;
		}
		for (int i = 1; i < deleted.length; i++) {
			if (deleted[i] == 0) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * 递归方式实现
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static int findTheWinner1(int n, int k) {
		int[] time = new int[2];
		int[] visited = new int[n + 1];
		dfs(1, n, k, time, visited);
		for (int i = 1; i < visited.length; i++) {
			if (visited[i] == 0) {
				return i;
			}
		}
		return 0;
	}

	private static void dfs(int pos, int n, int k, int[] time, int[] deleted) {
		if (time[1] == n - 1) {
			return;
		}
		if (pos > n) {
			pos = 1;
		}
		if (deleted[pos] == 1) {
			dfs(pos + 1, n, k, time, deleted);
		} else {
			time[0] += 1;
			System.out.println(pos + ",i:+1," + time[0]);
			if (time[0] == k) {
				deleted[pos] = 1;
				time[1] += 1;
				time[0] = 0;
				System.out.println("remove:" + pos + ",next:" + (pos + 1) + "," + time[1]);
			}
			dfs(pos + 1, n, k, time, deleted);
		}
	}
}
