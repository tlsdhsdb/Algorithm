from collections import deque

strings = input()
n = int(input())

left = deque(list(strings))
right = deque()

for _ in range(n):
    tmp = input()

    command = ''
    word = ''

    if len(tmp) > 2:
        command = tmp.split()[0]
        word = tmp.split()[1]
    else:
        command = tmp

    if command == 'L':
        if left:
            right.append(left.pop())
    elif command == 'D':
        if right:
            left.append(right.popleft())
    elif command == 'B':
        if left:
            left.pop()
    elif command == 'P':
        left.append(word)

print(''.join(left+right))

