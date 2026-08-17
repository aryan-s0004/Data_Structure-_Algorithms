import java.util.*;

class Solution {
    public int[] maxNumber(int[] a, int[] b, int k) {
        int[] ans = new int[k];

        for (int x = Math.max(0, k - b.length);
             x <= Math.min(k, a.length); x++) {

            int[] p = pick(a, x);
            int[] q = pick(b, k - x);
            int[] cur = merge(p, q);

            if (cmp(cur, 0, ans, 0) > 0)
                ans = cur;
        }
        return ans;
    }

    private int[] pick(int[] a, int k) {
        int[] s = new int[a.length];
        int top = 0, remove = a.length - k;

        for (int x : a) {
            while (top > 0 && remove > 0 && s[top - 1] < x) {
                top--;
                remove--;
            }
            s[top++] = x;
        }
        return Arrays.copyOf(s, k);
    }

    private int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0;

        for (int k = 0; k < res.length; k++)
            res[k] = cmp(a, i, b, j) > 0 ? a[i++] : b[j++];

        return res;
    }

    private int cmp(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length) {
            if (a[i] != b[j]) return a[i] - b[j];
            i++;
            j++;
        }
        return (a.length - i) - (b.length - j);
    }
}