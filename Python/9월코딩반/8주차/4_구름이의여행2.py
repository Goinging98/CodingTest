# 문제의 요구사항
# N개의 정점과 M개의 간선이 있을 때, K번 정점에서 출발했을 때, K번 정점으로 돌아올 수 있는지 확인하시오.
# 돌아올 수 있다면, 최소 몇 개의 정점을 지나야 하는가


# 최단 거리의 사이클로 만드려면, 두 경로가 모두 시작 정점과 도착 정점을 최단 거리로 잇고 있어야 한다.
# 간선 하나로 이루어진 경로는 당연히 최단 거리
# K에서 np로 이동하는 최단 거리를 알아야 한다.
# BFS를 이용하면 K에서 모든 정점까지의 최단 거리를 ㄱ할 수 있다. 

# 해답
from collections import deque
import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())
G = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    G[a].append(b)
    
D = [9**9 for _ in range(N + 1)]
D[K] = 0
Q = deque()
Q.append(K)
ans = 9**9

while Q:
    cur = Q.popleft()
    for next in G[cur]:
        # n_p에 해당하는 정점을 찾았을 때 답을 갱신합니다.
        if next == K:
            ans = min(ans, D[cur] + 1)
        if D[next] <= D[cur] + 1:
            continue
        D[next] = D[cur] + 1
        Q.append(next)
        
if ans == 9**9:
    print(-1)
else:
    print(ans)
