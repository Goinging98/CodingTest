# 수 이어 붙이기
# 완전 탐색, 순열, permutations()
# 중요! : N이 8로 제한되어 있어서 O(NxN!) 풀이도 여유롭다. 

# 순열 : N개 원소 중 K개 원소 고르기. 순서 상관 있다.
# 조합 : N개 원소 중 K개 원소 고르기. 순서 상관 없다.
# -> 선택하는 순서가 중요한지 확인하기 

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



