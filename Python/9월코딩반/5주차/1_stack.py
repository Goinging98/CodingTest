# 스택 개념에 대해서 알기

# 스택 : LIFO 후입선출 자료구조 
# push : 원소 추가
# pop : 가장 최근에 추가된 원소 제거 

# list로 스택 연산 가능
# list.append() -> push
# list.pop() -> pop 

# 이렇게 쓰면 됩니다. 
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
S = []

for _ in range(N) :
	op = input().rstrip().split()
	if op[0] == "push" :
		if len(S) < K: 
			S.append(int(op[1]))
		else :
			print("Overflow")
	else :
		if S : 
			print(S.pop())
		else: 
			print("Underflow")
