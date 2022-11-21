score = input()
answer = 0.0

arr = ["F","D","C","B","A"]

answer += arr.index(score[0])

if len(score) > 1 :

    if score[1] == "+":
        answer+= 0.3
    elif score[1] == "-":
        answer-= 0.3

print(answer)

