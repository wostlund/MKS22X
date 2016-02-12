public class QueenBoard{
    private int[][]board;

    public String name(){
	return "Ostlund,William";
    }
    
    public QueenBoard(int n){
        board = new int[n][n];
    }
    
    public boolean solve(){
	return solveH(0);
    }

    private boolean solveH(int column){
	if(column >= board.length){
	    return true;
	}else{
	    int i = 0;
	    while (i < board.length){
		if(addQueen(i, column)){
		    if(solveH(column + 1)){
			return true;
		    }
		}
		removeQueen(i, column);
		i++;
	    }
	}
	return false;
    }

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    public String toString(){
	String s = "";
	for(int i=0; i<board.length; i++){
	    for(int k =0; k<board.length; k++){
		if(board[i][k]!=1){
		    s+="_ ";
		}else{
		    s+="Q ";
		}
	    }
	    s+="\n";
	}
	return s;
    }

    public static void main(String[]args){
	QueenBoard k = new QueenBoard(Integer.parseInt(args[0]));
	if(true || k.solve()){
	    System.out.println(k.solve());
	    System.out.println();
	    System.out.println(k);
	}
    }
}
