# 점수가 가장 높은 k명
# 이때 커트라인은 몇점? -> 상을 받는 학생 중 가장 낮은 점수를 구하라
from sys import stdin

def bubbleSort(arr,n):
    for i in range(n-1,0,-1):
        for j in range(0,i,1):
            if arr[j] < arr[j+1]:
                arr[j+1],arr[j] = arr[j],arr[j+1]
    return arr


n,k = map(int,stdin.readline().split())
arr = list(map(int,stdin.readline().split()))

sorted_arr = bubbleSort(arr,n)
print(sorted_arr[k-1])
