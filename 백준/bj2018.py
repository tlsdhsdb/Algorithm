from sys import stdin

num = int(stdin.readline())
cnt = 1
#자기자신을 뽑는 경우는 있기 때문에 1로 초기화

start = 1
end = 1

s = 1



while end != num:
    if s == num :
        cnt+=1
        end += 1
        s += end
    elif s > num :
        s -= start
        start += 1
    elif s < num :
        end += 1
        s += end


print(cnt)