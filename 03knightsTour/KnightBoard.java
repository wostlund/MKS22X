public class KnightBoard{
    int[][]board;

    public String name(){
	return "Ostlund, William";
    }

    public KnightBoard(int length, int width){
	board = new int[length][width];
    }

    public KnightBoard(int n){
	this(n,n);
    }
	
    private boolean place(int row, int col, int value){
	if(row < 0 || row >= board.length || col <0 || col >= board[0].length ||
	   board[row][col]!=0){
	    return false;
	}
	board[row][col] = value;
	return true;
    }

    private void resetBoard(){
	for(int h = 0; h < board.length; h++){
	    for(int k = 0; k < board[h].length; k++){
		board[h][k] = 0;
	    }
	}
    }

    private void revertBack(){
	int maxX = 0;
	int maxY = 0;
	int maxValue = board[0][0];
	for(int h = 0; h < board.length; h++){
	    for(int k = 0; k < board[h].length; k++){
		if(board[h][k] > maxValue){
		    maxX = h;
		    maxY = k;
		    maxValue = board[h][k];
		}
	    }
	}
	board[maxX][maxY] = 0;
    }

    public boolean solve(){
	return solveHelper();
    }

    public boolean solveHelper(){
	for(int i = 0; i<board.length; i++){
	    for(int k =0; k<board[i].length; k++){
		if(solveH(i, k, 2)){
		    return true;
		}
		this.resetBoard();
	    }
	}
	return false;
    }

    public boolean solveH(int posRow, int posCol, int turn){
	//display();
	place(posRow, posCol,  turn-1);
	//System.out.print("\n");
	if(turn == board.length * board[0].length+1){
	    return true;
	}else{
	    if(place(posRow + 2, posCol + 1, turn)){
		if(solveH(posRow + 2, posCol + 1, turn + 1)){
		    return true;
		}
		this.revertBack();
	    }if(place(posRow - 2, posCol + 1, turn)){
		if(solveH(posRow - 2, posCol + 1, turn + 1)){
		    return true;
		}
		this.revertBack();
	    }if (place(posRow + 2, posCol - 1, turn)){
		if(solveH(posRow + 2, posCol - 1, turn + 1)){
		    return true;
		}
		this.revertBack();
	    }if(place(posRow - 2, posCol - 1, turn)){
		if(solveH(posRow - 2, posCol - 1, turn + 1)){
		    return true;
		}
		this.revertBack();
	    }if(place(posRow + 1, posCol + 2, turn)){
		if(solveH(posRow + 1, posCol + 2, turn + 1)){
		    return true;
		}
		this.revertBack();
	    }if(place(posRow + 1, posCol - 2, turn)){
		if(solveH(posRow + 1, posCol - 2, turn + 1)){
		    return true;
		}
		this.revertBack();
	    }if(place(posRow - 1, posCol + 2, turn)){
		if(solveH(posRow - 1, posCol + 2, turn + 1)){
		    return true;
		}
		this.revertBack();
	    }if(place(posRow - 1, posCol - 2, turn)){
		if(solveH(posRow - 1, posCol - 2, turn + 1)){
		    return true;
		}
		this.revertBack();
	    }
	//this.revertBack();
	}
        //System.out.println(turn);
	return false;
    }

    public void printSolution(){
	for(int i = 0; i<board.length; i++){
	    for(int d = 0; d<board[i].length; d++){
		if(board[i][d]<10){
		    System.out.print("" + board[i][d] + "  ");
		}else{
		    System.out.print("" + board[i][d] + " ");
		}
	    }
	    System.out.print("\n");
	}
    }

    public static void main(String[]args){
	int h = Integer.parseInt(args[0]);
	int k = Integer.parseInt(args[1]);
	KnightBoard p = new KnightBoard(h, k);
        System.out.println(p.solve());
	p.printSolution();
    }
}
