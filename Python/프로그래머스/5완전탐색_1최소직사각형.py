def solution(sizes):
    return max(max(x) for x in sizes) * max(min(x) for x in sizes)

# 해설
# sizes에서 큰 것과 작은 것의 최대를 각각 곱하면 된다. 
