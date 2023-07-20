// 정렬 > 가장 큰 수

package ex02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// numbers	        return
// [6, 10, 2]	    "6210"
// [3, 30, 34, 5, 9]	"9534330"

// [6, 2, 10] = 6210
// [9, 5, 34, 3, 30] = 9534330

// numbers의 길이는 1 이상 100,000 이하입니다.
// numbers의 원소는 0 이상 1,000 이하입니다.
// 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다

class Solution {
	public String solution(int[] numbers) {
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < numbers.length; i++) {
			list.add("" + numbers[i]);
		}

//		Collections.sort(list, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return (o2 + o1).compareTo(o1 + o2);
//			}
//		});
		Collections.sort(list, (o1, o2) -> {
			return (o2 + o1).compareTo(o1 + o2);
		});
		
		StringBuilder sb = new StringBuilder();
		for (String val : list) {
			if (val.equals("0") && sb.length() == 0) {
				continue;
			}
			sb.append(val);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 10, 100, 1000 };
		String str = new Solution().solution(arr);
		System.out.println(str);
	}
}