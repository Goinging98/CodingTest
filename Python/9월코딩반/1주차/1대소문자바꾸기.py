# 문자열 S가 대문자라면 소문자로, 소문자라면 대문자로 바꾸기 
num = int(input())
word = input()

for i in word :
	if i.isupper():
		i = i.lower()
	else :
		i = i.upper()
	print(i, end="")

