from sys import stdin;

def mergeSort(s,e):
    if e-s < 1: return
    #길이가 1일 경우 루프를 종료한다
    m =  s + (e-s)//2
    #홀수의 경우도 고려한 중간점
    mergeSort(s,m) #왼쪽
    mergeSort(m+1,e) #오른쪽

    for i in range(s,e+1):
        tmp[i] = A[i]
    k = s
    index1 = s
    #왼쪽
    index2 = m + 1
    #중간이후(오른쪽)

    while index1 <= m  and index2 <= e:
        if tmp[index1] > tmp[index2]:
            A[k] = tmp[index2]
            k  += 1
            #정렬된 배열에 원소가 들어갈때마다 ++
            index2 += 1
            #오름차순 정렬이기 때문에
            #작은수를 넣은 뒤, 넣은쪽의 인덱스를 하나 올려준다
        else:
            A[k] = tmp[index1]
            k +=1
            index1 += 1

    while index1 <= m:
        A[k] = tmp[index1]
        k += 1
        index1 += 1
    while index2 <= e :
        A[k] = tmp[index2]
        k += 1
        index2 += 1

    #둘중 하나의 원소가 몽땅 남았을 경우 이어 붙이는 작업을 한다


N = int(stdin.readline())
A = [0] * int(N+1) #초기 배열
tmp = [0] * int(N+1) #정렬된 배열

for i in range(1,N+1):
    A[i] = int(stdin.readline());

mergeSort(1,N)

for i in range(1,N+1):
    print(str(A[i]));