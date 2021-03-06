import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int index = 0;
        for (int i = 0; i < k; i++) {
            if (index < dates.length && i == dates[index])
                pq.add(supplies[index++]);

            if (stock == 0) {
                stock += pq.poll();
                answer++;
            }
            stock -= 1;
        }
        return answer;
    }
}

public class RamenPlant {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;
        System.out.println(new Solution().solution(stock, dates, supplies, k));
    }
}
