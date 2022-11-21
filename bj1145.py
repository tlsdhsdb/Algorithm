#브루트포스

arr = list(map(int,input().split()))

arr = sorted(arr)
num = 1
answer = 0

while True:
    cnt = 0
    for i in arr:
        if num % i == 0:
            cnt+=1
        #print(num,i,num%i,cnt)

    if cnt >= 3:
        answer = num
        break
    num += 1

print(answer)