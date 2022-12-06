'''
단어공부

가장 많이 사용된 알파벳이 무엇인지
단순하게 구현하기 !
'''
from collections import deque

value = input()
dict = {}

for i in value:

    item = i.upper()
    if item in dict:
        dict[item] += 1
    else :
        dict[item] = 1

