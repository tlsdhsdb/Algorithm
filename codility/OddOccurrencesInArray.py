def solution(A):
    A.sort()
    temp = 0

    for value in A:
        temp = temp ^ value

    return temp


# xor 연산에 대한 이해
# 똑같은 걸 두번 연산하면 0으로 돌아옴, 즉 짝이 없는 경우는 으로 돌아오지 않기 때문에
# 연산을 했을 때 항상 남는 것은 짝이 맞지 않는 것이다 !