from sys import stdin

n,m = map(int,stdin.readline().split())
numbers = list(map(int,stdin.readline().split()))

hap_numbers = [0]
tmp = 0

for i in numbers:
    tmp += i
    hap_numbers.append(tmp)

for i in range(m):
    s,e = map(int,stdin.readline().split())
    print(hap_numbers[e]-hap_numbers[s-1])