from sys import stdin

N = int(stdin.readline())
arr = list(map(int,stdin.readline().split()))
stack = []
answer = [-1] * N
# -1로 초기화 하면 없는애들은 자동으로 -1 배정

for i in range(N):
    while stack and (arr[i] > arr[stack[-1]]):
        answer[stack.pop()] = arr[i]
        #pop()한 것의 자리에 오큰수가 들어가는 것
    stack.append(i)

print(*answer)