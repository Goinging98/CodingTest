# 수 이어 붙이기
# 완전 탐색, 순열, permutations()
# 중요! : N이 8로 제한되어 있어서 O(NxN!) 풀이도 여유롭다. 

# 순열 : N개 원소 중 K개 원소 고르기. 순서 상관 있다.
# 조합 : N개 원소 중 K개 원소 고르기. 순서 상관 없다.
# -> 선택하는 순서가 중요한지 확인하기 

##################################################################################
# 1. swap 사용 구현 방식 
# 배열 크기 N
# n번 원소까지 순열 위치 고정시, n+1번 원소가 가질 수 있는 값은 n+1 ~ N 사이 값. 
# 하나하나 swap하면서 모든 순열 순회하기 
S = [1, 2, 3]

def Permute(S, n):
    if len(S) == n:
        print(S)
        return
    for i in range(n, len(S)):
        S[n], S[i] = S[i], S[n];
        Permute(S, n + 1)
        S[n], S[i] = S[i], S[n];
    
Permute(S, 0)

'''
OUTPUT
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 2, 1]
[3, 1, 2]
'''

##################################################################################
# 2. 원래 배열 원소는 두고 사용 여부를 나타내는 used 배열 기반 순열 만들기
# 첫 번째 방법과 다르게 새로운 배열 P에 순열이 저장된다.
S = [1, 2, 3]
P = [0 for _ in range(len(S))]
used = [0 for _ in range(len(S) + 1)]

def Permute(S, P, n):
    if len(S) == n:
        print(P)
        return
    for i in range(0, len(S)):
        if used[i]: continue
        used[i] = 1
        P[n] = S[i]
        Permute(S, P, n + 1)
        used[i] = 0
    
Permute(S, P, 0)

'''
OUTPUT
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
'''



##################################################################################
# 사전 순으로 모든 순열을 순회하고자 하면 배열을 정렬해서 두 번째 방식 사용 
N = int(input())
S = list(map(int, input().split()))
P = [0 for _ in range(8)]
used = [0 for _ in range(8)]
ans = 1e18

def Calculate(P):
    ret = P[0]
    for i in range(1, N):
        if ret % 10 == P[i] // 10:
            ret = ret * 10 + P[i] % 10
        else:
            ret = ret * 100 + P[i]
    return ret

def Permute(S, P, n):
    global ans
    if len(S) == n:
        ans = min(ans, Calculate(P))
        return
    for i in range(0, len(S)):
        if used[i]: continue
        used[i] = 1
        P[n] = S[i]
        Permute(S, P, n + 1)
        used[i] = 0
    
Permute(S, P, 0)
print(ans)



##################################################################################
# 내장 라이브러리 순열 사용 하기 : permutations 
from itertools import permutations

A = [1, 2, 3, 4]
for P in permutations(A, 2):
    print(P)

'''
OUTPUT
(4, 1)
(4, 3)
(4, 2)
(1, 4)
(1, 3)
(1, 2)
(3, 4)
(3, 1)
(3, 2)
(2, 4)
(2, 1)
(2, 3)
'''


##################################################################################
# 해답 
from itertools import permutations

N = int(input())
A = list(map(int, input().split()))
A.sort()

ans = 1e18
for order in permutations(A, N):
    cur = order[0]
    for i in range(1, N):
        if cur % 10 == order[i] // 10:
            cur = cur * 10 + order[i] % 10
        else:
            cur = cur * 100 + order[i]
    ans = min(ans, cur)

print(ans)



