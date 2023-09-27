# 시뮬레이션 / 그래프 탐색
# 매 시간 변하는 그래프에서 언제 처음으로 두개 이상의 연결 요소로 그래프가 나뉘어지는지를 구하는 문제
# 모래섬 -> 그래프에서의 연결 요소

# 모래섬 가라앉히는 방법
# sand는 칸의 현재 상태를 나타냅니다.
# update는 해당 칸이 이번 시간에 가라앉아야 하는지를 나타냅니다.
for i in range(N):
    for j in range(M):
        for k in range(4):
            ny, nx = i + dy[k], j + dx[k]
            if ny < 0 or nx < 0 or ny >= N or nx >= M:
                continue
            if not sand[ny][nx]:
                update[i][j] = 1

for i in range(N):
    for j in range(M):
        if update[i][j]:
            sand[i][j] = 0


# 모래섬 개수 세기
N, M = map(int, input().split())
sand = [[0 for _ in range(M)] for _ in range(N)]
for i in range(N):
    info = list(map(int, input().split()))
    for j in range(M):
        sand[i][j] = info[j]
        
checked = [[0 for _ in range(M)] for _ in range(N)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def DFS(cur):
    cy, cx = cur
    for k in range(4):
        ny, nx = cy + dy[k], cx + dx[k]
        # 다음 좌표가 모래섬 안에 있는지 항상 확인해야 합니다.
        if ny < 0 or nx < 0 or ny >= N or nx >= M:
            continue
        if checked[ny][nx] or not sand[ny][nx]:
            continue
        checked[ny][nx] = 1
        DFS([ny, nx])

day = 0
while 1:
    island = 0
    for i in range(N):
        for j in range(M):
            if checked[i][j] or not sand[i][j]:
                continue
            # DFS를 할 수 있다 == 아직 방문하지 않은 새로운 모래섬이 있다는 뜻입니다.
            checked[i][j] = 1
            island += 1
            DFS([i, j])
    
    # 모래섬이 두 개 이상일 때는 답을 출력하고 반복문을 끝냅니다.
    if island > 1:
        print(day)
        break
    # 모든 칸이 물이 될 때까지 답을 못 찾았으면 -1을 출력합니다.
    if island == 0:
        print(-1)
        break
        
    # TODO: 모래 쌓인 칸 줄이기
    
    for i in range(N):
        for j in range(M):
            checked[i][j] = 0
    day += 1



# 모래칸이 물에 가라앉는데 걸리는 시간 : 가라앉은 칸과의 맨해튼 거리 중 최솟값
# = 이 값은 최대 모래섬의 가로 길이와 세로 길이를 더한 값
# 여기서는 최대 100이므로, 길면 200분 

# 해답
import sys
sys.setrecursionlimit(12345)
input = sys.stdin.readline

N, M = map(int, input().split())
sand = [[0 for _ in range(M)] for _ in range(N)]
for i in range(N):
    info = list(map(int, input().split()))
    for j in range(M):
        sand[i][j] = info[j]
        
checked = [[0 for _ in range(M)] for _ in range(N)]
update = [[0 for _ in range(M)] for _ in range(N)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def DFS(cur):
    cy, cx = cur
    for k in range(4):
        ny, nx = cy + dy[k], cx + dx[k]
        if ny < 0 or nx < 0 or ny >= N or nx >= M:
            continue
        if checked[ny][nx] or not sand[ny][nx]:
            continue
        checked[ny][nx] = 1
        DFS([ny, nx])

day = 0
while 1:
    island = 0
    for i in range(N):
        for j in range(M):
            if checked[i][j] or not sand[i][j]:
                continue
            checked[i][j] = 1
            island += 1
            DFS([i, j])
    
    if island > 1:
        print(day)
        exit(0)
        
    if island == 0:
        print(-1)
        exit(0)
        
    for i in range(N):
        for j in range(M):
            for k in range(4):
                ny, nx = i + dy[k], j + dx[k]
                if ny < 0 or nx < 0 or ny >= N or nx >= M:
                    continue
                if not sand[ny][nx]:
                    update[i][j] = 1
                    
    for i in range(N):
        for j in range(M):
            if update[i][j]:
                sand[i][j] = 0
    
    for i in range(N):
        for j in range(M):
            update[i][j] = checked[i][j] = 0
    day += 1

