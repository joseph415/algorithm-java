import java.util.ArrayList;
import java.util.List;

class P {
    public int idx;
    public int pro;

    public P(int idx, int pro) {
        this.idx = idx;
        this.pro = pro;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int temp_pro;
        int temp_idx;
        boolean check = false;
        List<P> l = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            l.add(new P(i, priorities[i]));
        }

        for (int k = 0; k < l.size(); k++) {
            if (check) {
                k = 0;
            }
            check = false;
            for (int j = k + 1; j < l.size(); j++) {
                if (l.get(k).pro < l.get(j).pro) {
                    temp_pro = l.get(k).pro;
                    temp_idx = l.get(k).idx;
                    l.remove(k);
                    l.add(new P(temp_idx, temp_pro));
                    check = true;
                }
            }
        }

        for (P p : l) {
            System.out.println(p.idx + " " + p.pro);
        }

        for (P p : l) {
            if(p.idx != location){
                answer++;
                continue;
            }
            break;
        }
        return answer+1;
    }
}

public class Printer {
    public static void main(String[] args) {
        int[] p = {3,3,4,2};
        int s = 3;
        System.out.println(new Solution().solution(p, s));
    }
}
