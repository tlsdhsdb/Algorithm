from sys import stdin

n = int(stdin.readline())
arr = sorted(map(int,stdin.readline().split()))
answer = set()
cnt = 0

for i in range(0,n):
    find = arr[i]
    s = 0
    e = n - 1
    while s < e :
        if arr[s] + arr[e] < find :
            s +=1
        elif arr[s] + arr[e] > find:
            e -=1
        else :
            if s != i and e != i:
                #더하는 수 두개가 서로 다른 수여야함
                cnt +=1
                break
            elif s == i :
                s +=1
            elif e == i:
                e -=1

print(cnt)