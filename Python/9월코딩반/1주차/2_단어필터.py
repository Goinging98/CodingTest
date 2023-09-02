# 메시지 E 안에 단어 S가 있다면, 가장 앞에 등장하는 단어 S부터 순차적으로 제거하기 
sn, en = map(int, input().split())
s = input()
e = input()

while s in e :
	e = e.replace(s, "")
if not e :
	print("EMPTY")
else : 
	print(e)
