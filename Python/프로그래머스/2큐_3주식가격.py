from collections import deque 

def solution(prices):
    queue = deque(prices)
    answer = []
    
    while queue:
        price = queue.popleft()
        sec = 0
        for q in queue :
            sec += 1
            if price > q:
                break
        answer.append(sec)
    
    return answer


# 해설
# prices를 queue로 초기화해서 반복문 돌면서 앞에서부터 하나씩 popleft해서 
# 남은 queue를 순회하며 값이 작아지기 전까지 초를 증가시키는 것을 queue가 빌때까지 반복

