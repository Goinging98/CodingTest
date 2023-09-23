# 스택 사용해서 풀기 
# 뿌요를 터트릴 때, 마지막 원소 참조하면 IndexError 가능
# 이를 방지하기 위해서, 더미 데이터 넣어서 스택이 비지 않게 해주기
# 대신 더미 데이터는 출력 x

# 해답
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
S = input().rstrip()
Q = []
Q.append(('', 1))

S += 'z'
for c in S:
    if Q[-1][0] != c:
        if M <= Q[-1][1]:
            top = Q[-1][0]
            while top == Q[-1][0]:
                Q.pop()
    if Q[-1][0] == c:
        Q.append((c, Q[-1][1] + 1))
    else:
        Q.append((c, 1))
Q.pop()

if len(Q) > 1:
    for c, n in Q:
        print(c, end='')
else:
    print("CLEAR!")
