# 내 풀이
# 초간단 : 0이 되는 무언가가 있다는 거니까 그냥 다 더하면 됨;;
N = int(input()) 		# 지인 수 N
S = list(map(int, input().split()))		# 점수 리스트 S
total = 0

for i in range(N):
	total += S[i]
print(total)
# print(sum(S)) 로도 가능! 

# 해설
# Hash Table을 dict로 사용가능
# Hash Table : Hash Function을 이용해 Key 값을 정수로 변환해서,
# 변환된 각 정수에 고유한 메모리 주소를 할당해 O(1)의 시간 복잡도에 저장된 값에 접근 가능 자료구조
# 현재 점수와 같으면서 부호가 반대인 수를 O(1) 시간에 판별 가능 
occur = dict()
for i in range(N):
    # 현재 점수가 존재하는지를 occur에 기록해둡니다.
    occur[S[i]] = 1

ans = 0
for i in range(N):
    # 각 점수마다 부호가 반대인 점수 값이 occur에 존재하는지를 확인합니다.
    # key 값이 존재하는 경우에는 소개팅을 진행할 수 있다는 뜻이니, 넘어가줍시다.
    if -S[i] not in occur:
        ans += S[i]     
print(ans)
