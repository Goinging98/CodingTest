# BFS 최단거리
from collections import deque
import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())
g = [[] for _ in range(n + 1)]
for _ in range(m):
	u, v = map(int, input().split())
	g[u].append(v)
	g[v].append(u)
	
d = [9**9 for _ in range(n+1)]
d[1] = 0
q = deque()
q.append(1)

while q : 
	cur = q.popleft()
	for next in g[cur] :
		if d[next] <= d[cur] + 1:
			continue
		d[next] = d[cur] + 1
		q.append(next)

if d[n] <= k :
	print("YES")
else :
	print("NO")
  
