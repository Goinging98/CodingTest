package ex03;

import java.util.HashSet;
import java.util.Set;

//phone_book							return
//["119", "97674223", "1195524421"]		false
//["123","456","789"]					true
//["12","123","1235","567","88"]		false

//전략 > 작은 문자열과 큰 문자열 비교로 찾아낸다. 해쉬로 치환해서 찾는 테크닉이 필요!
//전략 풀이, 큰 문자열을 Set에 넣을때 잘라서 하나씩 비교한다.
//예시) 1195524421 -> 119, 1195, 11955, 119552, 1195524 ... 1195524421

class Solution {
	public boolean solution(String[] phone_book) {
		Set<String> set = new HashSet<>();
		int min = Integer.MAX_VALUE;
		
		// set 초기화 코드 + 문자열 최소크기 찾는 방법
		for (String str : phone_book) {
			set.add(str);
			if(str.length() < min) {
				min = str.length();
			}
		}
		
		// 긴 문자열을 하나씩 잘라서 set에 문자열을 찾는 방법 
		for(String str : phone_book) {
			for(int i = min; i<str.length(); i++) {	//문자열 잘라서 비교하는 로직
				String head = str.substring(0, i);	// 0부터 i번째까지 자르기
				if(set.contains(head) == true) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		boolean result = new Solution().solution(phone_book);
		System.out.println(result);
	}

}
