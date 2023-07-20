package ex03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//# 힙(Heap) > 이중우선순위큐
//
//# operations	                                                return
//# ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0, 0]
//# ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
//
//# 명령어	수신 탑(높이)
//# I 숫자	큐에 주어진 숫자를 삽입합니다.
//# D 1		큐에서 최댓값을 삭제합니다.
//# D -1	큐에서 최솟값을 삭제합니다.

public class Solution {
	public int[] solution2(String[] operations) {
		int[] answer = { 0, 0 };
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(String cmd : operations) {
			System.out.println(cmd);
			if(cmd.contains("I")) {
				queue.add(Integer.parseInt(cmd.split(" ")[1]));
			}
			if(queue.isEmpty()) {
				continue;
			}
			if(cmd.contains("D 1")) {
				int maxValue = Collections.max(queue);
				queue.remove(maxValue);
				System.out.println(maxValue);
			}
			if(cmd.contains("D -1")) {
				int val = queue.poll();
				System.out.println(val);
			}
			System.out.println(queue);
			System.out.println();
		}
		if(queue.isEmpty()) {
			return answer;
		}
		answer[0] = Collections.max(queue);
		answer[1] = queue.peek();
		return answer;
	}
	
	public int[] solution(String[] operations) {
		int[] answer = { 0, 0 };
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(String cmd : operations) {
			System.out.println(cmd);
			if(cmd.contains("I")) {
				queue.add(Integer.parseInt(cmd.split(" ")[1]));
			}
			if(queue.isEmpty()) {
				continue;
			}
			if(cmd.contains("D 1")) {
				int maxValue = Collections.max(queue);
				queue.remove(maxValue);
				System.out.println(maxValue);
			}
			if(cmd.contains("D -1")) {
				int minValue = Collections.min(queue);
				queue.remove(minValue);
				System.out.println(minValue);
			}
			System.out.println(queue);
			System.out.println();
		}
		if(queue.isEmpty()) {
			return answer;
		}
		answer[0] = Collections.max(queue);
		answer[1] = Collections.min(queue);
		return answer;
	}

	public static void main(String[] args) {
		String[] operations = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
		int[] result = new Solution().solution(operations);
		System.out.println(Arrays.toString(result));
	}
}