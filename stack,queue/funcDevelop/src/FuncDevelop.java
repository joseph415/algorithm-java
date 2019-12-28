import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int count;
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> pro = new ArrayDeque<>();
        Deque<Integer> temp1 = new ArrayDeque<>();
        Deque<Integer> temp2 = new ArrayDeque<>();
        int[] sum = new int[progresses.length];
        int[] spd = new int[speeds.length];

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            pro.add(progress);
            temp1.push(progress);
            temp2.push(speeds[i]);
        }
        for(int i=0;i<pro.size();i++){
            sum[i] = temp1.pop();
            spd[i] = temp2.pop();
        }

        while (!pro.isEmpty()) {
            System.out.println(Arrays.toString(sum));
            for (int i = 0; i < pro.size(); i++) {
                sum[i] += spd[i];
            }
            if (sum[pro.size() - 1] >= 100) {
                count = 1;
                if (pro.size() != 1) {
                    for (int i = pro.size() - 2; i >= 0; i--) {
                        if (sum[i] >= 100) {
                            count++;
                        }
                        else{
                            break;
                        }
                    }
                }
                for (int i = 0; i < count; i++) {
                    pro.poll();
                }
                answer.add(count);
            }
        }

        int idx = 0;
        int[] ans = new int[answer.size()];
        for (Integer i : answer) {
            ans[idx++] = i;
        }
        return ans;
    }
}

public class FuncDevelop {
    public static void main(String[] args) {
        int[] p = {93, 30, 55};
        int[] s = {1, 30, 5};
        System.out.println(Arrays.toString((new Solution().solution(p, s))));
    }
}
