import java.util.Arrays;

class Merge {
    // sort in ascending
    public int[] merge_sort(int[] list) {
        // Recursive base case
        if (list.length <= 1)
            return list;

        // Divide: Find the midpoint of the list and divide into sublists
        int[][] left_right_halves = this.split(list);

        // Conquer: Recursively sort the sublists created in previous step
        int[] left = this.merge_sort(left_right_halves[0]);
        int[] right = this.merge_sort(left_right_halves[1]);

        // Combine: Merge the sorted sublists created in previous step
        return this.merge(left, right);
    }

    public int[][] split(int[] list) {
        // Divide the unsorted list at midpoint into sublists
        int mid = list.length / 2;
        int[] left = Arrays.copyOfRange(list, 0, mid);
        int[] right = Arrays.copyOfRange(list, mid, list.length);

        // Return two sublists - left and right
        return new int[][] { left, right };
    }

    public int[] merge(int[] left, int[] right) {
        // Merges two lists (arrays), sorting them in the process
        int[] lst = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                lst[k] = left[i];
                i++;
                k++;
            } else {
                lst[k] = right[j];
                j++;
                k++;
            }
        }
        // return a new merged list
        while (i < left.length) {
            lst[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            lst[k] = right[j];
            j++;
            k++;
        }
        return lst;
    }

    /**
     * Runs at O(n log n)
     * Takes O(n)
     */
    public static void main(String args[]) {
        int[] unsortedList = { 54, 62, 94, 12, 77, 21, 40, 49, 2, 31 };
        int[] sortedList = new Merge().merge_sort(unsortedList);
        for (int i = 0; i < sortedList.length; ++i)
            System.out.print(sortedList[i] + " ");
    }
}