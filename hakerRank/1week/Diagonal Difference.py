#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'diagonalDifference' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY arr as parameter.
#

def diagonalDifference(arr):
    left, right = 0, 0

    # left (0,0) (1,1) (2,2)
    # right (0,2) (1,1) (2,0)

    for i in range(len(arr)):
        left += arr[i][i]

    for i in range(len(arr)):
        right += arr[i][len(arr) - 1 - i]

    return abs(left - right)

    # Write your code here


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    arr = []

    for _ in range(n):
        arr.append(list(map(int, input().rstrip().split())))

    result = diagonalDifference(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
