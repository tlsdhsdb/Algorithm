from sys import stdin

N,K = map(int,stdin.readline().split())

arr = list(map(int,stdin.readline().split()))

def quickSort(s,e,k):
    global arr
    if s < e:
        pivot = partition(s,e)
        if pivot == k :
            return
        elif k < pivot :
            quickSort(s,pivot-1,k)
        else :
            quickSort(pivot+1,e,k)

def swap(i,j):
    global arr
    arr[i],arr[j] = arr[j],arr[i]
def partition(s,e):
    global arr

    if s+1 == e:
        if arr[s] > arr[e]:
            swap(s,e)
        return e

    m = (s + e) // 2
    swap(s,m)
    pivot = arr[s]
    i = s + 1  # index ++ (start)
    j = e # index

    while i <= j:
        while pivot < arr[j] and j > 0:
            # pivot 값이 마지막값보다 작을 경우,
            j = j - 1 #아래로 쭉 내려가면서 비교한다
        while pivot > arr[i] and i < len(arr) - 1:
            #pivot 값이 start 값보다 클 경우,
            i = i + 1
        if i <= j:
            swap(i,j)
            i = i +1
            j = j -1
            #이해가 안감 이부분

    arr[s] = arr[j]
    arr[j] = pivot
    return j

quickSort(0,N-1,K-1)
print(arr[K-1])



