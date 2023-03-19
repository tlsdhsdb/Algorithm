def solution(N,A):
    maxi = 0
    maximum = 0
    counter = [0]*N

    for i in range(len(A)):
        if A[i] <= N :
            if maxi > counter[A[i]-1]:
                counter[A[i]-1] = maxi
            counter[A[i]-1] += 1
            maximum = max(counter[A[i]-1],maximum)
        else:
            maxi = maximum
    for i in range(N):
        if counter[i] < maxi:
            counter[i] = maxi

    return counter

answer = solution(5, [3, 4, 4, 6, 1, 4, 4])
print(answer)