# 수식 입력받아서 큰 결과값 출력 
a, b = map(str, input().split())

aresult = eval(a)
bresult = eval(b)

if aresult > bresult : 
	print(aresult)
else : 
	print(bresult)
