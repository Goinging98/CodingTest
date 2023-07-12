package ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//participant											completion			return
//["leo", "kiki", "eden"]								["eden", "kiki"]	"leo"
//["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
//["mislav", "stanko", "mislav", "ana"]				["stanko", "ana", "mislav"]		"mislav"

//문제 풀이 전 반드시 손으로 시뮬레이션 돌려봐야한다!
//["leo", "", ""] - ["eden", "kiki"] = leo
//["", "", "", "vinko", ""] ["", "", "", ""] = vinko
//["", "", "mislav", ""] ["", "", ""] = mislav

class Solution {
	// 풀이 실패한 코드!! 이유 : 시간초과, 복잡도 : O(n^3), 3차원이라 안풀림!!
    public String solution2(String[] participant, String[] completion) {
    	List<String> participantList = new ArrayList<>();
//    	participantList = Arrays.asList(participant); // 쓰면 안된다!, 읽기전용이라 안도니다.
    	
    	for(String name : participant) {
    		participantList.add(name);
    	}
    	
    	for(String name : completion) {
    		for(int i = 0; i < participantList.size(); i++) {
    			if(participantList.get(i).equals(name)) {
    				participantList.remove(i);
    				break;
    			}
    		}
    		// 2줄로 줄이는 방법
//    		int index = participantList.indexOf(name);
//    		participantList.remove(index);
    	}
    	
        return participantList.get(0);
    }
    
    // map으로 접근하는 솔루션!
    public String solution(String[] participant, String[] completion) {
    	//   이름      사람수
    	Map<String, Integer> map = new HashMap<>();
    	
    	for(String name : participant) {
    		// 초기에는 반드시 기존 사람 수가 있는 확인하거나 초기화 하는 문장
//    		if(map.containsKey(name) == false) {
//    			map.put(name, 0); // 초기화 문장
//    		}
//    		map.put(name, map.get(name) + 1);
    		// 위에 4줄을 단축시킨 문장
    		map.put(name, map.getOrDefault(name, 0) + 1);
    	}
    	
    	// {ana=1, mislav=2, stanko=1}
//    	System.out.println(map);
    	
    	for(String name : completion) {
    		int num = map.get(name) - 1;
    		if(num == 0) {
    			map.remove(name);
    		}else {
    			map.put(name, num - 1);
    		}
    	}
    	
//    	{mislav=0}
//    	System.out.println(map);
    	
    	return map.keySet().iterator().next();
    }
    
    public static void main(String[] args) {
    	String[] participant = {"mislav", "stanko", "mislav", "ana"};
    	String[] completion = {"stanko", "ana", "mislav"};
    	String result = new Solution().solution(participant, completion);
    	System.out.println(result);
	}
}
