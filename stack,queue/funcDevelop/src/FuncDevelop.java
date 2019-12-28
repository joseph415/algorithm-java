import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
    }
}


public class FuncDevelop {
    public static void main(String[] args) {
        int[] p = {93, 30, 55};
        int[] s = {1, 30, 5};
        System.out.println(Arrays.toString((new Solution().solution(p, s))));
    }
}
