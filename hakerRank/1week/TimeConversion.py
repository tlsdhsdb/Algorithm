#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'timeConversion' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def timeConversion(s):
    answer = ""

    time = s.split(':')
    hour = int(time[0])
    miniute = time[1]
    second = time[2][:2]
    meridiem = time[2][2:]

    if meridiem == "PM":
        if hour != 12:
            hour += 12
        if hour > 24:
            hour = hour % 24

    else:
        if hour == 12:
            hour = "00"

    answer = str(hour).zfill(2) + ":" + miniute + ":" + second
    return answer
    # Write your code here


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = timeConversion(s)

    fptr.write(result + '\n')

    fptr.close()
