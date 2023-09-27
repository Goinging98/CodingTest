# 다이나믹 프로그래밍 
# 3차원 DP

# 해답
import sys
input = sys.stdin.readline

INF = 1004

N = int(input())
C = [[0]*(N+2) for _ in range(N+2)]
D = [[[INF]*(N+2) for _ in range(N+2)] for _ in range(4)]
for i in range(1, N+1):
    line = input().strip()
    for j in range(1, N+1):
        if line[j-1] == '1':
            C[i][j] = 1

for i in range(1, N+1):
    for j in range(1, N+1):
        D[0][i][j] = 0 if C[i][j] else D[0][i][j-1]+1
    for j in range(N, 0, -1):
        D[1][i][j] = 0 if C[i][j] else D[1][i][j+1]+1
for j in range(1, N+1):
    for i in range(1, N+1):
        D[2][i][j] = 0 if C[i][j] else D[2][i-1][j]+1
    for i in range(N, 0, -1):
        D[3][i][j] = 0 if C[i][j] else D[3][i+1][j]+1

for i in range(1, N+1):
    for j in range(1, N+1):
        ans = min(D[k][i][j] for k in range(4))
        if ans >= INF:
            ans = -1
        print(ans, end=' ')
    print()



# 해설
# 데이터 입력받기
# 1. 0으로 초기화한 2차원 배열 선언
# 2. 입력받은 문자열에서 1인 요소가 등장하면, 타일 값을 1로 바꾸기
import sys
input = sys.stdin.readline

N = int(input())
Matrix = [[0]*(N+2) for _ in range(N+2)]
for i in range(1, N+1):
    line = input().strip()
    for j in range(1, N+1):
        if line[j-1] == '1':
            Matrix[i][j] = 1

for i in Matrix:
	print(i)

# 기본적인 탐색 구현하기
# 임의의 타일 좌표 Matrix[i][j]
# 선택된 타일에서 단순하게 세로, 가로 1인 경우 찾아서 길이 짧으면 거리 갱신, 아니면 계속 탐색
# 임의의 좌표
x = 2
y = 1
print(Matrix[x][y])

#상, 하 탐색
distance = INF
for i in range(1, N+1):
    if Matrix[i][y] == 1:
        if distance > abs(i-x):
            distance = abs(i-x)

# 좌, 우 탐색
for j in range(1, N+1):
    if Matrix[x][j] == 1:
        if distance > abs(j-y):
            distance = abs(j-y)
print(distance)


# 완전 탐색으로 구현
# timeout 되기 때문에 동적 프로그래밍으로 해결
import sys
input = sys.stdin.readline
INF = 1004
N = int(input())
Matrix = [[0]*(N+2) for _ in range(N+2)]
for i in range(1, N+1):
    line = input().strip()
    for j in range(1, N+1):
        if line[j-1] == '1':
            Matrix[i][j] = 1

# 모든 좌표 탐색
for x in range(1, N+1):
    for y in range(1, N+1):
        distance = INF
				# 상, 하 탐색
        for i in range(1, N+1):
            if Matrix[i][y] == 1:
                if distance > abs(i-x):
                    distance = abs(i-x)

        # 좌, 우 탐색
        for j in range(1, N+1):
            if Matrix[x][j] == 1:
                if distance > abs(j-y):
                    distance = abs(j-y)
        if distance == 1004:
            distance = -1
        print(distance, end = ' ')
    print()


# 동적 프로그래밍 적용
# 같은 계산을 하지 않는 매력 
A = 10
B = 5
# A가 10이면, result에 0을 할당하고, 아니면 5을 할당해라. 
result = 0 if A == 10 else 5
print(result)
# B가 10이면, result에 0을 할당하고, 아니면 5을 할당해라. 
result = 0 if B == 10 else 5
print(result)

# 이렇게 하는 방법을 바탕으로 DP코드 작성
DP = [[[INF]*(N+2) for _ in range(N+2)] for _ in range(4)]

# dp 갱신
# 좌, 우 DP 갱신
for i in range(1, N+1):
    for j in range(1, N+1):
        D[0][i][j] = 0 if C[i][j] else D[0][i][j-1]+1
    for j in range(N, 0, -1):
        D[1][i][j] = 0 if C[i][j] else D[1][i][j+1]+1
# 상, 하 DP 갱신
for j in range(1, N+1):
    for i in range(1, N+1):
        D[2][i][j] = 0 if C[i][j] else D[2][i-1][j]+1
    for i in range(N, 0, -1):
        D[3][i][j] = 0 if C[i][j] else D[3][i+1][j]+1


# 4개의 dp 중 가장 작은 값 찾기
for i in range(1, N+1):
    for j in range(1, N+1):
				# 방향 DP의 값 중 가장 작은 값을 ans에 할당한다.
        ans = min(D[k][i][j] for k in range(4))
        if ans >= INF:
            ans = -1
        print(ans, end=' ')
    print()












