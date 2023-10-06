def solution(s):
    stack = [] 
    for i in s :
        if i == "(" :
            stack.append(i)
        else : # )이 들어올 때! 
            if stack == [] : #스택이 빌 때 들어오면 False 
                return False
            else : # 아니면 제거. 그래서 여러 개 들어와도 계속 남아있으니 없을 때까지  
                stack.pop()
    return stack == [] # 비면 true, 아니면 false 
