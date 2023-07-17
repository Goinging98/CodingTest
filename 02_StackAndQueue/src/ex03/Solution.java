package ex03;

//s		answer
//"()()"	true
//"(())()"	true
//")()("	false
//"(()("	false

//(   )  (  ) 
//+1 -1 +1 -1
//1  0   1  0 = 0

//(  (  )  )  (  )
//+1 +1 -1 -1 +1 -1
//1  2   1  0  1  0 = 0

//)  (  )  (
//-1 +1 -1 +1
//-1, NG! = -음수가 될수 없음

//(  (  )  (
//+1 +1 -1 +1 = 1 NG, 끝났을때는 0

class Solution {
 boolean solution(String s) {
 	int val = 0;
 	for(int i = 0; i < s.length(); i++) {
 		if(s.charAt(i) == '(') {
 			val += 1; 
 		}else {
 			val -= 1; 
 		}
// 		System.out.println(val);
 		if(val < 0) {
 			return false;
 		}
 	}
// 	System.out.println(val);
 	if(val == 0) {
 		return true;
 	}else {
 		return false;
 	}
 }
 
 public static void main(String[] args) {
 	String s = "(()(";
 	boolean result = new Solution().solution(s);
 	System.out.println(result);
	}
}


