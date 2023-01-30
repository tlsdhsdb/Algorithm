from sys import stdin

n = int(stdin.readline())
#명령어 개수

stack = []

for _ in range(n):
    word = stdin.readline().split()
    if word[0] == 'push':
        stack.append(word[1])
    else:
        if word[0] == 'top':
            if len(stack) !=0:
                print(stack[-1])
            else :
                print(-1)
        if word[0] == 'size':
            print(len(stack))
        if word[0] == 'empty':
            if len(stack)==0:
                print(1)
            else :
                print(0)
        if word[0] == 'pop':
            if len(stack) != 0:
                print(stack.pop())
            else:
                print(-1)

