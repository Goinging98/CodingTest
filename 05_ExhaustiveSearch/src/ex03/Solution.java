// 완전탐색 > 소수 찾기
package ex03;

import java.util.HashSet;
import java.util.Set;

// numbers	return
// "17"		3
// "011"	2

// 전략! 재귀함수를 통해 DFS 알고리즘으로 풀 예정
// permutations(순열) vs combination(조합)
// -> 이문제는 permutations로 풀어야 풀리는 문제!

public class Solution {
	boolean[] visited; // 배열 또는 set으로도 만들수 있다. 방문 여부를 저장
	char[] numbersArr; // numbers를 배열로 바꿔서 표현
	Set<Integer> set = new HashSet<>(); // 정답인 소수를 담는 set
	
	// 소수 판단용, 외워야한다.
	public boolean isPrime(int n) {
		if (n == 1 || n == 0)
			return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
	// level : 현재 자기가 돌고 있는 트리의 레벨, 초기값 = 0
	// length : 레벨의 최대 크기
	public void dfs(int level, int length, String numbers) {
		// 끝나는 기준을 if문으로 앞에 짠다.
		if(level == length) {
			int num = Integer.parseInt(new String(numbersArr).substring(0, length));
			if(isPrime(num)) {
				System.out.println(new String(numbersArr).substring(0, length));
				set.add(num);
			}
			return;
		}
		
		// 실제 순회하는 반복문
		for(int i = 0; i < numbers.length(); i++) {
			if(visited[i] == false) {
				visited[i] = true;
				numbersArr[level] = numbers.charAt(i);
				dfs(level+1, length, numbers);
				visited[i] = false;
			}
		}
	}
	
	public int solution(String numbers) {
		visited = new boolean[numbers.length()];
		numbersArr = new char[numbers.length()];
		
		// 현재 돌아야하는 level을 제한하는 반복문
		for(int i = 0; i < numbers.length(); i++) {
//			dfs(0, i, numbers, visited, numbersArr); // class가 아니면 이런식으로 재귀만들어야한다.
			dfs(0, i + 1, numbers);
		}
		
		return set.size();
	}
	
	public static void main(String[] args) {
		String numbers = "123";
		int result = new Solution().solution(numbers);
		System.out.println(result);
	}
}