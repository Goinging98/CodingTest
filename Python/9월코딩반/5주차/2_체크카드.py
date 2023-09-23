# 큐 : 선입선출 FIFO.
# enqueue : deque.append()
# dequeue : deque.popleft(). 들어간지 오래된 원소부터 빼기 

# 사용법 
from collections import deque
Q = deque() # 큐는 처음에 비어있는 상태입니다.
print(Q) 
for i in range(3):
    Q.append(i)
    print(Q)
while Q:
    popped = Q.popleft()
    print(popped, Q)

# 해답
from collections import deque

N, M = map(int, input().split())
Q = deque()

for i in range(M):
    op, cost = input().split()
    cost = int(cost)
    
    if op == "deposit":
        N = N + cost
        # 잔액이 늘어난 뒤에, 현재 대기 목록에 있는 거래가 결제될 수 있는지를 판단합니다.
        # 큐가 비어있는데 큐의 맨 앞 원소에 접근을 하면 IndexError가 뜨므로,
        # 항상 큐의 원소가 들어있는지를 확인하는 과정이 필요합니다.
        while Q and Q[0] <= N:
            # 거래가 가능한 경우에는 거래를 하고, 다시 위의 과정을 반복합니다.
            N = N - Q[0]
            Q.popleft()

    elif op == "pay":
        if N >= cost:
            N = N - cost

    elif op == "reservation":
        if not Q and N >= cost:
            N = N - cost
        else:
            # reservation에서 거래가 실패할 경우에는, 큐에 거래 내역을 추가합니다.
            Q.append(cost)

print(N)
