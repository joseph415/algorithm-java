import java.util.Arrays;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        /*init*/
        for (int i = 1; i <= prices.length; i++) {
            answer[i-1] = prices.length - i;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }
}

public class StockPrice {
    public static void main(String[] args) {
        int[] p = {2, 3, 4, 5, 4};
        System.out.println((Arrays.toString(new Solution().solution(p))));
    }

}
