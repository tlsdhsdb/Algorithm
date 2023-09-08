def hanoi(num,start,mid,end,answer):
    if num == 1:
        return answer.append([start,end])
    hanoi(num-1,start,end,mid,answer)
    answer.append([start,end])
    hanoi(num-1,mid,start,end,answer)
    
def solution(n):
    answer = []
    hanoi(n,1,2,3,answer)
    return answer

