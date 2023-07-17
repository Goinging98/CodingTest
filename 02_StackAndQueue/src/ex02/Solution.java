package ex02;

import java.util.Arrays;

// progresses					speeds				return
// [93, 30, 55]					[1, 30, 5]			[2, 1]
// [95, 90, 99, 99, 80, 99]		[1, 1, 1, 1, 1, 1]	[1, 3, 2]

// 풀이 전략! -> Round 문제 = 시뮬레이션, 실제 돌아가는데로만 구현하면 완료가 되는 문제!
//  [93, 30, 55]				[1, 30, 5]			[2, 1]
//1 [94, 60, 60]  배포 가능? -> 불가능
//2 [95, 90, 65]  배포 가능? -> 불가능
//3 [96, 100, 70]  배포 가능? -> 불가능하지만 1개 개발완료
//4 [97, 100, 75]  배포 가능? -> 불가능
//5 [98, 100, 80]  배포 가능? -> 불가능
//6 [99, 100, 85]  배포 가능? -> 불가능
//7 [100, 100, 90]  배포 가능? -> 배포가능!!! 몇개? 2개, [2, ]
//8 [100, 100, 95]  배포 가능? -> 불가능
//9 [100, 100, 100]  배포 가능? -> 배포가능!!! 몇개? 1개, [2, 1]

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = new int[progresses.length];
		int[] state = new int[progresses.length]; // 0 = 개발중, 1 = 배포가능, 2 = 배포끝
		int count = 0;
		int allFinishCount = 0;

		// 라운드를 돌리기 위한 임시 for문, 나중에는 while로 바뀌어야 한다(반복문이 10개 이상이라)
		for (int j = 0; j < 10; j++) {
//          while(true) {
			int finishCount = 0;
			for (int i = 0; i < progresses.length; i++) {
				progresses[i] += speeds[i];
				// 개발이 끝났는지 확인하는 반복문
				if (progresses[i] >= 100) {
					state[i] = 1; // 배포가능여부 체크!
					finishCount++; // 배포 가능 여부 확인 변수
					progresses[i] = Integer.MIN_VALUE;
				}
			}

			// 배포 가능할때
			if (finishCount > 0) {
				int deployCount = 0; // 배포가 가능한수
				allFinishCount += finishCount;
				for (int i = 0; i < state.length; i++) {
					if (state[i] == 0) {
						break;
					}
					if (state[i] == 1) {
						deployCount++;
						state[i] = 2; // 배포 완료!
					}
				}
				if (deployCount > 0) {
					answer[count++] = deployCount;
				}
			}
			System.out.println("round : " + (j + 1));
			System.out.println("progresses : " + Arrays.toString(progresses));
			System.out.println("state : " + Arrays.toString(state));
			System.out.println("answer : " + Arrays.toString(answer));
			System.out.println();
			if (allFinishCount == progresses.length) {
				break;
			}
		}

		return Arrays.copyOf(answer, count);
	}

	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		int[] result = new Solution().solution(progresses, speeds);
		System.out.println(Arrays.toString(result));
	}
}
