// 스택/큐 > 같은 숫자는 싫어
package ex01;

//	arr					answer
//	[1,1,3,3,0,1,1]		[1,3,0,1]
//	[4,4,4,3,3]			[4,3]

// 손으로 풀어보기, 전략 = 이전값과 현재값을 비교해서 다르면 넣고, 같으면 패스
// 이전값 : 1,  초기값은 -1이다.
// [1,1,3,3,0,1,1]     [1, 3, 0, 1]
// 이전값 : 3
// [4,4,4,3,3]     [4, 3]

import java.util.*;

public class Solution {

	// 강사가 가장 먼저 떠오른 풀이
	public int[] solution2(int[] arr) {
		int[] answer = new int[arr.length];
		int count = 0; // 실제 답의 크기슷 세는 count
		int prev = -1; // 이전값을 기억하는 공간, 초기값은 올수 없는 -1로 지정한다.

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != prev) {
				answer[count++] = arr[i]; // 값 넣기
				prev = arr[i]; // 이전 값 업데이트
			} else {
				continue; // 같은 경우 skip!
			}
		}

		return Arrays.copyOf(answer, count);
	}

	// 문제의 의도대로 풀어본 문제
	// 1,1,3,3,0,1,1, -1
	//  pop-1 / 1,3,3,0,1,1, -1
	//  pop-1 / 3,3,0,1,1, -1, 1
	//  pop-1 / 3,3,0,1,1, -1, 1, 3
	public int[] solution(int[] arr) {
//		Deque<Integer> deque = new LinkedList()<>(); // LinkedList는 탐색은 O(n), 쓰기 삭제 O(1)
		Deque<Integer> deque = new ArrayDeque<>(); // ArrayDeque로 구성된 큐, 탐색 O(1), 쓰기 삭제, O(n)
		for (int i = 0; i < arr.length; i++) {
			deque.add(arr[i]);
		}
		deque.add(-1); // 종료점
		
		while(true) {
			int first = deque.pop(); // pop : 앞에 값을 꺼내오는 함수, get + delete
			if(first == -1) {
				break;
			}
			int second = deque.getFirst(); // 값만 가져오는 함수, delete를 하지 않음
			if(first != second) {
				deque.add(first);
			}
//			System.out.println(deque);
		}
		int[] answer = new int[deque.size()];
		System.out.println(deque);
		int count = 0;
		while(deque.isEmpty() == false) {
			answer[count++] = deque.pop();
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };
		int[] result = new Solution().solution(arr);
		System.out.println(Arrays.toString(result));
	}
}