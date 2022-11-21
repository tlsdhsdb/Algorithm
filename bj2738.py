n,m = map(int,input().split())

a = []
b = []

answer = []

for i in range(n):
    a.append(list(map(int,input().split())))

for i in range(n):
    b.append(list(map(int,input().split())))

for i in range(n):
    temp = []
    for j in range(m):
        temp.append(str(a[i][j]+b[i][j]))
    print(' '.join(temp))


