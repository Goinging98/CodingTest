// 스택/큐 > 다리를 지나는 트럭

package ex05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		// 트럭이 대기하는 큐
		List<Integer> waitQueue = new LinkedList<Integer>();
		// 트럭의 인덱스와 현재 건넌 다리의 길이를 가져오는 map, 에이징, 나이를 먹일 변수
		Map<Integer, Integer> truckToMoveLengthMap = new HashMap<Integer, Integer>();

		//초기화 문구
		for (int i = 0; i < truck_weights.length; i++) {
			waitQueue.add(i);
		}

		int round = 1;
		int nowWeight = 0;
		int finishCount = 0;
		while (true) {
			// 대기 트럭이 있고, 모든 트럭이 다 건너지 않았을때
			// 트럭이 다리에 올라갈수 있는가 검증하는 문구
			if (finishCount < truck_weights.length && truckToMoveLengthMap.size() < bridge_length) {
				// 다음 트럭이 다리에 올라갈수 있는 확인
				int nextWeight = nowWeight + truck_weights[waitQueue.get(0)];
				if (nextWeight <= weight) {
					// 트럭이 다리에 올라가는 구문
					int index = waitQueue.remove(0);
					finishCount++;
					nowWeight += truck_weights[index];
					truckToMoveLengthMap.put(index, 0);
				}
			}

			List<Integer> finishQueue = new LinkedList<Integer>();
			Iterator<Integer> iter = truckToMoveLengthMap.keySet().iterator();
			while (iter.hasNext()) {
				int index = iter.next();
				int move = truckToMoveLengthMap.get(index) + 1;
				if (move == bridge_length) {
					finishQueue.add(index);
				} else {
					truckToMoveLengthMap.put(index, move);
				}
			}
			for (int index : finishQueue) {
				truckToMoveLengthMap.remove(index);
				nowWeight -= truck_weights[index];
			}
			round++;
			if (waitQueue.size() == 0 && truckToMoveLengthMap.isEmpty() == true) {
				break;
			}
		}

		return round;
	}

	public static void main(String[] args) {
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10};
//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = {7,4,5,6};
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		int result = new Solution().solution(bridge_length, weight, truck_weights);
		System.out.println(result);
	}
}