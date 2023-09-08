from itertools import permutations

def solution(babbling):
    answer = 0
    
    speek = ["aya","ye","woo","ma"]
    word = []
    for l in range(1,len(speek)+1):
        for w in permutations(speek,l):
            word.append(''.join(w))
    
    for babb in babbling :
        if babb in word : answer+=1
    
    
    return answer