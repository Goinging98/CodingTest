// 힙(Heap) > 디스크 컨트롤러 
package ex02;

import java.util.*;

// 전략 : 시뮬레이션 풀이하는데, 중간에 실행 우선순위에 대한 알고리즘을 직접 구현해보았다!
//jobs						return
//[[0, 3], [1, 9], [2, 6]]	9

class Solution {
	// 생각없이 풀어본 버전 -> 손으로 알고리즘 구성한 문제
    public int solution2(int[][] jobs) {
    	List<int[]> queue = new ArrayList<>();
    	for(int arr[] : jobs) {
    		queue.add(arr);
    	}
    	// 정렬이 필요할꺼 같아서 했는데, 나중에 풀이보니 반드시 필요했음!
//    	Collections.sort(list, new Comparator<int[]>() {
//    		public int compare(int[] o1, int[] o2) {
//    			return Integer.compare(o1[0], o2[0]);
//    		}
//    	});
    	// 단축된 정렬 문법
    	Collections.sort(queue, (o1, o2)->{
    		return Integer.compare(o1[0], o2[0]);
    	});
//    	for(int[] arr : list) {
//    		System.out.println(Arrays.toString(arr));
//    	}
    	
    	int now = 0; // 현재시간
    	int answer = 0;

    	while(!queue.isEmpty()) {
    		int pickIndex = -1; // flag 
    		// 먼저 실행시킬 스케줄을 찾아오는 로직
    		for(int i = 0; i < queue.size(); i++) {
    			if(queue.get(i)[0] <= now) { // 현재시간에 실행 가능한 스케줄
    				// 걸리는 시간이 적은 스케줄을 탐색하는 과정
    				if(pickIndex == -1 || queue.get(i)[1] < queue.get(pickIndex)[1]) {
    					pickIndex = i;
    				}
    			} else { 
    				break;
    			}
    		}
    		if(pickIndex >= 0) {
    			answer += now - queue.get(pickIndex)[0] + queue.get(pickIndex)[1]; // 현실 모든 실행 시간을 계산하는 방법
    			now += queue.get(pickIndex)[1]; // 다음 실행시간
    			queue.remove(pickIndex);
    		}else { // 실행할께 없을때 pickIndex == -1
    			now += 1; // 에이징 
    		}
    	}
    	return answer / jobs.length; // 평균 실행시간
    }
    
    
    // 정석적인 Heap으로 풀이한 방법
    public int solution(int[][] jobs) {
    	// 실행 시간순으로 정렬시킨 큐 기준 : job[0]
    	PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)->{
    		return Integer.compare(o1[0], o2[0]);
    	});
    	for(int arr[] : jobs) {
    		queue.add(arr);
    	}
    	
    	int now = 0; // 현재시간
    	int answer = 0;
    	
    	while(!queue.isEmpty()) {
    		// 실행시간으로 정렬한 큐 : job[1]
        	PriorityQueue<int[]> priorityCheckQueue = new PriorityQueue<>((o1, o2)->{
        		return Integer.compare(o1[1], o2[1]);	
        	});
        	for(int[] job : queue) {
        		if(job[0] <= now) {
        			priorityCheckQueue.add(job);
        		}
        	}
    		
    		if(priorityCheckQueue.isEmpty() == false) {
    			int job[] = priorityCheckQueue.poll();
    			answer += now - job[0] + job[1]; // 현실 모든 실행 시간을 계산하는 방법
    			now += job[1]; // 다음 실행시간
    			queue.remove(job);
    		}else { // 실행할께 없을때 pickIndex == -1
    			now += 1; // 에이징 
    		}
    	}
    	return answer / jobs.length; // 평균 실행시간
    }
    
    public static void main(String[] args) {
    	int[][] jobs = {{0, 3}, {2, 6}, {1, 9}};
    	int result = new Solution().solution(jobs);
    	System.out.println(result);
	}
}