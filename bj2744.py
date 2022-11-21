value = list(input())
answer = ""
for i in value :
    if i.isupper():
        answer+= i.lower()
    elif i.islower():
        answer+= i.upper()

print(answer)
