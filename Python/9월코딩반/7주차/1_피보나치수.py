# 다이나믹 프로그래밍
# 피보나치 수열 : 첫 두 항은 1, 1이고 나머지 항은 이전 두개의 항을 더한 값으로 정의되는 수열

# 재귀적으로 구하기 -> fib(n) 함수
def fib(n):
    if n <= 2:
        return 1
    return (fib(n - 1) + fib(n - 2)) % 1000000007
# 근데 재귀적으로 풀면 호출되는 함수 수가 두배로 늘어난다.
# 시간복잡도 O(2^N) = 큰 n값에서 작동 x

# 그래서 이럴 때는 어떤 부분 문제를 해결한 뒤 그 문제 답을 저장한 뒤, 필요할 때 가지고 오는 
# 다이내믹 프로그래밍을 사용한다. 

# 방법1
N = int(input())
fib = [1, 1]
for i in range(100000):
    fib.append((fib[-1] + fib[-2]) % 1000000007)
print(fib[N - 1])


# 방법2
import sys
sys.setrecursionlimit(111111)

# 이 정해 코드를 그냥 실행하면 스택 메모리 제한으로 인해 일부 테스트 케이스를 통과하지 못합니다.
# 아래 주석 처리된 코드와 같이 실행하면, 스택 메모리 제한을 임시적으로 조금 늘려서 문제를 해결할 수 있습니다.
# 시스템에 직접 접근하는 코드이므로, 일반적으로 코딩 테스트를 응시할 때는 사용하면 안되는 코드입니다!!

'''
import resource
resource.setrlimit(resource.RLIMIT_STACK, (64 * 1024 * 1024, -1))
'''
MOD = 10**9 + 7
F = [-1 for _ in range(100008)]

def fib(n):
    if F[n] != -1:
        return F[n]
    if n <= 2:
        return 1
    F[n] = (fib(n - 1) + fib(n - 2)) % MOD
    return F[n]
    
N = int(input())
print(fib(N))
