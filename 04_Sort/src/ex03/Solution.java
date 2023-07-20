// 정렬 > H-Index

package ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// citations	        return
// [3, 0, 6, 1, 5]		3
// [6, 5, 3, 1, 0]		3
// f(A)=10, f(B)=8, f(C)=5, f(D)=4, f(E)=3　→ h-index=4
// f(A)=25, f(B)=8, f(C)=5, f(D)=3, f(E)=3　→ h-index=3


public class Solution {
    public int solution(int[] citations) {
    	List<Integer> list = new ArrayList<>();
    	for(int val : citations) {
    		list.add(val);
    	}
    	Collections.sort(list);
    	Collections.reverse(list);
//    	System.out.println(list);
    	
    	for(int i = 0; i < list.size(); i++) {
//    		System.out.println(i +","+list.get(i));
    		if(i >= list.get(i)) {
    			return i;
    		}
    	}
    	
        return list.size();
    }
    
    public static void main(String[] args) {
    	int[] citations = {3, 0, 6, 1, 5};
    	int result = new Solution().solution(citations);
    	System.out.println(result);
	}
}