//완전탐색 > 최소직사각형
package ex01;

import java.util.Arrays;

// sizes	                                        result
// {{60, 50}, {30, 70}, {60, 30}, {80, 40}}	    	4000
// {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}	120
// {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}	133

public class Solution {
	
	public int max(int a, int b){
		if(a > b) {
			return a;
		}else {
			return b;
		}
	}
	
	public int solution(int[][] sizes) {
		int w = 0;
		int h = 0;
		for(int[] size : sizes) {
//			if(w > h) { // swap!!
//				int temp = w;
//				w = h;
//				h = temp;
//			}
//			w = w > size[0] ? w:size[0];
//			h = h > size[1] ? h:size[1];
			
			Arrays.sort(size);
			w = Integer.max(w, size[0]);
			h = Integer.max(h, size[1]);
		}
		
		return w * h;
	}

	public static void main(String[] args) {
		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 }};
		int result = new Solution().solution(sizes);
		System.out.println(result);
	}
}