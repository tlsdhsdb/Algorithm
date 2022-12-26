from sys import stdin

N = int(stdin.readline())
arr = []


for i in range(N):
    arr.append((int(stdin.readline()),i))

sorted_arr = sorted(arr)
answer = 0

for i in range(N):
    if answer < sorted_arr[i][1] - i:
        answer = sorted_arr[i][1] - i

answer = answer + 1

print(answer)