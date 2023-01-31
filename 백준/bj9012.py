# 괄호기호로 구성되어있는 문자열
# 괄호 짝 맞추는 문제

from sys import stdin

n = int(stdin.readline())


for i in range(n):
    st = stdin.readline()
    answer = "YES"
    stack = []
    if (len(st) % 2)-1 != 0:
        answer = "NO"
    else :
        for ch in st:
            if ch == "(":
                stack.append(ch)
            elif ch == ")":
                if stack:
                    stack.pop()
                else:
                    answer = "NO"
        if len(stack) != 0:
            answer = "NO"
    print(answer)

# 1번 테스트케이스 ; ) 가 남는 경우
# 2번 테스트케이스 ; ( 가 남는 경우
# 3번 테스트케이스 ; YES
# 4번 테스트케이스 ; ( 가 남는 경우
# 5번 테스트케이스 ; YES
# 6번 테스트케이스 ; ( 가 남는경우

# ( 가 남는경우는,