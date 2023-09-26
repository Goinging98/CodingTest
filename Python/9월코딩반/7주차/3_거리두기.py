# 다이내믹 프로그래밍
# Top-down : 큰 문제를 작은 문제로 쪼개기
# Bottom-up : 작은 문제를 조합해서 큰 문제 해결하기

# N*3 줄
# 윗줄의 배치에 따라서 맨 아래 줄의 가능한 배치의 경우의 수가 정해진다
# dp[i][j] : i번째 줄까지 고려했고 맨 아래 줄의 스티커 배치 상태가 j일 때 가능한 경우의 수

# 최종적으로 구하는 값 
# dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4]
# 상태의 개수 = O(n)
# 각 상태에서 다른 상태로 전이ㅏ는데 드는 시간 = O(1)
# 총 시간복잡도 : O(n) 

# 해답 
n = int(input())
dp = [[0 for _ in range(5)] for _ in range(n+1)]

dp[0][0] = 1
mod = 100000007

for i in range(1, n+1) :
    dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % mod
    dp[i][1] = (dp[i - 1][0] + dp[i - 1][2] + dp[i - 1][3]) % mod
    dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][4]) % mod
    dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod
    dp[i][4] = (dp[i - 1][0] + dp[i - 1][2]) % mod

print(sum(dp[n]) % mod)
