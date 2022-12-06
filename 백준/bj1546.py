n = int(input())
arr = list(map(int,input().split()))

m = max(arr)
s = sum(arr)


print(s*100/m/n)