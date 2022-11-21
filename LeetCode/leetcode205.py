'''
leetcode 205 Isomorphic Strings
Isomorphic : 동형사상
동형일 경우는 어떤경우인가 ? s의 문자를 대체하여 t를 얻을 수 있다면 두 문자열 s와 t는 동형이다.
문자의 모든 발생은 문자의 순서를 유지하면서 다른 문자로 대체되어야 합니다.
두 개의 문자는 동일한 문자에 매핑할 수 없지만, 문자는 그 자체로 매핑할 수 있습니다.
즉, 하나의 문자는 하나에만 매핑이 가능함.

egg 와 add의 경우,
e => a로
g => d로 바꾸면 똑같아진다.

연속되는 문자열의 경우 또한 고려해야한다.

foo와 bar의 경우,

o가 연속되는 경우가 있고 동일 위치에 bar는 연속되는 두글자가 존재하지 않는다.
이는 동형이 아님을 의미한다.

1.문자열의 길이를 확인한다.
2.연속되는 문자열이 있는 경우 어디부터 어디까지 연속되는지 위치를 확인해야한다.

문자열이 연속되는 걸 확인하고싶다.


'''

def isIsomorphic(s, t):

    new_s = ""
    new_t = ""

    if len(s) != len(t):
        return False

    dict_a = dict.fromkeys(list(s),-1)
    dict_b = dict.fromkeys(list(t),-1)


    for idx,a in enumerate(dict_a):
        dict_a[a] = idx

    for idx,b in enumerate(dict_b):
        dict_b[b] = idx

    print(dict_a)
    print(dict_b)

    for a,b in zip(s,t):
        new_s += " " + str(dict_a[a])
        new_t += " " + str(dict_b[b])

    print(new_s)
    print(new_t)

    return new_s == new_t


if __name__ == '__main__':
    s = "abcdefghijklmnopqrstuvwxyzva"
    t = "abcdefghijklmnopqrstuvwxyzck"
    print(isIsomorphic(s,t))