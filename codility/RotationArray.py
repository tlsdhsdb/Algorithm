from collections import deque

def solution(A, K):
    que = deque(A)

    que.rotate(K)

    return list(que)

answer = solution([3, 8, 9, 7, 6], 3)
print(answer)
