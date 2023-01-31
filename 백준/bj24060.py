# 배열에 k번째 저장되는 수를 구하기
# 저장횟수가 k보다 작으면 -1을 출력함

from sys import stdin

def merge_sort(arr):
    global ans

    if len(arr) == 1:
        return arr
    pivot = (len(arr)+1)//2 #중간값

    low_arr = merge_sort(arr[:pivot])
    high_arr = merge_sort(arr[pivot:])

    merged = []
    l = h = 0

    while l < len(low_arr) and h < len(high_arr):
        if low_arr[l] < high_arr[h]:
            merged.append(low_arr[l])
            ans.append(low_arr[l])
            l +=1
        else :
            merged.append(high_arr[h])
            ans.append(high_arr[h])
            h += 1
    merged += low_arr[l:]
    ans += low_arr[l:]
    merged += high_arr[h:]
    ans += high_arr[h:]

    return merged



n,k= map(int,stdin.readline().split())

arr = list(map(int,stdin.readline().split()))
ans = []

merge_sort(arr)

if len(ans) < k:
    print(-1)
else:
    print(ans[k-1])


