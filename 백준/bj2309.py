from sys import stdin

n = 9
arr = []

for i in range(9):
    arr.append(int(stdin.readline()))

arr.sort()

remain = sum(arr) - 100

left,right = 0,len(arr)-1

fake = []


while left < right:
    if arr[left] + arr[right] > remain:
        right -= 1
    elif arr[left] + arr[right] < remain:
        left += 1
    else:
        fake = [arr[left],arr[right]]
        break

arr.remove(fake[0])
arr.remove(fake[1])

for i in arr:
    print(i)

#2개의 합이 remain이 되는 경우!
