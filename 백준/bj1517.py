from sys import stdin

result = 0 #swap 횟수

def mergeSort(s,e):
    global result
    if e-s < 1 : return
    m = int( s + (e - s)/2)
    mergeSort(s,m)
    mergeSort(m+1,e)

    for i in range(s,e+1):
        tmp[i] = arr[i]
    k = s
    index1 = s #각각의 시작지점 ,왼쪽 배열의 시작지점
    index2 = m+1 #오른쪽 배열의 시작지점

    while index1 <= m and index2 <= e:
        if tmp[index1] > tmp[index2]:
            arr[k] = tmp[index2]
            result = result + (index2 - k) #얼마나 앞서갔는가
            k += 1
            index2 += 1
        else :
            arr[k] = tmp[index1]
            k +=1
            index1 += 1
    while index1 <= m :
        arr[k] = tmp[index1]
        k += 1
        index1 += 1
    while index2 <= e :
        arr[k] = tmp[index2]
        k += 1
        index2 += 1

N = int(stdin.readline())
arr = list(map(int, stdin.readline().split()))
arr.insert(0,0)
tmp = [0] * int(N+1)
mergeSort(1,N)
print(result)