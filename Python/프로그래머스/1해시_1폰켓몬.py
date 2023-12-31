def solution(nums): 
    answer = 0
    length = len(nums) // 2 # 가져갈 수 있는 최대 포켓몬 수 
    nums.sort()
    last = 0 
    
    for value in nums : 
        if(value != last and answer < length) : # value가 last와 다르고, answer가 길이보다 작으면 시행 
            answer += 1 
            last = value # 그리고 아까 그 값으로 업데이트 
    
    return answer


# 해설
'''
홍박사가 허락해준 N마리 포켓몬 중 N/2마리를 데려갈 수 있다. 
ex) 총 4마리 -> [3, 1, 2, 3]이면 3번은 2마리, 1번과 2번은 1마리
가질 수 있는 경우의 수 6가지 
1. 첫 번째(3번), 두 번째(1번) 폰켓몬을 선택
2. 첫 번째(3번), 세 번째(2번) 폰켓몬을 선택
3. 첫 번째(3번), 네 번째(3번) 폰켓몬을 선택 -> 이거는 한 종류만 가짐 
4. 두 번째(1번), 세 번째(2번) 폰켓몬을 선택
5. 두 번째(1번), 네 번째(3번) 폰켓몬을 선택
6. 세 번째(2번), 네 번째(3번) 폰켓몬을 선택
=> 가질 수 있는 종류 수의 최대값은 2 
'''
