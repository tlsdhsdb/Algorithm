n = int(input())
arr = list(map(int,input().split()))
m = int(input())
targets = list(map(int,input().split()))

arr.sort()

def binary(target):
    left = 0
    right = n-1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == target:
            return True
        if target < arr[mid]:
            # target 보다 작으면,오른쪽 범위를 줄여서 탐색범위를 줄여버림 
            right = mid - 1
        elif target > arr[mid]:
            # target 보다 크면, 왼쪽 범위를 줄여서 작은 부분 탐색범위(볼필요없는곳)를 줄여버림
            left = mid + 1

for t in targets:
    if binary(t):
        print(1)
    else:
        print(0)