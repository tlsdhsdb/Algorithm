arr = list(input())

N = len(arr)

for i in range(N):
    max_idx = i
    for j in range(i+1,N):
        if arr[max_idx] < arr[j]:
            max_idx = j
    if arr[i] < arr[max_idx]:
        arr[max_idx],arr[i] = arr[i],arr[max_idx]

print(''.join(str(e) for e in arr))