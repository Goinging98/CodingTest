# 내 풀이
# 소수 찾기를 def로 만들어서 돌렸더니 테스트 케이스는 통과함
# 제출 시, Timeout 걸리는 에러 존재 -> 질문 완료 
n = int(input())
a = list(map(int, input().split()))
total = 0

def is_prime(x):
	#2부터 x-1까지의 list
	for i in range(2,x): 
		if x % i != 0:
			pass
		else: 
			return False 
	return True
	# if b > 0:
	# 	c = False
	# else:
	# 	c = True
	# return c


for i in range(1,n):
	if is_prime(i+1) == True :
		total += a[i]
print(total)

############## 해설 
