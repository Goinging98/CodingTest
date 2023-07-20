// 좋은 문제 
// 깊이/너비 우선 탐색(DFS/BFS) > 타겟 넘버

package ex01;

// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3

// numbers			target	return
// [1, 1, 1, 1, 1]	3		5
// [4, 1, 2, 1]		4		2

public class Solution {
	// visited 필요 없는 문제! -> 한방향 탐색만 하면 되기 때문에
	int answer = 0; // target하고 맞는 경우 count할 변수
	
	public void bfs(int level, int calcValue, int[] numbers, int target) {
		// 멈추는 케이스
		if(level == numbers.length) {
			if(calcValue == target) {
				answer++;
			}
			return;
		}
//		System.out.println("\t".repeat(level) + (+numbers[level]));
//		System.out.println("\t".repeat(level) + (-numbers[level]));
		bfs(level + 1, calcValue + numbers[level], numbers, target); // +1
		bfs(level + 1, calcValue - numbers[level], numbers, target); // -1
	}
	
    public int solution(int[] numbers, int target) {
    	bfs(0, 0, numbers, target); // 초기 호출
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] numbers = {1, 1, 1, 1, 1};
    	int target = 3;
    	int result = new Solution().solution(numbers, target);
    	System.out.println(result);
	}
}