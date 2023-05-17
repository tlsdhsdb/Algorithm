'''
acm 호텔
호텔 정문으로부터 걸어서 가장 짧은 거리에 있는 방을 선호
엘레베이터 거리 신경 안씀
걷는 거리가 같을 경우 아래층을 선호

'''

t = int(input())

for tc in range(t):
    h, w, n = map(int, input().split())
    l = len(str(w))
    if l == 1:
        l += 1
    cnt = 0
    answer = ""
    for i in range(1,w+1):
        for j in range(1,h+1):
            cnt += 1
            if cnt == n:
                answer = str(j) + str(i).zfill(l)
                break

    print(answer)