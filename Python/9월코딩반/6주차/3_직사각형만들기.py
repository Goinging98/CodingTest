# 그리디 알고리즘
# 직사각형 많이 만들기

# 막대기 쌍 길이 a<=b<=c<=d 
# -> 길이가 짧은 막대기 쌍 두개와 길이가 긴 막대기 쌍 두개를 짝지어주는 것이 최적

# 복잡한 경우의 확장
# 막대기 쌍의 길이가 긴 것부터 순서대로 직사각형을 만들어주면 된다. 

import sys
input = sys.stdin.readline

N = int(input())
pair = [] #저장용 배열 

cnt = [0 for _ in range(1000001)] #최대 개수까지 0을 가짐 
sticks = map(int, input().split())

for stick in sticks : # 해당 길이가 있는 것에 대해서 +1 해줌 
	cnt[stick] +=1 

for length in range(1, 1000001) : # 2개 있는 한 막대기에 대해서 사용하면 없애줌  
	while cnt[length] > 1:
		cnt[length] -= 2
		pair.append(length)
	
pair.sort(reverse = True)
ans = 0
for i in range(1, len(pair), 2) :
	ans += pair[i-1] * pair[i]
	
print(ans)
