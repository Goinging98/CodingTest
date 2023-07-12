// 베스트 앨범 : 풀어보기 좋은 문제 
package ex05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// genres											plays						return
// ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
// 해당 문제는 Test case까지 만드는 것이 시험 범위로 생각하고 몇개 더 만들어 놓는다.
// ["classic", "pop", "classic", "classic", "pop"]	[800, 600, 800, 800, 2500]	[4, 1, 0, 1]
// ["classic", "classic", "classic", "classic", "pop"]	[800, 600, 800, 800, 4000]	[4, 0, 1]
// ["classic", "classic", "classic", "classic", "classic"]	[800, 600, 800, 800, 4000]	[4, 0]

// 풀이 전략
// ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]

// 1. 장르와 플레이시간을 묶어서 일종의 ID를 만들고 index와 맵핑한다.
// classic500 -> hash - 2198319384 -> 0 index이다.
// pop600 -> hash - 84832922 -> 1 index이다.

// 2. 장르별로 플레이시간을 더해서 map-list로 구현한다. list에 넣을때는 플레이 시간으로 정렬한다.
// classic - 800, 500, 150
// pop - 2500, 600

// 3. 전체 재생시간을 구하고 장르별 베스트 앨범의 우순선위를 정리한다.
// 1순위 : 2500+600 = 3100- pop
// 2순위 : 800+500+150 = 1450- classic

// 4. 장르별 우선순위와 장르별 재생 많이 된곡의 index를 찾아 답을 만든다.
// pop-4,1 / classic-3,0


class Solution {
    public int[] solution(String[] genres, int[] plays) {
    	Map<Integer, Set<Integer>> idToIndexMap = new TreeMap<>();
    	Map<String, Set<Integer>> genresTimeMap = new HashMap<>();
    	Map<String, Integer> genresToTotalTimeMap = new HashMap<>();
    	
    	// 초기화 로직
    	for(int i=0; i <genres.length; i++) {
    		int idKey = genres[i].hashCode() + plays[i]; // 일종의 id 개념
    		if (idToIndexMap.get(idKey) == null) {
    			idToIndexMap.put(idKey, new TreeSet<>());
			}
    		idToIndexMap.get(idKey).add(i);
    		
    		if(genresTimeMap.get(genres[i]) == null) {
    			genresTimeMap.put(genres[i], new TreeSet<>());
    		}
    		genresTimeMap.get(genres[i]).add(plays[i]);
    		genresToTotalTimeMap.put(genres[i], 
    						genresToTotalTimeMap.getOrDefault(genres[i], 0) + plays[i]);
    	}
//    	System.out.println("idToIndexMap");
//    	System.out.println(idToIndexMap);
//    	System.out.println("genresTimeMap");
//    	System.out.println(genresTimeMap);
//    	System.out.println("genresToTotalTimeMap");
//    	System.out.println(genresToTotalTimeMap);

    	// 장르별 우선순위 선정하는 방법
    	Map<Integer, String> totalTimeGenresMap = new TreeMap<>();
    	Set<String> keySet = genresToTotalTimeMap.keySet();
    	for(String key : keySet) {
    		totalTimeGenresMap.put(genresToTotalTimeMap.get(key), key);
    	}
//    	System.out.println(totalTimeGenresMap);

    	// 수록곡 선정하는 과정
    	int[] answer = new int[genres.length];
    	int count = 0; // 수록된 곡의 갯수
    	Set<Integer> keySet2 = totalTimeGenresMap.keySet(); 
    	List<Integer> list = new ArrayList<Integer>(keySet2);
    	Collections.reverse(list);
    	
    	for(int time : list) {
    		String genre = totalTimeGenresMap.get(time);
    		Set<Integer> set = genresTimeMap.get(genre);
    		List<Integer> list2 = new ArrayList<>(set);
    		Collections.reverse(list2);
    		int i = 0;
    		out : for(int key : list2) {
    			int idKey = genre.hashCode() + key;
    			Set<Integer> set2 = idToIndexMap.get(idKey);
    			for(int index : set2) {
    				answer[count++] = index;
    				if(++i >= 2) {
    					break out;
    				}
    			}
    		}
    	}
    	return Arrays.copyOf(answer, count);
    }
    
    public static void main(String[] args) {
    	String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    	int[] plays = {800, 600, 150, 800, 2500};
    	int[] result = new Solution().solution(genres, plays);
    	System.out.println(Arrays.toString(result));
	}
}
