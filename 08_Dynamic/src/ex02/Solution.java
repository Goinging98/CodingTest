package ex02;

public class Solution {
	public int solution(int[][] triangle) {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				int lParents = j - 1 < 0 ? 0 : j - 1;
				int rParents = j + 1 >= triangle[i-1].length ? triangle[i-1].length-1 : j;
				triangle[i][j] += Integer.max(triangle[i-1][lParents], triangle[i-1][rParents]);
				max = Integer.max(triangle[i][j], max);
			}
		}
		return max;
	}

}