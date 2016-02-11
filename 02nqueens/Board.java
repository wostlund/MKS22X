public class Board{
    private int[][]board;
    
    public Board(int n){
	board = new int[n][n];
    }
    
    public boolean solve(){
	return solveHelper(0, 0, 1);
    }

    private boolean solveHelper(int col, int row, int inc){
	if(row == board.length){
	    removeQueen(col, false, 435);
	    return removeQueen(col-1, true, inc+1);
	}
	if(col == board.length-1 && board[row][col] == 0){
	    this.addQueen(row, col);
	    return true;
	}
	if(inc == board.length * board.length){
	    return false;
	}
	if(board[row][col] == 0){
	    this.addQueen(row, col);
	    return solveHelper(col+1, 0, inc+1);
	}
	return solveHelper(col, row+1, inc+1);
    }

    private boolean removeQueen(int col, boolean k, int inc){
	for(int i=0; i<board.length ; i++){
	    if(board[i][col] == 1){
		removeQueen(i, col);
		if(k){
		    return solveHelper(col, i+1, inc);
		}
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
	Board k = new Board(Integer.parseInt(args[0]));
	if(true || k.solve()){
	    k.solve();
	    //System.out.println(k.solve());
	    System.out.println();
	    System.out.println(k);
	}
    }
}
