package ex02;

import java.util.HashSet;
import java.util.Set;

//
//nums				result		종류수		N/2    
//[3,1,2,3]		2 			3			2      답 3 > 2 = 2 
//[3,3,3,2,2,4]	3			3			3      답 3 == 3 = 3
//[3,3,3,2,2,2]	2			2			3      답 2 > 3 = 2


class Solution {
	public int solution(int[] nums) {
		// 중복을 제거하여 종류수를 구하는 과정
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		// 종류수 N / 2
		if (set.size() < nums.length / 2) {
			return set.size();
		} else {
			return nums.length / 2;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 3, 3, 3, 2, 2, 2 };
		int result = new Solution().solution(nums);
		System.out.println(result);

	}
}
