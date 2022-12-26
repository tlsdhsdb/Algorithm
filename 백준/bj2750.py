from sys import stdin

N = int(stdin.readline());

arr = []
for i in range(N):
    arr.append(int(stdin.readline()))

for i in range(N-1):
    for k in range(N-i-1):
        if arr[k] > arr[k+1]:
            arr[k],arr[k+1] = arr[k+1],arr[k]

for i in arr:
    print(i)