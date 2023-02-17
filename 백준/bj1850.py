from sys import stdin
import math

def gcd(a,b):
    while a > 1 and b > 0 :
        a , b = b , a % b
    return a

print(gcd(111,11111))
