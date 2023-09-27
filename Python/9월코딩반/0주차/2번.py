## Code-Review 수정 코드


'''
기존 코드
# 일단 미궁을 구현하자.
N, K = map(int, input().split())
orders = list(input())

M = []
for i in range(N):
	tmp = list(map(int, input().split()))
	M.append(tmp)
	if 1 in tmp:
		j = tmp.index(1)
		c_point = [i, j]
# 겸사겸사 시작점에 현재위치인 c_point를 배치해 두자.

# 일단 총 움직임 변수 t_counter을 선언하고
t_counter = 0
true_counter = []

# 바로 루프돌려버리기
for command in orders:
	# U 명령어
	if command == "U":
		# M 밖으로 벗어나면 멈춤
		if c_point[0] - 1 < 0:
			continue
		# 3에 부딫히면 멈춤
		if M[ c_point[0] - 1 ][ c_point[1] ] == 3:
			continue
		# 멈추지 않았다면 일단 카운터 하나 올리고 현재위치(c_point)를 위로 한칸 이동
		else:
			t_counter += 1
			c_point[0] -= 1

	# D 명령어
	if command == "D":
		if c_point[0] + 1 > 3:
			continue
		if M[ c_point[0] + 1 ][ c_point[1] ] == 3:
			continue
		else:
			t_counter += 1
			c_point[0] += 1

	# L 명령어
	if command == "L":
		if c_point[1] - 1 < 0:
			continue
		if M[ c_point[0] ][ c_point[1] - 1 ] == 3:
			continue
		else:
			t_counter += 1
			c_point[1] -= 1

	# R명령어
	if command == "R":
		if c_point[1] + 1 > 3:
			continue
		if M[ c_point[0] ][ c_point[1] + 1 ] == 3:
			continue
		else:
			t_counter += 1
			c_point[1] += 1
	# 명령받은 이후 그 위치가 2면 true_counter에 t_counter값을 append한다.
	# 대입하지 않는 이유는 2에 여러번 도착할까봐...
	if M[ c_point[0] ][ c_point[1] ] == 2:
		true_counter.append(t_counter)
# 결과 출력
if true_counter == []:
	print("FAIL")
else:
	print(f"SUCCESS {true_counter[0]}")
'''
# 입출력 간소화

import  sys
input = sys.stdin.readline

N, K = map(int, input().split())
# 공백처리로 .rstrip() 추가
orders = list(input().rstrip())

# M =>  Matrix
M = list()
# c_point => 시작지점
c_point = list()
for i in range(N):
    tmp = list(map(int, input().split()))
    M.append(tmp)
    # 시작 지점 추출 Good
    if 1 in tmp:
        j = tmp.index(1)
        c_point = [i, j]

# 이동 횟수를 센다.
t_counter = 0
true_counter = []
x, y = c_point
print(x, y)
for command in orders:
    # 다음 탐색 지점 갱신
    if command == "U":
        x -= 1
    elif command == "D":
        x += 1
    elif command == "L":
        y -=1
    else:
        y += 1
    # 범위 & 지나가지 못하는 벽 검사
    if 0 <= x < N and 0 <= y < N :
        if M[x][y] != 3:
            # 시뮬레이션 종료와 비종료 조건
            if M[x][y] == 2:
                t_counter += 1
                true_counter.append(t_counter)
            else:
                t_counter += 1
print(true_counter)
if true_counter == []:
    print("FAIL")
else:
    print(f"SUCCESS {true_counter[0]}")




# 해설
'''
2차원 배열 구현 문제로 어렵지 않다. 
요구사항
- 명령어에 따라서 이동한다.
- 명령어를 수행하지 못하면, 이동하지 않는다.
- 미로에 탈출 가능한지 확인하고, 탈출하면 탈출까지 몇번 이동했는지 출력
'''
# Data 핸들링 : 입출력을 직접 구현하면 입력을 받으면서 필요 정보를 찾거나 제거 가능
import sys
input = sys.stdin.readline
# 배열의 크기 N, 명령어의 개수 K
N, K = map(int, input().split())
# 명령어 List
commands = list(input().rstrip())
# Matrix 리스트
Matrix = list()
# 시작 위치를 저장하는 리스트
start_Point = []
for i in range(N):
    temp = list(map(int, input().split()))
    Matrix.append(temp)
    # 시작 위치를 찾으면 저장하기
    if 1 in temp:
        start_Point = [i, temp.index(1)]


# 방향 구현하기
dir = {
    "U" : [-1, 0],
    "D" : [1, 0],
    "L" : [0, -1],
    "R" : [0, 1],
}
print(dir["U"])
print(dir["D"])
print(dir["L"])
print(dir["R"])


# 이동 구현하기
# 종료 지점까지 도착했는가?
# 시작 좌표, 종료 지점 도착 여부, 이동 횟수
x, y = start_Point
flag = True
move_count = 0

# 명령어대로 잘 이동하는가
# 명령어를 불러어고, dir에서 방향을 불러와서 다음 x, y 좌표를 지정함.
for command in commands:
    nx = x + dir[command][0]
    ny = y + dir[command][1]


# 탐색 조건에 대한 구현
for command in commands:
    nx = x + dir[command][0]
    ny = y + dir[command][1]
    if 0 <= nx < N and 0 <= ny < N:
        if Matrix[nx][ny] == 3:
            continue
        elif Matrix[nx][ny] == 2:
            flag = False
            move_count += 1
            break
        else:
            x = nx
            y = ny
            move_count += 1


# flag 상태에 따라 출력 
if flag:
    print("FAIL")
else:
    print("SUCCESS %d"%(move_count))

