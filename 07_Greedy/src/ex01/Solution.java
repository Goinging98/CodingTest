// 탐욕법(Greedy) > 체육복

package ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// n		lost	reserve			return
// 5		[2, 4]	[1, 3, 5]		5
// 5		[2, 4]	[3]				4
// 3		[3]		[1]				2

// 문제풀이 방법
// n		lost	reserve			return
// 5		[2, 4]	[1, 3, 5]		5
// 전체 사람  [1, 2, 3, 4, 5]
// lost     [   2,    4,  ]
// reserve  [1,    3,    5]
// 빌린 사람  [   1     3   ] = 5

// 문제풀이 방법2 - 자기껄 도난 당했을때의 풀이
// -> 이때는 자기자신껄 들고 있으면 해결이 된다.
// n		lost		reserve			return
// 5		[2, 3, 4]	[1, 3, 5]		5
// 전체 사람  [1, 2, 3, 4, 5]
// lost     [   2, 3, 4,  ]
// reserve  [1,    3,    5]
// 빌린 사람  [   1  3, 5   ] = 5

public class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
//		List<Integer> list = new ArrayList<>(); list로는 풀이가 안되는 문제! remove()를 index로 지울지 object로 지울지 구별이 안되서!
		Set<Integer> lostSet = new TreeSet<>(); // 순서가 보장, 속도 빠르다.
		Set<Integer> reserveSet = new TreeSet<>();
		
		
		for(int i = 0; i < lost.length; i++) {
			lostSet.add(lost[i]);
		}
		for(int i = 0; i < reserve.length; i++) {
			// 본인껄 잊어버린 케이스를 제거!
			if(lostSet.contains(reserve[i])) {
				lostSet.remove(reserve[i]);
			}else {
				reserveSet.add(reserve[i]);
			}
		}
		
//		System.out.println(lostSet);
//		System.out.println(reserveSet);
		
		int answer = n - lostSet.size(); // 안빌리고도 체육이 수업이 가능한 사람
		
		for(int lostNum : lostSet) {
			// 자기 자신껀 자기가 입는다! -> 여기에 있으면 안된다! 이유: 앞사람이 가져갈수 있어서...
//			if(reserveSet.contains(lostNum)) {
//				reserveSet.remove(lostNum - 1);
//				answer++;
//			}
			// 체격이 작은 사람껄 먼저 밀린다.
			if(reserveSet.contains(lostNum - 1)) {
				reserveSet.remove(lostNum - 1);
				answer++;
			// 체격이 큰사람껄 빌린다.
			} else if(reserveSet.contains(lostNum + 1)) {
				reserveSet.remove(lostNum + 1);
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 5; 
		int[] lost = {2, 3, 4};
		int[] reserve = {1, 3, 5};
		int result = new Solution().solution(n, lost, reserve);
		System.out.println(result); // 5
	}
}
