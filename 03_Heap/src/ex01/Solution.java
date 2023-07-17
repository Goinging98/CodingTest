// 힙(Heap) > 더 맵게
package ex01;

import java.util.*;

// 전략 : 전형적인 라운딩 문제로 돌려봐야안다. = 시뮬레이션 필수!
//       PriorityQueue 써야 반드시 풀리는 문제다.

//     scoville					K	return
//     [1, 2, 3, 9, 10, 12]		7	2
//#1-1 [3, 9, 10, 12]   2개를 뽑아서 스코빌 지수 계산 -> 1 + (2*2) = 5
//#1-2 [3, 5, 9, 10, 12]  계산한 스코빌 지수를 다시 큐에 넣고, 정렬!!
//#2-1 [9, 10, 12]  2개를 뽑아서 스코빌 지수 계산 -> 3 + (5*2) = 13
//#2-2 [9, 10, 12, 13]  계산한 스코빌 지수를 다시 큐에 넣고, 정렬!!, 체크시 모두 7이상이 되서 풀이 끝!
//     정답 2라운드 돌리면 끝.


// 이문제를 풀기 위해선 꼭 외워야하는 컬랙션!! = PriorityQueue \
// PriorityQueue : 중복을 허용하면서 Tree구조로 값을 유지하는 자료구조, 즉 Heap
// TreeSet으로 풀이 불가능하다! 이유? : 중복을 허용하지 않는다.
public class Solution {
    public int solution(int[] scoville, int K) {
//    	LinkedList<Integer> queue = new LinkedList<>(); // 시간복잡도 : O(n^3)
    	PriorityQueue<Integer> queue = new PriorityQueue<>(); // 시간복잡도 : O(n^3)
    	for(int v : scoville) {
    		queue.add(v);
    	}

    	int count = 0;
    	while(true) {
    		// 체킹부를 앞에 설계해야한다. 이유 : TC중 스코빌지수가 K 이상인 배열이 주어진다.
    		boolean isFinish = true;
    		for(int v : queue) {
    			if(v < K) {
    				isFinish = false;
    				break;
    			}
    		}
    		if(isFinish == true) {
    			return count;
    		}
    		if(queue.size() < 2) {
    			return -1;
    		}
    		
    		// 스코빌 지수 만드는 영역
    		int val1 = queue.poll(); // 앞에꺼를 가져오는 메소드
    		int val2 = queue.poll(); 
    		int val3 = val1 + (val2 * 2);
    		queue.add(val3);
    		count++;
//    		Collections.sort(queue);
    	}
    }
    
    public static void main(String[] args) {
    	int[] scoville = {1, 2, 3, 9, 10, 12};
    	int K = 7;
    	int result = new Solution().solution(scoville, K);
    	System.out.println(result);
	}
}
