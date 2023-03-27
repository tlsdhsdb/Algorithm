'''
카드놓기 18115 큐
1. 제일 위의 카드 1장을 바닥에 내려놓는다
2. 위에서 두번째 카드를 바닥에 내려놓는다 (단, 카드 2장 이상)
3. 제일 밑에 있는 카드를 바닥에 내려놓는다 (단, 카드 2장 이상)

'''

from collections import deque

n = int(input())
lst = list(map(int,input().split()))
lst.reverse()
#이 부분이 포인트
#들어온 순서의 반대로 카드를 넣어서 원래 카드 번호를 알 수 있음
answer = deque()

for i in range(n):
    if lst[i] == 1:
        answer.appendleft(i+1)
    elif lst[i] == 2:
        answer.insert(1,i+1)
    elif lst[i] == 3:
        answer.append(i+1)

print(*answer)


