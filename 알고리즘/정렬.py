def bubbleSort(arr):
    N = len(arr)

    for i in range(N):
        for k in range(N-i-1):
            if arr[k] > arr[k+1]:
                arr[k],arr[k+1] = arr[k+1],arr[k]

    return arr

def selectedSort(arr):
    N = len(arr)
    for i in range(N-1):
        min_idx = i
        for j in range(i+1,N):
            if arr[i] > arr[j]:
                min_idx  = j
        if arr[min_idx] < arr[i]:
            arr[i],arr[min_idx] = arr[min_idx],arr[i]

    return arr

def insertSort(arr):
    N = len(arr)
    for i in range(1,N):
        for j in range(i,0,-1):
            if arr[j] < arr[j-1]:
                arr[j-1],arr[j] = arr[j],arr[j-1]

    return arr

def quickSort(arr):
    if len(arr) <= 1:
        #정렬할 원소가 없는 경우 그대로 리턴
        return arr
    pivot = arr[len(arr)//2]
    #pivot을 중앙값으로 선정함
    lesser, equal, greater = [], [],[]

    for num in arr:
        if num < pivot :
            lesser.append(num)
        elif num > pivot:
            greater.append(num)
        else :
            equal.append(num)
    return quickSort(lesser) + equal + quickSort(greater)

def mergeSort(arr):
    if len(arr) < 2:
        return arr
    #길이가 1이 될때까지 쪼개기 위함
    mid = len(arr)//2
    #배열을 반으로 쪼갬
    low_arr = mergeSort(arr[:mid])
    high_arr = mergeSort(arr[mid:])

    merged_arr = []
    l = h = 0
    # l , low_arr 시작점
    # h , high_arr 시작점
    while l < len(low_arr) and h < len(high_arr):
        if low_arr[l] < high_arr[h]:
            merged_arr.append(low_arr[l])
            l += 1
        else:
            merged_arr.append(high_arr[h])
            h += 1
    merged_arr += low_arr[l:]
    merged_arr += high_arr[h:]

    return merged_arr


if __name__ == '__main__':
    arr = [43,32,24,60,15]
    #print(bubbleSort(arr))
    #print(selectedSort(arr))
    #print(insertSort(arr))
    #print(quickSort(arr))
    print(mergeSort(arr))
