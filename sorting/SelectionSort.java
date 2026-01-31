package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] ary) {
        int [] unsortedAry = new int[ary.length];
        int min = ary[0];
        for(int j = 0; j < ary.length; j++){
            for(int i = 0; i < ary.length; i++){
                if(min > ary[i] && ary[i] != 0){
                    min = ary[i];
                }
                //System.out.println(min);
            }
            unsortedAry[j] = min;
            for(int b = 0; b < ary.length; b++){
                if(ary[b] == min){
                    ary[b] = 0;
                }
            }
            min = ary[0];
        }
        for(int w = 0; w < ary.length; w++){
            ary[w] = unsortedAry[w];
            System.out.print(ary[w] + ", ");
        }
    }
}
