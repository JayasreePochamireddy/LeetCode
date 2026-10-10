
import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        long[] diff = new long[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            total += diff[i];
        }

        if (total <= k) {
            return 0;
        }

        Arrays.sort(diff);

        long max = diff[n - 1];

        while (k > 0) {
            int i = n - 1;

            while (i > 0 && diff[i] == diff[i - 1]) {
                i--;
            }

            long next = (i > 0) ? diff[i - 1] : 0;
            long count = n - i;
            long cost = (max - next) * count;

            if (cost <= k) {
                for (int j = i; j < n; j++) {
                    diff[j] = next;
                }
                k -= cost;
                max = next;
            } else {
                long reduction = k / count;
                long remainder = k % count;

                for (int j = i; j < n; j++) {
                    diff[j] -= reduction;
                }

                for (int j = i; j < i + remainder; j++) {
                    diff[j]--;
                }

                k = 0;
            }
        }

        long result = 0;

        for (long d : diff) {
            result += d * d;
        }

        return result;
    }
}
