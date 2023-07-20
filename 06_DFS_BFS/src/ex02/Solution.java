// 깊이/너비 우선 탐색(DFS/BFS) 네트워크
package ex02;

import java.util.LinkedHashSet;
import java.util.Set;

// n	computers							return
// 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
// 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1

// 전략! 한곳을 방문하여 끝까지 이어 버리는 전략, 전체를 방문하면 나머지 노드를 모두 방문해서 갯수 구하기
public class Solution {
	Set<Integer> visitedSet = new LinkedHashSet<>();
	
	void dfs(int index, int n, int[][] computers) {
		visitedSet.add(index); // 방문한거 체크
//		System.out.println(visitedSet);
		// [1, 1, 0] 인접한 노드 돌리는 반복문
		for(int i = 0; i < computers[index].length; i++) {
			if(visitedSet.contains(i) == false && computers[index][i] == 1) { // 인접한 노드만 방문하는 조건
				dfs(i, n, computers);
			}
		}
	}
	
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i = 0; i < computers.length; i++) {
        	if(visitedSet.contains(i) == false) {
        		dfs(i, n, computers);
        		answer++;
//        		System.out.println("방문 끝!");
        	}
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int n = 3;
    	int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    	int result = new Solution().solution(n, computers);
    	System.out.println(result);
	}
}