import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int a = 0;
        int b = 0;
        boolean c = false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.add(i);
        }

        while (!c) {
            if(pq.size() == 1){
                return -1;
            }
            if (pq.peek() < K) {
                a = pq.remove();
                b = pq.remove() * 2;

                pq.offer(a + b);
                answer++;
            }
            for (Integer i : pq) {
                if (i < K) {
                    break;
                }
                c= true;
            }
        }

        return answer;
    }
}

public class Spicy {
    public static void main(String[] args) {
        int k = 1;
        int[] p = {0,0,2};
        System.out.println(new Solution().solution(p, k));
    }
}
