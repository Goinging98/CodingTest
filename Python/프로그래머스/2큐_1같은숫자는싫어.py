def solution(arr):
    
    answer = []
    
    for i in range(len(arr)):
        if i == 0 :
            answer.append(arr[i])
        elif arr[i] != arr[i-1] :
            answer.append(arr[i])
        
    return answer


# 비교적 간단하게 품 
# 처음꺼는 append. 그 뒤로는 바로 앞뒤 비교하면 됨 
