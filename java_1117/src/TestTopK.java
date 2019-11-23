

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TestTopK {
   static class pair implements Comparable<pair> {
        int n1;
        int n2;
        int sum;

        public pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
            this.sum = n1 + n2;
        }

       @Override
       public int compareTo(pair o) {
            //
           return  o.sum - this.sum;
       }
   }
    public List<List<Integer>> kSmallestPairs(int[] nums1,
                                              int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k < 1) {
            return null;
        }
        PriorityQueue<pair> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length ; j++) {
                queue.offer(new pair(nums1[i],nums2[j]));
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        while (!queue.isEmpty()) {
            pair p =  queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(p.n1);
            tmp.add(p.n2);

            result.add(0,tmp);
        }
        return result;
    }
}
