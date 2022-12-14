from sys import stdin

n = int(stdin.readline())
m = int(stdin.readline())

arr = sorted(list(map(int,stdin.readline().split())))

start = 0
end = n-1 # 인덱스가 0부터 시작하니까

cnt = 0

while start < end :
    #두 인덱스는 교차하면 안된다.
    if arr[start] + arr[end] < m:
        start += 1
    elif arr[start]+arr[end] > m:
        end -= 1
    else:
        cnt +=1
        start +=1
        end -=1
print(cnt)



#왜 이전문제와 다르게 start와 end를 시작했는가?
#end가 맨 마지막 start가 맨 앞으로 시작해서 서로 만나는걸 두고 구현한 이유가 뭘까?