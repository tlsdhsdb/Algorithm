'''
단어공부

가장 많이 사용된 알파벳이 무엇인지
단순하게 구현하기 !
'''


st = input().upper()

keys = list(set(st))
values = []

answer = 0

for key in keys:
    cnt = st.count(key)
    values.append(cnt)


if values.count(max(values)) > 1:
    print("?")
else:
    answer = values.index(max(values))
    print(keys[answer])





