'''
Q. Running Sum of 1d Array

nums라는 배열이 주어져있을때, 우리는 다음과 같은 형식의 배열을 리턴해야한다.
runniongSum[0] = nums[0]
runniongSum[1] = nums[0] + nums[1]
runniongSum[2] = nums[0] + nums[1] + nums[2]

runniongSum[n] 의 갑은 nums[0] .. nums[n] 까지의 합과 같다.

sum 함수는 너무 많은 메모리를 사용할 수 있으니 되도록이면 피하자.
이전항의 크기는 이전항까지의 합을 모두 담고 있다는 점을 이용해서 구현해보자.
'''


def runningSum(nums):
    """
    :type nums: List[int]
    :rtype: List[int]
    """

    for i in range(0,len(nums)):
        if i == 0:
            nums[i] = nums[i]
        else :
            nums[i] = nums[i-1] + nums[i]

    print(nums)






if __name__ == '__main__':
    nums = [1, 2, 3, 4]
    runningSum(nums)