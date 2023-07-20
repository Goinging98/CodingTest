package ex01;

class Solution {
	int answer = Integer.MAX_VALUE;
	int N = 0;
	int number = 0;
	
	void serach(int nCount, int result){
		if(nCount > 8) {
			return;
		}
		
		if(result == number) {
			System.out.println("nCount : " + nCount);
			answer = answer >= nCount ? nCount : answer;
			return;
		}
		
		int calcN = N;
		for(int i = 0; i < (8 - nCount); i++) {
			serach(nCount + 1 + i, result + calcN); 
			serach(nCount + 1 + i, result - calcN); 
			serach(nCount + 1 + i, result * calcN); 
			serach(nCount + 1 + i, result / calcN);
			calcN = calcN * 10 + N;
		}
	}
	
	public int solution(int N, int number) {
		this.N = N;
		this.number = number;
		
		serach(0, 0);
		
		if(answer == Integer.MAX_VALUE) {
			return -1;
		}
		
		return answer;
	}
	
	/*
	 * N	number	return
		5	12	4
		2	11	3
	 */
	public static void main(String[] args) {
		int result = new Solution().solution(5, 12);
		System.out.println(result); // 4
	}
}
