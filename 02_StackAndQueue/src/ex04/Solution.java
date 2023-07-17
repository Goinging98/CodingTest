package ex04;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//	priorities				location	return
//	[2, 1, 3, 2]			2			1
//	[1, 1, 9, 1, 1, 1]		0			5

//  전략 : 전형적인 Round 돌리는 문제로 시뮬레이션 그대로 해주면 문제 풀이 끝!
//	priorities				location	return
//	[2, 1, 3, 2]			2			1
//  A-2, B-1, C-3, D-2 (문서이름, 우선순위), C가 첫번째로 나온다!

//   실제 문제풀이를 위해서 문자열이 아닌 index로 다시 정리 
//       [0-2, 1-1, 2-3, 3-2 (문서 index, 우선순위)
//#1 Pop  0-2  [1-1, 2-3, 3-2], index 0이 실행 가능한가? 안된다. -> 2-3이 존재 
//   push [1-1, 2-3, 3-2, 0-2]
//#2 Pop  1-1  [2-3, 3-2, 0-2], index 1이 실행 가능한가? 안된다. -> 2-3이 존재 
//   push [2-3, 3-2, 0-2, 1-1]
//#3 Pop  2-3  [3-2, 0-2, 1-1], index 2이 실행 가능한가? 가능!!  index2는 1번째로 실행
//   push 실행 없음!, [3-2, 0-2, 1-1] 유지
//#4 Pop  3-2  [0-2, 1-1], index 3이 실행 가능한가? 가능!!  index3는 2번째로 실행
//   push 실행 없음!,  [0-2, 1-1] 유지
//#5 Pop  0-2 [1-1], index 0이 실행 가능한가? 가능!!  index0는 3번째로 실행
//   push 실행 없음!, [1-1] 유지
//#6 Pop  1-1 [] index 0이 실행 가능한가? 가능!!  index1는 4번째로 실행
//   push 실행 없음!, [] 유지
// - 끝


class Solution {
    public int solution(int[] priorities, int location) {
    	Map<Integer, Integer> indexPriorityMap = new HashMap<>();	
    	LinkedList<Integer> waitQueue = new LinkedList<>(); // 대기큐
    	LinkedList<Integer> exitQueue = new LinkedList<>(); // 종료큐
    	// 초기화부
    	for(int i = 0; i < priorities.length; i++) {
    		waitQueue.add(i);
    		indexPriorityMap.put(i, priorities[i]);
    	}
//    	System.out.println("waitQueue  : " + waitQueue);
//    	System.out.println("indexPriorityMap  : " + indexPriorityMap);
//    	System.out.println("priorities  : " + Arrays.toString(priorities));
//    	System.out.println();
    	
    	// while(true){
    	for(int k = 0; k < 10; k++) {
    		int index = waitQueue.remove(0); // 대기열에서 pop
    		int priority = indexPriorityMap.remove(index); // map에서도 우선순위 pop
    		int maxPriority = Collections.max(indexPriorityMap.values());
    		if(priority < maxPriority) { // 내 우선순위가 작을때, 다시 queue로 들어간다.
    			waitQueue.add(index);
    			indexPriorityMap.put(index, priority);
    		} else { // 내가 우선순위가 제일 높을때
    			exitQueue.add(index);
    			if(waitQueue.size() == 1) {
    				exitQueue.add(waitQueue.get(0));
    				break;
    			}
    		}
//    		System.out.println("round : " + (k+1));
//    		System.out.println(waitQueue);
//    		System.out.println(exitQueue);
//    		System.out.println();
    	}
    	
		System.out.println(exitQueue);
        return exitQueue.indexOf(location) + 1;
    }
    
    public static void main(String[] args) {
    	int[] priorities = {2, 1, 3, 2};
    	int location = 2;
    	int result = new Solution().solution(priorities, location);
    	System.out.println(result);
	}
}