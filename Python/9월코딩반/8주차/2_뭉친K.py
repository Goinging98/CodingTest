# 격자 형태의 그래프 탐색

# 2차원 배열 형태로 그래프가 주어질 때
# 배열의 각 칸이 정점에 해당하고, 가로와 세로로 각각 인접한 칸과는 간선이 이어져있는 것처럼 생각가능

# 연결 요소 
# 원래 그래프의 일부 정점과 간선만을 골라서 만든 부분 그래프 중, 
# 다른 부분 그래프에 포함되지 않는 가장 큰 부분 그래프
# 그래서 같은 연결 요소에 속한 정점들끼리는 서로 간선을 통해 이어져 있고,
# 다른 연결 요소에 속한 정점끼리는 서로 이어져 있지 않다. 

# 그래프 탐색으로 연결 요소 세기 
# BFS로 구현하기 
# 1. 탐색에 필요한 값을 먼저 선언하기 
K = M[Y][X]		    # 탐색할 칸의 값을 의미합니다.
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
ans = 0

# 2. 모든 칸을 둘러보면서, 현재 방문하지 않았고 값이 K인 칸에서 그래프 탐색 수행 
for i in range(1, N + 1):
    for j in range(1, N + 1):
        if V[i][j] or M[i][j] != K:
            continue
        Q = deque()
        V[i][j] = 1
        cnt = 0 # 현재 연결 요소에 있는 정점의 개수입니다.
        Q.append([i, j])
        while Q:
            cy, cx = Q.popleft()
            cnt += 1 # 새로운 정점을 방문할 때마다 연결 요소에 있는 정점 개수를 하나 증가시킵니다.
            for k in range(4):
                ny, nx = cy + dy[k], cx + dx[k]
                if ny < 1 or nx < 1 or ny > N or nx > N:
                    continue
                if V[ny][nx] or M[ny][nx] != M[cy][cx]:
                    continue
                V[ny][nx] = 1
                Q.append([ny, nx])
        ans = max(ans, cnt)




# 정답 
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
Y, X = map(int, input().split())

M = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
V = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
for i in range(1, N + 1):
    M[i] = [0] + list(map(int, input().split()))
    
K = M[Y][X]
    
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
ans = 0

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if V[i][j] or M[i][j] != K:
            continue
        Q = deque()
        V[i][j] = 1
        cnt = 0
        Q.append([i, j])
        while Q:
            cy, cx = Q.popleft()
            cnt += 1
            for k in range(4):
                ny, nx = cy + dy[k], cx + dx[k]
                if ny < 1 or nx < 1 or ny > N or nx > N:
                    continue
                if V[ny][nx] or M[ny][nx] != M[cy][cx]:
                    continue
                V[ny][nx] = 1
                Q.append([ny, nx])
        ans = max(ans, cnt)

print(ans)


