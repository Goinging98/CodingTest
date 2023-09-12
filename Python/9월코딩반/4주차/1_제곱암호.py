# 제곱암호
# 암호문 길이가 N이면 N/2개의 숫자와 N/2개의 알파벳 소문자로 이루어짐
# 암호 길이는 항상 짝수
# 암호문 첫 글자는 항상 알파벳 소문자. 이후로는 숫자와 알파벳 번갈아가면서
# 복호화 : 첫 번째 문자는 문장의 가장 왼쪽 문자를 의미
# i가 홀수일 때, 암호문의 i번째 문자를 알파벳의 사전 기준 다음 문자로 바꾸는 작업을 암호희 i번째 숫자의 제곱번 시행한다. 
# z에서 사전 기준 다음 문자로 바뀌면 a로 바뀐다. 
# 복호화 끝난 뒤 원문은 N/2의 길이의 알파벳 소문자로만 이루어진 문자열 

# 아스키코드 
# 문자를 숫자로 ord / 숫자를 문자로 chr 

# 내 풀이 
# 이렇게 하면 문제점이 제곱한 값이 26을 몇 번이고 넘으면 안 된다는 것 
# 그래서 에러 뜸 
n = int(input())
s = input()

for i in range(int(n/2)) :
	num = ord(s[2*i])
	total = num + (int(s[2*i+1])**2)
	if total > 122 :
		total = total - 26
	else : 
		total = total 		
	word = chr(total)
	print(word, end = '')


# 풀이
n = int(input())
s = input()
res = ''

for i in range(0, n, 2) :
	c = s[i]
	n = int(s[i+1])
	# 26으로 나눠서 더해주기 
	d = chr((ord(c) - ord('a') + n*n) % 26 + ord('a'))
	res += d 
print(res)
