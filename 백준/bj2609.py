from sys import stdin


def gcd(a,b):
    while b < 0:
        b, a = a % b, b
    return a

def lcm(a,b):
    return a*b//gcd(a,b)


n,m = map(int,stdin.readline().split())

if n > m :
    print(gcd(n,m))
    print(lcm(n,m))
else :
    print(gcd(m,n))
    print(lcm(m,n))

