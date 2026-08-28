class Solution {
    public int search(int[] a, int t) {
        int n = a.length;
        if (n == 1) return a[0] == t ? 0 : -1;

        int pivot = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[pivot]) pivot = i;
        }

        int l, r;
        if (pivot == 0) {
            // Array not rotated
            l = 0;
            r = n - 1;
        } else if (t >= a[0]) {
            l = 0;
            r = pivot - 1;
        } else {
            l = pivot;
            r = n - 1;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == t) return mid;
            else if (a[mid] < t) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
