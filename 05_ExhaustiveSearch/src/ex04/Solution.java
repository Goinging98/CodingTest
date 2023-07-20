// 완전탐색 > 카펫
package ex04;

import java.util.Arrays;

// brown	yellow	return
// 10		2	    [4, 3]
// 8		1	    [3, 3]
// 24		24	    [8, 6]
// 너비를 구하고 넓이가 나올수 있는 조합을 모두 찾아서 실제 brown, yellow 갯수와 비교

public class Solution {
	public int[] solution(int brown, int yellow) {
		int area = brown + yellow;
		for(int w = 3; w < area/2; w++) {
			int h = area / w;
			if(w * h != area) {
				continue;
			}
			int brownSize = w * 2 + h * 2 - 4; //  테두리의 길이에서 - 4칸
		    int yellowSize = area - brownSize;
		    if(brown == brownSize && yellow == yellowSize) {
		    	return new int[] {h,w};
		    }
		}
		return new int[] {0,0};
	}
	
	public static void main(String[] args) {
		int[] result = new Solution().solution(10, 2);
		System.out.println(Arrays.toString(result));
	}
}