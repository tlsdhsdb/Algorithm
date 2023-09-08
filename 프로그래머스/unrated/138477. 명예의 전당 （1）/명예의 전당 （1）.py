from queue import PriorityQueue

def solution(k, score):
    answer = []
    que = PriorityQueue(maxsize=k)

    for s in score:
        if not que.full() :
            que.put(s)
            tmp = que.get()
            que.put(tmp)
            answer.append(tmp)
        else:
            tmp = que.get()
            if tmp < s :
                que.put(s)
            else :
                que.put(tmp)
            m = que.get()
            que.put(m)
            answer.append(m);

    return answer