package class089;

// 灌溉花园的最少水龙头数目
// 在x轴上有一个一维的花园，花园长度为n，从点0开始，到点n结束
// 花园里总共有 n + 1 个水龙头，分别位于[0, 1, ... n]
// 给你一个整数n和一个长度为n+1的整数数组ranges
// 其中ranges[i]表示
// 如果打开点i处的水龙头，可以灌溉的区域为[i-ranges[i], i+ranges[i]]
// 请你返回可以灌溉整个花园的最少水龙头数目
// 如果花园始终存在无法灌溉到的地方请你返回-1
// 测试链接 : https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/
public class Code07_MinimumTaps {

	public static int minTaps(int n, int[] ranges) {
		int[] right = new int[n + 1];
		for (int i = 0, start; i <= n; ++i) {
			start = Math.max(0, i - ranges[i]);
			right[start] = Math.max(right[start], i + ranges[i]);
		}
		int cur = 0, next = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			next = Math.max(next, right[i]);
			if (i == cur) {
				if (next > i) {
					cur = next;
					ans++;
				} else {
					return -1;
				}
			}
		}
		return ans;
	}

}