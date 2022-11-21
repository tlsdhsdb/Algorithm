arr = list(map(int,input().split()))

chess = [1,1,2,2,2,8]
answer = []

for i,j in zip(chess,arr):
    if i-j != 0:
        answer.append(i-j)
    else :
        answer.append(0)

print(' '.join(map(str,answer)))