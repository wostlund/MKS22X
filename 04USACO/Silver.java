import java.io.*;
import java.util.Scanner;

public class Silver{

    private int[][]grid;

    public Silver(int[][]k){
	grid = k;
    }

    public int[][] makeAnsGrid(int numTimes){
	if(numTimes == 0){
	    return grid;
	}
	int[][] ans = new int[grid.length][grid[0].length];
	for(int i = 0; i < grid.length; i++){
	    for(int k = 0; k < grid[i].length; k++){
		if(grid[i][k] == -1){
		    ans[i][k] = -1;
		}else{
		    int a = 0;
		    if(i!=0 && grid[i-1][k] != -1){
			a+=grid[i-1][k];
		    }
		    if(i!=grid.length-1 && grid[i+1][k] != -1){
			a+=grid[i+1][k];
		    }
		    if(k!=0 && grid[i][k-1] != -1){
			a+=grid[i][k-1];
		    }
		    if(k!=grid[0].length-1 && grid[i][k+1] != -1){
			a+=grid[i][k+1];
		    }
		    ans[i][k] = a;
		}
	    }
	}
	grid = ans;
	return makeAnsGrid(numTimes - 1);
    }

    public int getAns(int x, int y){
	return grid[x][y];
    }

    public static void main(String[]args){
	try{
	    Scanner in = new Scanner(new File("testCase2.txt"));
	    Scanner x = new Scanner(in.nextLine());
	    int m = x.nextInt(), n = x.nextInt();
	    int turns = x.nextInt();
	    int[][] ans = new int[m][n];
	    for(int i = 0; i<m ; i++){
		String j = new String(in.nextLine());
		for(int k = 0; k<n; k++){
		    if(j.charAt(k) == '.'){
			ans[i][k] = 0;
		    }else{
			ans[i][k] = -1;
		    }
		}
	    }
	    Scanner v = new Scanner(in.nextLine());
	    ans[v.nextInt()-1][v.nextInt()-1] = 1;
	    Silver s = new Silver(ans);
	    s.makeAnsGrid(turns);
	    System.out.println(s.getAns(v.nextInt()-1, v.nextInt()-1));
	}catch(FileNotFoundException e){
	    System.out.println("Sorry your file could not be found in this directory");
	}
    }
    
}