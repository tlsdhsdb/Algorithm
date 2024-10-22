
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;  // 초기 최소 가격
        int maxProfit = 0;  // 최대 이익은 0으로 시작
        
        for (int price : prices) {
            if (price < minPrice) {
                // 현재 가격이 최소 가격보다 작으면 최소 가격 갱신
                minPrice = price;
            } else {
                // 최대 이익 갱신: 현재 가격에서 최소 가격을 뺀 값과 비교
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        
        return maxProfit;
    }
}