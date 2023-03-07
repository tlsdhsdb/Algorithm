from sys import stdin

t = int(stdin.readline())

for _ in range(t):
    a,b = map(int,stdin.readline().split())
    lst_a = sorted(list(map(int,stdin.readline().split())))
    lst_b = sorted(list(map(int,stdin.readline().split())))

    answer = 0

    for i in range(a):
        for j in range(b):
            if lst_a[i] <= lst_b[j]:
                #아예 안될것은 안된다, 싹을 잘라버리기
                break
            else :
                answer += 1

    print(answer)

