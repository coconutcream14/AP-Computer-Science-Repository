package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] ary) {
        for(int i = 1; i < ary.length; i++){
            int key = ary[i];
            int j = i - 1;

            while(j >= 0 && key < ary[j]){
                ary[j + 1] = ary[j];
                j--;
            }
            ary[j + 1] = key;
        }
    }
}
