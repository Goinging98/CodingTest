//깊이/너비 우선 탐색(DFS/BFS) > 단어 변환

package ex04;

import java.util.LinkedHashSet;
import java.util.Set;

//begin	target	words										return
//"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
//"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]			0

//예를 들어 begin이 "hit", target가 "cog", 
//words가 ["hot","dot","dog","lot","log","cog"]라면 
//"hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

public class Solution {
	// String을 만들수 있었던 이유는 중복이 없어서 가능했고, 만약 단어가 중복이 되면 Set<Integer>, index
	Set<String> visitedSet = new LinkedHashSet<>();
	int answer = 0;
	
	public int calcGap(String target, String word) {
		int gap = 0;
		for(int i = 0; i < target.length(); i++) {
			if(target.charAt(i) != word.charAt(i)) {
				gap++;
//				if(gap >= 2) { // 알고리즘 시간 단축용
//					return 2;
//				}
			}
		}
		return gap;
	}
    
	public void search(int index, String word, String begin, String target, String[] words) {
		System.out.println(visitedSet);
		if(index != -1 && word.equals(target)) {
			System.out.println(visitedSet.size());
			answer = Integer.min(answer, visitedSet.size());
			return;
		}
		for(int i = 0; i < words.length; i++) {
			if(visitedSet.contains(words[i]) == false && calcGap(word, words[i]) == 1) {
				visitedSet.add(words[i]);
				search(i, words[i], begin, target, words);
				visitedSet.remove(words[i]);
			}
		}
	}
	
	public int solution(String begin, String target, String[] words) {
        this.answer = words.length;
        search(-1, begin, begin,target, words);
        if( this.answer == words.length) {
        	return 0;
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	String begin = "hit";
    	String target = "cog";
    	String[] words = {"hot", "dot", "dog", "lot", "log"};
    	int result = new Solution().solution(begin, target, words);
//    	System.out.println(new Solution().calcGap("hit", "hot")); // 1
//    	System.out.println(new Solution().calcGap("hit", "hit")); // 0
//    	System.out.println(new Solution().calcGap("dog", "dtt")); // 2
//    	System.out.println(new Solution().calcGap("aaa", "bbb")); // 3
//    	System.out.println(result);	
    }
}
​
​
​