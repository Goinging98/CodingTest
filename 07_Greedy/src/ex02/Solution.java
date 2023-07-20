// 탐욕법(Greedy) > 큰 수 만들기

package ex02;

import java.util.Collections;
import java.util.LinkedList;

// number		k	return
// "1924"		2	"94"
// "1231234"	3	"3234"
// "4177252841"	4	"775841"
// 전략! 왼쪽으로 부터 값을 하나씩 꺼내고 자기보다 큰수가 나오면 꺼내는 것을 멈추고 다음으로 이동, 앞에서 소진 다하기
//  -> 이유? 자리수가 클수록 큰수가 나옴으로

//   number		k	return
//   "1924"		2	"94"
//#0 1,9,2,4,-1 상태로 deque 만들기
//#1 pop '1' and compare '9', 1 < 9임으로 1 pop 유지 // 상태 : 9,2,4,-1, 남은 횟수 1
//#2 pop '9' and compare '2', 9 > 2임으로 push9 // 상태 : 2,4,-1,9, 남은 횟수 1
//#3 pop '2' and compare '4', 2 < 4임으로 2 pop 유지 // 상태 : 4,-1,9, 남은 횟수 0
//#4 남은 횟수 0임으로 -1이 나올때까지 push pop 반복하여 제거 // 상태 : 9,4
// 문자열로 합쳐서 리턴 = 94

public class Solution {
	public String solution(String number, int k) {
		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = 0; i < number.length(); i++) {
			int num = number.charAt(i) - '0';
			while(k > 0) {
				if(!stack.isEmpty() && num > stack.peek()) {
					stack.pop();
					k--;
				} else {
					break;
				}
			}
			stack.push(num);
		}
		Collections.reverse(stack);
		StringBuffer sb = new StringBuffer();
		for(int val : stack) {
			sb.append(val);
		}
		sb.delete(sb.length() - k, sb.length());
		return sb.toString();
	}

	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		String result = new Solution().solution(number, k);
		System.out.println(result);
	}
}