# 문자열 S가 대문자라면 소문자로, 소문자라면 대문자로 바꾸기 
# 내 풀이 
num = int(input())
word = input()

for i in word :
	if i.isupper():
		i = i.lower()
	else :
		i = i.upper()
	print(i, end="")



############ 해설 
# input()은 입력받은 문자열을 문자 단위로 하나씩 읽기 때문에 느리다.
# 그래서 입력이 많은 문제를 풀 때는 sys.stdin.readline() 함수 사용
import sys 
input = sys.stdin.readline
# 이렇게 하면 개행 문자를 포함해서 문자열 자료형으로 변수에 포함되어 저장된다.
# 그래서 input().rstrip() 등으로 개행 문자를 바로 제거한다. 
N = int(input())
S = input().rstrip()
print(S.swapcase())
# swapcase() 메소드를 사용하면 소문자는 대문자로, 대문자는 소문자로 바뀐다. 
