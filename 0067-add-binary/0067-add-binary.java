import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger num1 = new BigInteger(a,2);
        BigInteger num2 = new BigInteger(b,2);

        while(!num2.equals(BigInteger.ZERO)){
            //자리 올림 수가 없을때까지 더하기

            BigInteger sum = num1.xor(num2); // xor 연산
            BigInteger carry = num1.and(num2).shiftLeft(1); // 자리올림 계산 및 이동

            num1 = sum;
            num2 = carry;

        }

        return num1.toString(2);
    }
}