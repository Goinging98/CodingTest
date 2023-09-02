a, b, c, d = map(int, input().split())
data = []
data.append(a)
data.append(b)
data.append(c)
data.append(d)
data.sort()

print(abs(data[3]-data[0])+abs(data[2]-data[1]))
