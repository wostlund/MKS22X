import java.io.*;
import java.util.Scanner;


public class Bronze{

    private static int[][]field;
    private int elevation;

    public Bronze(int row, int col){
	field = new int[row][col];
    }
    
    public static void stomp(int row, int col, int num){
	int max = field[row][col];
	for(int startR = row-1; startR < row + 2; startR++){
	    for(int startC = col - 1; startC < col + 2; startC++){
		if(field[startR][startC] > max){
		    max = field[startR][startC];
		}
	    }
	}
	while (num > 0){
	    for(int startR = row-1; startR < row + 2; startR++){
		for(int startC = col - 1; startC < col + 2; startC++){
		    if(field[startR][startC] == max){
			field[startR][startC]--;
		    }
		}
	    }
	    max--;
	    num--;
	}
    }

    public static void decrease(int p){
	for(int i = 0; i < field.length; i++){
	    for(int k = 0; k < field[i].length; k++){
		field[i][k] -= p;
	    }
	}
    }

    public static int solve(){
	int ans = 0;
	for(int i = 0; i < field.length; i++){
	    for(int k = 0; k < field[i].length; k++){
		if(field[i][k]<0){
		    ans+=field[i][k];
		}
	    }
	}
	return Math.abs(ans) * 72 * 72;
    }

    public static void main(String[]args){

	try{
	    Scanner in = new Scanner(new File("makelake.txt"));
	    Scanner f = new Scanner(in.nextLine());
	    field = new int[f.nextInt()][f.nextInt()];
	    int elevation = f.nextInt();
	    int steps = f.nextInt();
	    for(int i = 0; i < field.length; i++){
		Scanner x = new Scanner(in.nextLine());
		for(int k = 0; k < field[i].length; k++){
		    field[i][k] = x.nextInt();
		}
	    }
	    for(int i = 0; i < steps; i++){
		Scanner x = new Scanner(in.nextLine());
		stomp(x.nextInt(), x.nextInt(), x.nextInt());
	    }
	    decrease(elevation);
	    System.out.println();
	    System.out.println(solve() + ",7,Ostlund,William");
	}catch(FileNotFoundException e){
	    System.out.println("Error: No valid file in this directory");
	}
    }

}
