package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] ary) {
        int[] unsortedAry = new int[ary.length];
        int min = ary[0];
        int index = 0;
        for (int j = 0; j < ary.length; j++) {
            for (int i = 0; i < ary.length; i++) {
                if (min > ary[i] && ary[i] != 0) {
                    min = ary[i];
                }
            }
            unsortedAry[j] = min;
            for (int b = 0; b < ary.length; b++) {
                if (ary[b] == min) {
                    ary[b] = 0;
                }
            }
            for (int k = 0; k < ary.length; k++) {
                if (ary[k] != 0) {
                    min = ary[k];
                }
            }
        }
    }
}
