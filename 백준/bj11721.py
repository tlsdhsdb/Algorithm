'''
문자열
'''

from sys import stdin

word = stdin.readline()

for i in range(0,len(word),10):
    if i + 10 >= len(word):
        print(word[i:])
    else:
        print(word[i:i+10])