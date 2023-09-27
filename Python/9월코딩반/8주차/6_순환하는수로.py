# 정점의 수와 간선의 수가 같은 특수한 형태의 그래프

# 문제의 요구사항
'''
- N개의 물탱크 / N개의 수로
- 모든 물탱크는 수로로 연결
- 수로는 서로 다른 물탱크를 연결, 한 물탱크 쌍을 연결하는 수로는 최대 하나
- 사이클에 포함되어 있는 물탱크 찾기 
- 특이한 요구사항 : 물탱크, 수로 개수가 똑같다.
'''

'''
정점과 간선의 수가 같은 특수한 형태의 그래프
- 그래프는 정확히 하나의 사이클을 가지는 그래프가 된다.
- 트리를 이용하면 된다.
'''

# DFS로 사이클 찾기 
'''
핵심 접근 : 어떤 정점에서 DFS를 시작하던 간에 사이클이 포함되는 경로를 만나게 된다.
- 사이클이 포함된다 -> 바로 직전 정점을 제외하고 이미 방문한 정점에 도달할 수 있다는 것과 동일 
- 항상 사이클의 시작점이 현재 방문한 정점 중 하나를 이용하면 
스택을 이용해서 현재 방문한 정점을 저장한 뒤, 사이클 시작점이 나올 때까지 원소를 빼주는 방식으로 구할 수 있다.
- 시간복잡도 O(N+M) 
'''


# 해답
import sys
input = sys.stdin.readline

N = int(input())
G = [[] for _ in range(N + 1)]
V = [0 for _ in range(N + 1)]
for _ in range(N):
    u, v = map(int, input().split())
    G[u].append(v)
    G[v].append(u)

# 현재 방문한 정점을 기록하는 스택입니다.
ST = []
# 사이클의 시작점을 의미하는 변수입니다.
start = -1

def DFS(cur, prev):
    global start
    ST.append(cur)
    for next in G[cur]:
        if start != -1:
            return
        # 바로 직전 정점과는 사이클을 이룰 수 없으므로, 예외처리를 해줘야 합니다.
        if next == prev:
            continue
        # 다음 정점이 이미 방문한 정점인 경우, 해당 정점을 사이클의 시작점으로 설정하고 DFS를 탈출합니다.
        if V[next]:
            start = next
            return
        V[next] = 1
        DFS(next, cur)
    # 사이클의 시작 정점을 찾은 경우, 방문한 정점 목록을 보존해야 하므로 DFS를 더 수행하면 안 됩니다.
    if start != -1:
        return
    ST.pop()

V[1] = 1
DFS(1, 0)

# 현재 스택에는 사이클을 이루는 경로가 역순으로 저장되어 있습니다.
# 사이클의 시작 정점이 보일 때까지 스택에서 원소들을 뽑아줍니다.
ans = []
while 1:
    ans.append(ST[-1])
    ST.pop()
    if ans[-1] == start:
        break
    
ans.sort()
print(len(ans))
print(*ans)
