# 그리디 알고리즘로 유명한 회의실 배정 문제
# 타운 홀에 시간이 겹치지 않게 최대한 많은 행사를 열기
# 어떤 행사를 열지 말지를 완전 탐색 시, 경우의 수 2^N가지
# 그럴 때는 행사 선택 기준 세워보기 
'''
1. 시작 시간이 빠른 순
2. 행사 시간이 짧은 순
3. 종료 시간이 빠른 순 -> 이게 그리디한 방법 
그래서 이 방법을 써서 독립성과 최적 풀이 방법을 보장해서 식이 쓰인다. 
'''


import sys 
input = sys.stdin.readline

N = int(input())
events = []

for _ in range(N) :
	s, e = map(int, input().split())
	events.append([s, e])
	
events.sort(key = lambda x : (x[1], x[0]))
count = end = 0
for s, e in events:
	if s>end : 
		count += 1
		end = e
		
print(count)
