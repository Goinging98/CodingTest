// 해시 - 의상

package ex04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 제한사항
// clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
// 코니가 가진 의상의 수는 1개 이상 30개 이하입니다.
// 같은 이름을 가진 의상은 존재하지 않습니다.
// clothes의 모든 원소는 문자열로 이루어져 있습니다.
// 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.

//clothes																						return
//[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
//[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]				3

// 수식 유추를 해봐야 풀리는 문제! -> 유추가 안된다? 못푼다.
// headgear - 2, eyewear-1
// face - 3
// -> 5? (2+1) * (1+1) - 1 = 5
// (3 + 1) - 1 = 3
// 유추식 = (의상의 종류 + 1) * (의상의 종류 + 1) - 1, 여기서의 +1는 안입는 케이스, 마지막 -1은 전부 안입는 케이스

class Solution {
	public int solution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();
		
		for(String[] arr : clothes) {
			map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
		}
		
		Collection<Integer> values = map.values();
		List<Integer> list = new ArrayList<Integer>(values);

		int answer = 1;
		for(int value : list) {
			answer *= (value + 1); 
		}
		return answer - 1;
	}
	
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		int result = new Solution().solution(clothes);
		System.out.println(result);
	}
}



