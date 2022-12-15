from sys import stdin

s, p = map(int, stdin.readline().split())
dna = stdin.readline();
a,c,g,t = map(int,stdin.readline().split())

start = dna[:p]
dic = {"A":0,"C":0,"G":0,"T":0}
answer = 0

for i in start:
    dic[i] +=1

if dic["A"]>=a and dic["C"] >= c  and dic["G"] >= g and dic["T"] >= t :
    answer +=1

start_idx = 0
end_idx = start_idx + p

for i in range(s-p):
    #s-p 까지 루프를 돌리는 이유
    #슬라이딩 윈도우의 경우 뒤에껄 계속 붙이는 연산만 남아있기 때문에 남은 뒤에 것의 개수만 구하면 됨
    dic[dna[start_idx+i]] -= 1
    dic[dna[end_idx+i]] +=1
    if dic["A"] >= a and dic["C"] >= c and dic["G"] >= g and dic["T"] >= t:
        answer += 1

print(answer)
