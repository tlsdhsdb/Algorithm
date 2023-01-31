#재귀의 귀재
#팰린드롬
from sys import stdin

def recursion(st,l,r,cnt):
    cnt += 1
    if l >= r: return [1,cnt]
    elif st[l] != st[r] :return [0,cnt]
    else:
        return recursion(st,l+1,r-1,cnt)

'''
s[0] = s[4]
s[1] = s[3]
s[2] = s[2] -> break !
'''

def isPalindrom(st):
    # 0 ~ 문자열크기 만큼
    return recursion(st,0,len(st)-2,0)

n = int(stdin.readline())

for _ in range(n):
    st = stdin.readline()
    answer = isPalindrom(st)
    print(answer[0],answer[1])



