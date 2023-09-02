# 수식 입력받아서 큰 결과값 출력 
a, b = map(str, input().split())

aresult = eval(a)
bresult = eval(b)

if aresult > bresult : 
	print(aresult)
else : 
	print(bresult)


################## 해설
# eval() : 우선순위가 있는 수식을 편리하게 계산해주는 함수 
# 두 줄이면 끝난다;;; 
A, B = input().split()
print(max(eval(A), eval(B))) 

