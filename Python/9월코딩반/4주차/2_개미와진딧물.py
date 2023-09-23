# 구현, 완전탐색
# 맨해튼 거리 
# (a,b), (c,d) 이면 두 지점 사이 거리는 |a-c|+|b-d|

# 맨해튼 거리 상에서 진딧물로부터 거리 M 이하에 위치한 개미의 수 구하기
# 마름모 형태의 땅이 된다.
# 마름모 영역에 해당하는 땅은 O(M^2)개이니, 시간복잡도는 O(N^2*M^2) 
# 중간과정 
N, M = map(int, input().split())
ground = []
for i in range(N):
    ground.append(list(map(int, input().split())))
    
def Search(y, x, M):
    # 윗 부분 탐색
    for dy in range(-M, 0):
        for dx in range(-M - dy, M + dy + 1):
            if y + dy < 0 or N <= y + dy or x + dx < 0 or N <= x + dx:
                continue
            if ground[y + dy][x + dx] == 2:
                return True
    # 아랫 부분 탐색
    for dy in range(M + 1):
        for dx in range(dy - M, M - dy + 1):
            if y + dy < 0 or N <= y + dy or x + dx < 0 or N <= x + dx:
                continue
            if ground[y + dy][x + dx] == 2:
                return True
    # 주어진 범위 내에서 진딧물을 발견하지 못했을 때
    return False

ans = 0
for i in range(N):
    for j in range(N):
        # 개미에 해당하는 칸일 때만 탐색을 진행합니다.
        if ground[i][j] == 1:
            # (i, j) 칸을 중심으로 M칸 이내인 칸들을 탐색해봅니다.
            if Search(i, j, M):
                ans += 1

print(ans)


# 좌표만 추출하기 
# ants : 개미가 있는 칸 저장 배열
# aphids : 진딧물이 있는 칸 저장 배열 
N, M = map(int, input().split())
ants, aphids = [], []
for i in range(N):
    s = list(map(int, input().split()))
    for j in range(N):
        if s[j] == 1:
            ants.append([i, j])
        elif s[j] == 2:
            aphids.append([i, j])

# 시간복잡도 O(N^4) 이지만 상수가 안 커서 괜춘 
ans = len(ants)
for y1, x1 in ants:
    min_dist = 9 ** 9
    for y2, x2 in aphids:
        dist = abs(y1 - y2) + abs(x1 - x2)
        min_dist = min(min_dist, dist)
    if min_dist > M:
        ans -= 1

print(ans)


# 해답 
N, M = map(int, input().split())
ants, aphids = [], []
for i in range(N):
    s = list(map(int, input().split()))
    for j in range(N):
        if s[j] == 1:
            ants.append([i, j])
        elif s[j] == 2:
            aphids.append([i, j])

ans = len(ants)
for y1, x1 in ants:
    min_dist = 9 ** 9
    for y2, x2 in aphids:
        dist = abs(y1 - y2) + abs(x1 - x2)
        min_dist = min(min_dist, dist)
    if min_dist > M:
        ans -= 1

print(ans)
