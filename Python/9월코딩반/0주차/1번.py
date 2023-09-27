# 해답
from collections import defaultdict
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
cnt = defaultdict(int)
for _ in range(M):
    events = list(map(int, input().split()))
    for e in events[1:]:
        cnt[e] += 1

ans = []
res = sorted(cnt.items(), key=lambda x: (x[1], x[0]), reverse=True)
ans.append(res[0][0])

for i in range(1, len(res)):
    if res[i - 1][1] != res[i][1]:
        break
    ans.append(res[i][0])
    
print(*ans)


# 해설
'''
주어지는 사용자 활동을 바탕으로 가장 많이 등장한 이벤트의 개수를 샌다.

# defaultdict 사용해보기
- 기본값이 존재하는 dict
- 새로운 key값이 들어올 때, 값 초기화를 하지 않고 바로 연산을 수행해도 괜찮다는 장점
'''
# 이렇게 사용한다. 
from collections import defaultdict

events = [4, 10, 100, 1000, 100000]
cnt = defaultdict(int)
for e in events[1:]:
    cnt[e] += 1


# 정렬
# dict.items() : (key, value) 쌍 반환하는 메소드 
res = sorted(cnt.items(), key=lambda x: (x[1], x[0]), reverse=True)
# value에 해당하는 값이 큰 순으로, value가 같으면 key에 해당하는 값이 큰 순으로 정렬 
