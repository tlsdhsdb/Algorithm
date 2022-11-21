'''
Q. find pivot index 724
정수배열인 nums가 주어졌을 때 해당 배열의 pivot의 index를 구하는 것이 목표.
pivot을 정하는 기준은 left,right로 나누어서 양 쪽의 합이 같아지는 지점
단,pivot을 제외하고 계산함.

left sum = 0 일 경우도 계산해야함 -> 까다로울수도


'''


def pivotIndex(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    total_sum = sum(nums)
    left_sum = 0

    pivot = 0

    for i in range(0,len(nums)):
        pivot = i
        total_sum -= nums[i]
        #pivot을 빼줌

        if total_sum == left_sum :
            return pivot

        left_sum += nums[i]





if __name__ == '__main__':
    nums = [1, 7, 3, 6, 5, 6]
    nums2 = [2,1,-1]

    print(pivotIndex(nums2))
