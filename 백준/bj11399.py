from sys import stdin

N = int(stdin.readline())
arr = list(map(int,stdin.readline().split(" ")))

for i in range(1,N):
    for j in range(i,0,-1):
        if arr[j-1] > arr[j]:
            arr[j-1],arr[j] = arr[j],arr[j-1]

sum_arr = [arr[0]]

for i in range(1,N):
    sum_arr.append(sum_arr[i-1] + arr[i])


print(sum(sum_arr))