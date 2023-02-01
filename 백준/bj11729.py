'''
하노이의 탑 이동순서
가장 큰 판은 천천히 옆으로 이동한다
'''
from sys import stdin

def hanoi(n,from_pos,to_pos,aux_pos):
    if n==1:
        arr.append([from_pos, to_pos])
        #print(from_pos,"->",to_pos)
        return
    hanoi(n-1,from_pos,aux_pos,to_pos)
    #원판을 제외한 나머지는 모두 보조기둥으로 이동한다
    arr.append([from_pos,to_pos])
    #print(from_pos,"->",to_pos)
    hanoi(n-1,aux_pos,to_pos,from_pos)
    #보조기둥에 있는 원판을 목표기둥으로 옮기는 작업


n = int(stdin.readline())
arr = []
hanoi(n,1,3,2)

print(len(arr))
for item in arr:
    print(item[0],item[1])
