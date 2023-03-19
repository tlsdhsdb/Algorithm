def solution(N):

    binary = bin(N)[2:]
    answer = []
    cnt = 0
    for i in binary:
        if i == "1":
            answer.append(cnt)
            cnt = 0
        elif i == "0":
            cnt += 1
    return max(answer)

arr = [1041,15]


for i in arr :
    answer = solution(i)
    print(answer)