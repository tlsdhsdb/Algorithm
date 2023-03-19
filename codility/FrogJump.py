# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(X, A):
    s = set([])

    for i in range(len(A)):
        s.add(A[i])
        if len(s) == X:
            return i

    return -1



answer = solution(5, [1, 3, 1, 4, 2, 3, 5, 4])
print(answer)