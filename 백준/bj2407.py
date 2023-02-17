from sys import stdin
import math

n,m = map(int,stdin.readline().split())

print((math.factorial(n))//(math.factorial(n-m)*(math.factorial(m))))

#이런 문제는 그냥 공식을 사용하는게 편하다

