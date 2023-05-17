
while True:
    lst = list(map(int,input().split()))
    lst.sort()
    a = lst[0]
    b = lst[1]
    c = lst[2]
    if a == 0 and b == 0 and c == 0:
        break
    else:
        if pow(a,2) + pow(b,2) == pow(c,2):
            print('right')
        else:
            print('wrong')



