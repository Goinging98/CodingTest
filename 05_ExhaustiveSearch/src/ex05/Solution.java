// 완전탐색 > 피로도
package ex05;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// k	    dungeons	                result
// 80		[[80,20],[50,40],[30,10]]	3
// 정렬이 의미 있나? -> 우선순위 의미 없다.
//   -> 모든 경우의 수를 다 구하고, 가장 많은 탐색을 할수 있는 경우를 찾아 내야함

public class Solution {
	Set<Integer> visitSet = new LinkedHashSet<>(); // LinkedHashSet-순서유지됨
	int k;
	int[][] dungeons;
	int answer = -1; // 던전을 돌수 있는 최대값

	public void dfs(int nowK) { // nowK = 소모된 피로도
		// 정지하는 if문 -> 생략함!
//		System.out.println(visitSet);
		boolean isVisited = false;
		for(int i = 0; i < dungeons.length; i++) {
			// 던전을 방문하지 않았고, 현재 소모된 피로도가 던전 입장 피로도 보다 낮을때, 요약하면 방문 가능할때
			if(visitSet.contains(i) == false && nowK + dungeons[i][0] <= k) {
				isVisited = true;
				visitSet.add(i);
				dfs(nowK + dungeons[i][1]); // 방문 피로도를 더해 다음 던전 돌것을 계산
				visitSet.remove(i);
			}
		}
		
		// 더이상 던전을 방문할수 없을때
		if(isVisited == false) {
			answer = Integer.max(answer, visitSet.size());
		}
	}

	public int solution(int k, int[][] dungeons) {
		this.k = k;
		this.dungeons = dungeons;
		dfs(0); // 초기상태 셋팅
		return answer;
	}

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };
		int result = new Solution().solution(k, dungeons);
		System.out.println(result);
	}
}