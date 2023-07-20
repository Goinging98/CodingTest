//완전탐색 > 모의고사
package ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
// 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
// 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

// answers						return
// [1,2,3,4,5,1,2,3,4,5,1,2]	[1]
// [1,3,2,4,2]					[1,2,3]

public class Solution {
    public int[] solution(int[] answers) {
    	int[][] pattern = {
    			{1, 2, 3, 4, 5},
    			{2, 1, 2, 3, 2, 4, 2, 5},
    			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
    	};
    	List<Integer> list = new ArrayList<>(); // count용 리스트
    	for(int i = 0; i < 3; i++) {
    		list.add(0);
    	}
    	
    	for(int i =0; i < answers.length; i++) {
    		for(int j =0; j < pattern.length; j++) {
    			if(answers[i] == pattern[j][i % pattern[j].length]) {
    				list.set(j, list.get(j)+ 1);
    			}
    		}
    	}
//    	System.out.println(list);
    	int max = Collections.max(list);
        int[] answer = new int[list.size()];
        int count = 0;
        for(int i=0; i<list.size(); i++) {
        	if(list.get(i) == max) {
        		answer[count++] = i + 1;
        	}
        }
        return Arrays.copyOf(answer, count);
    }
    public static void main(String[] args) {
//    	int[] answers = {1,2,3,4,5,1,2,3,4,5,1,2};
    	int[] answers = {1,3,2,4,2};
    	int[] result = new Solution().solution(answers);
    	System.out.println(Arrays.toString(result));
	}
}