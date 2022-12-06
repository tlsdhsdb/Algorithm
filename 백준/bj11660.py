from sys import stdin

n,m = map(int,stdin.readline().split())

numbers = [[0] * (n+1)]
hap_numbers = [[0] * (n+1) for _ in range(n+1)]

for i in range(n):
    arr = [0] + list(map(int,stdin.readline().split()))
    numbers.append(arr)

print(numbers)

for i in range(1,n+1):
    for j in range(1,n+1):
        hap_numbers[i][j] = hap_numbers[i][j-1] + hap_numbers[i-1][j] - hap_numbers[i-1][j-1] + numbers[i][j]


for _ in range(m):
    x1,y1,x2,y2 = map(int,stdin.readline().split())
    answer = hap_numbers[x2][y2] - hap_numbers[x1-1][y2] - hap_numbers[x2][y1-1] + hap_numbers[x1-1][y1-1]
    print(answer)



