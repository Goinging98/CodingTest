# NxM 합 모두 구하기 
# 2차원 배열로 입력받아서 해결하기 
import sys 
input = sys.stdin.readline

n, k = map(int, input().split())
bomb_cnt = [[0 for _ in range(n+1)] for _ in range(n+1)]
# 십자가 모양으로 +1 되는 좌표 
dy = [-1, 0, 0, 1]
dx = [0, -1, 1, 0]

for _ in range(k) :
	y, x = map(int, input().split())
	bomb_cnt[y][x] += 1
	for i in range(4) :
		ny, nx = y + dy[i], x + dx[i]
		if ny < 1 or nx < 1 or ny > n or nx > n :
			continue
		bomb_cnt[ny][nx] += 1
	
ans = 0
for i in range(1, n+1):
	for j in range(1, n+1):
		ans += bomb_cnt[i][j]
print(ans)



# 초간단 해결법 
# 폭탄 날려주는 범위대로 반복하면서 모서리에 닿을 때만 빼주면 된다. 
ans = 0
for _ in range(K):
    y, x = map(int, input().split())
    ans += 5 - (y == 1) - (y == N) - (x == 1) - (x == N)

