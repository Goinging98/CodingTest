package ex04;

import java.util.LinkedHashSet;
import java.util.Set;

// begin	target	words										return
// "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
// "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]			0

public class Solution2 {
	int answer;
	Set<Integer> visitedSet = new LinkedHashSet<>();
	
	public int calcGap(String target, String word) {
		int gap = 0;
		for(int i = 0; i < target.length(); i++) {
			if(target.charAt(i) != word.charAt(i)) {
				gap++;
			}
		}
		return gap;
	}

	public void search(int visitIndex, String nextWord, String begin, String target, String[] words) {
//		System.out.println(visitedSet);
		if(visitIndex >= 0 && target.equals(words[visitIndex])) {
			answer = Integer.min(visitedSet.size(), answer);
			return;
		}
		
		for(int i = 0; i < words.length; i++) {
			// 방문 가능할때
			if(visitedSet.contains(i) == false && calcGap(nextWord, words[i]) == 1) {
				visitedSet.add(i);
				search(i, words[i], begin, target, words);
				visitedSet.remove(i);
			}
		}
	}
	
	public int solution(String begin, String target, String[] words) {
		answer = words.length;
		search(-1, begin, begin, target, words);
		if(answer == words.length) {
			return 0;
		}
		return answer;
	}

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		int result = new Solution2().solution(begin, target, words);
		System.out.println(result);
	}
}