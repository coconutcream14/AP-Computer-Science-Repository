import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String [] inputAry = scanner.nextLine().trim().split(" ");
        int x = 0;
        int y = 0;
        int i = 0;
        int j = 0;  
        int [][] grid = new int[length][length];
        int [][] grid2 = new int[length][length];
        int [] numsAry = new int[inputAry.length];
        for(i = 0; i < inputAry.length; i++){
            numsAry[i] = Integer.parseInt(inputAry[i]);
            //System.out.print(numsAry[i] + " ");
        }
        //System.out.println();
        i = 0;
        for(x = 0; x < length; x++){
            for(y = 0; y < length; y++){
                grid[x][y] = numsAry[i];
                grid2[x][y] = numsAry[i];
                i++;
            }
        }
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(i = 0; i < length; i++){
            for(j = 0; j < length; j++){
                if(grid[i][j] == 0){
                    solveFor0(i, j, grid, length);
                }
            }
        }

        for(i = 0; i < length; i++){
            for(j = 0; j < length; j++){
                if(grid2[i][j] == 0){
                    System.out.print(grid[i][j] + " ");
                }
            }
        }
    

        /*// FOR DEBUG: INDEX LIST PRINT
        for(int j = 0; j < indexList.size(); j++){
            System.out.println("Index List " + j + ": ");
            for(int k = 0; k < indexList.get(j).size(); k++){
                System.out.print(indexList.get(j).get(k) + " ");
            }
            System.out.println();
        } */

        /* FOR DEBUG: NUMBERS (arylist) PRINT
        for(int num : numbers){
            System.out.print(num +  " ");
        }*/
        /* FOR DEBUG: GRID PRINT
        for(x = 0; x < length; x++){
            for(y = 0; y < length; y++){
                System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }*/
	}
    public static int findValue(int x, int y, int [][] grid, int n){
        if(x < n && y < n && x > -1 && y > -1){
            return grid[x][y];
        }
        return -1;
   }
   public static void solveFor0(int x, int y, int [][] grid, int n){
        int a = findValue(x - 1, y, grid, n);
        int b = findValue(x + 1, y, grid, n);
        int c = findValue(x, y - 1, grid, n);
        int d = findValue(x, y + 1, grid, n);
        int result =0;
        result = solveForZero(a, b);
        if(result != -1){
            grid[x][y] = result;
            return;
        }
        result = solveForZero(a, c);
        if(result != -1){
            grid[x][y] = result;
            return;
        }
        result = solveForZero(a, d);
        if(result != -1){
            grid[x][y] = result;
            return;
        }
        result = solveForZero(b, c);
        if(result != -1){
            grid[x][y] = result;
            return;
        }
        result = solveForZero(b, d);
        if(result != -1){
            grid[x][y] = result;
            return;
        }
        result = solveForZero(c, d);
        if(result != -1){
            grid[x][y] = result;
            return;
        }    
   }
   public static int solveForZero(int a, int b){
        if(a != -1 && b != -1){
            if(a > b){
                if(a - b == 2){
                    return a - 1;
                } else {
                    return b - 1;
                }
            }
        }
        return -1;
   }
}
