'''
숫자야구,구현
동일한 자리에 동일한 숫자가 있으면 스트라이크
해당 숫자를 가지고 있지만 위치가 다르면 볼
'''

from sys import stdin

n = int(stdin.readline())
question = []
result = 0

for _ in range(n):
    num,strike,ball = map(int,stdin.readline().split())
    question.append([num,strike,ball])

for i in range(123,988):
    hundred = i // 100
    ten = i // 10 % 10
    unit = i % 10

    if hundred == ten or ten == unit or unit == hundred:
        continue

    if ten == 0 or unit == 0 :
        continue

    flag = True

    for q in question:
        hundred_a = q[0] // 100
        ten_a = q[0] // 10 % 10
        unit_a = q[0] % 10

        strike_a = q[1]
        ball_a = q[2]

        s,b = 0,0

        if hundred == hundred_a : s += 1
        if ten == ten_a : s += 1
        if unit == unit_a : s += 1

        if hundred_a == ten or hundred_a == unit:  b += 1
        if ten_a == hundred or ten_a == unit: b += 1
        if unit_a == hundred or unit_a == ten: b += 1

        if strike_a != s or ball_a != b :
            flag = False
            break

    if flag :
        result += 1

print(result)