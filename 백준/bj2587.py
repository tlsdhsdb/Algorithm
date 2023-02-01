#bubble sorting
from sys import stdin

def bubbleSort(arr):
    for j in range(len(arr),0,-1):
        for i in range(0,j-1):
            if arr[i] > arr[i+1]:
                arr[i+1],arr[i] = arr[i],arr[i+1]

    return arr


'''
01,12,23,34,
01,12,23
01,12
01
'''
arr = []
for _ in range(5):
    arr.append(int(stdin.readline()))

sorted_arr = bubbleSort(arr)
print(sum(sorted_arr)//len(sorted_arr))
print(sorted_arr[len(sorted_arr)//2])