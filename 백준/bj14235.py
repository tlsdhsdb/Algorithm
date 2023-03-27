'''
크리스마스 선물 14235 우선순위 큐

거점 = 선물 충전
아이들 만남 = 가치가 큰 선물
줄 선물이 없으면 = -1
'''
import heapq

n = int(input())
pq = []

for _ in range(n):
    arr = list(map(int,input().split()))
    if len(arr) == 1 and arr[0] == 0:
        #선물 여부 출력
        if not pq :
            print(-1)
        else :
            print(-heapq.heappop(pq))
        continue

    for i in range(1,len(arr)):
        heapq.heappush(pq,-arr[i])


