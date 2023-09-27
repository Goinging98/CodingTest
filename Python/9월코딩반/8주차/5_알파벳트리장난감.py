# 트리 / DFS
# 특수한 형태의 그래프에서, 특정 정점에서 출발하는 경로 중 점수의 합이 가장 큰 경로와 가장 작은 경로 찾기
# 트리라서 탐색 경로 수가 그렇게 많지 않다. 

# 해답
import sys
input = sys.stdin.readline

N = int(input())
S = [[] for _ in range(N + 1)]
for i in range(1, N + 1):
    S[i] = input().rstrip()
ans1, ans2 = 9**9, 0

def DFS(h, n, score):
    score += ord(S[h][n]) - ord('A') + 1
    if h < N:
        DFS(h + 1, n * 2, score)
        DFS(h + 1, n * 2 + 1, score)
    else:
        global ans1, ans2
        ans1 = min(ans1, score)
        ans2 = max(ans2, score)
    
DFS(1, 0, 0)
print(ans1, ans2, sep='\n')
