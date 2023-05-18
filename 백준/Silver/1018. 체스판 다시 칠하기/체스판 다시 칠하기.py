n,m = map(int,input().split())

board = []

for _ in range(n):
    board.append(list(input()))
count = []

for a in range(n-7):
    for b in range(m-7):
        #판의 크기는 고정되어있기 때문에 시작지점을 변경해가며 새로운 판을 계산함 
        index1 = 0 # W로 시작 할 경우
        index2 = 0 # B로 시작 할 경우
        for i in range(a,a+8):
            for j in range(b,b+8):
                if (i+j) % 2 == 0:
                    if board[i][j] != 'W':
                        index1 += 1
                    if board[i][j] != 'B':
                        index2 += 1
                else:
                    if board[i][j] != 'B':
                        index1 += 1
                    if board[i][j] != 'W':
                        index2 += 1
        count.append(min(index1,index2))

print(min(count))

