n = int(input())
s = list(map(int, input().split()))
i = 0
total = 0 

for i in range(n):
	total += s[i]

print(format(total, 'o'))
