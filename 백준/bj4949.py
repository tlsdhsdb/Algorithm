from sys import stdin
import re

while True:
    message = stdin.readline()
    answer = "yes"
    if message == '.\n':
        break
    stack = []
    for ch in message:
        if ch == "(" or ch == "[":
            stack.append(ch)
        elif ch == ")" :
            if len(stack) == 0 or stack[-1] == "[":
                answer = "no"
                break
            elif stack[-1] == '(':
                stack.pop()
        elif ch == ']':
            if len(stack) == 0 or stack[-1] == '(':
                answer = 'no'
                break
            elif stack[-1] == '[':
                stack.pop()
    if len(stack) != 0:
        answer = "no"
    print(answer)