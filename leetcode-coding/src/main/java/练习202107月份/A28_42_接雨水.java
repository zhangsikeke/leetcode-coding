package 练习202107月份;

public class A28_42_接雨水 {
	public int trap(int[] height) {
		if (height.length == 0) {
			return 0;
		}
		int max = height[0];
		int maxIndex = 0;
		for (int i = 0; i < height.length; i++) {
			if (max < height[i]) {
				max = height[i];
				maxIndex = i;
			}
		}
		int ans = 0;
		int start = height[0];
		for (int i = 0; i < maxIndex; i++) {
			if (start < height[i]) {
				start = height[i];
				continue;
			}
			ans += start - height[i];
		}
		start = height[height.length - 1];
		for (int i = height.length - 1; i > maxIndex; i--) {
			if (start < height[i]) {
				start = height[i];
				continue;
			}
			ans += start - height[i];
		}
		return ans;
	}
}
