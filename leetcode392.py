'''
leetcode 392 Is Subsequence

what is subsequence?
나머지 문자열의 상대적 위치를 방해하지 않고 문자 중 일부 혹은 공백을 삭제하여 원래 문자열에서 형성된 새로운 문자열을 말함.

그렇다면,

s = abc
t = ahbgdc

a(h)b(gc)c
이러한 식으로 사이에 들어간 문자열을 뺏을 때 s로 다시 되돌아와야 한다는 말!


'''
def isSubsequence(s,t):
    id = 0
    if s == "":
        return True

    for word in t:
        if word == s[id]:
            if id < len(s)-1:
                id+=1
            else :
                return True

    if id < len(s)-1 :
        return False




if __name__ == '__main__':
    s = "axc"
    t = "ahbgdc"
    print(isSubsequence(s,t))