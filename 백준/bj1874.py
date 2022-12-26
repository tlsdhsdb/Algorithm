from sys import stdin

N = int(stdin.readline())
arr = []
value= 1

result = True
answer = ""

for i in range(N):
    num = int(stdin.readline())

    if num >= value:
        while num >= value:
            arr.append(value)
            answer+= "+\n"
            value += 1
        arr.pop()
        answer+="-\n"
    else:
        n = arr.pop()
        if n > num:
            print("NO")
            result = False
            break
        else:
            answer +="-\n"

if result == True:
    print(answer)