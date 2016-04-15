import java.io.*;
import java.util.Scanner;

public class BetterMaze{

    private class Node{
	private Node last;
	private int row;
	private int col;

	public Node(int row1, int col1){
	    row = row1;
	    col = col1;
	}

	public void setLast(Node n){
	    this.last = n;
	}
	
	public int row(){
	    return row;
	}

	public int col(){
	    return col;
	}

	public Node getLast(){
	    return last;
	}

	public boolean hasLast(){
	    return last != null;
	}
    }

    private boolean solved;

    private char[][] maze;

    private int[]    solution;

    private int      startRow,startCol;

    private Node last;
    
    private Frontier<Node> places;

    private boolean  animate;//default to false


   /**return a COPY of solution.

     *This should be : [x1,y1,x2,y2,x3,y3...]

     *the coordinates of the solution from start to end.

     *Precondition : one of the solveXXX methods has already been

     * called (
     **/
    
    public int[] solutionCoordinates(){
	if(last == null){
	    return null;
	}
	Frontier<Integer> holder = new FrontierStack<Integer>();
	Node k = last;
	holder.add(last.col());
	holder.add(last.row());
	int i = 0;
	while (k.hasLast()){
	    Node m = k.getLast();
	    int row = m.row();
	    int col = m.col();
	    holder.add(col);
	    holder.add(row);
	    k = m;
	    i+=2;
	}
	int[] ans = new int[i];
	for(i = 0; i<ans.length; i++){
	    ans[i] = holder.next();
	}
	solution = ans;
	return ans;

    }    


    /**initialize the frontier as a queue and call solve
    **/


    public boolean solveBFS(){
	places = new FrontierQueue<Node>();
        return this.solve();
    }


   /**initialize the frontier as a stack and call solve
    */ 
    public boolean solveDFS(){  
        places = new FrontierStack<Node>();
	return this.solve();
    }

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){
	solved = false;
	places.add(new Node(startRow, startCol));
	while (places.hasNext()){
	    Node m = places.next();
	    int row = m.row();
	    int col = m.col();
	    if(m.getLast() != null){
		maze[m.getLast().row()][m.getLast().col()] = '.';
	    }
	    maze[row][col] = 'x';
	    if(animate){
		System.out.println(this);
		wait(40);
	    }
	    if(maze[row][col+1] == 'E'){
		maze[row][col+1] = '@';
		maze[startRow][startCol] = '@';
		last = new Node(row, col+1);
		last.setLast(m);
		Node k = last;
		answerVis(k);
		return true;
	    }if(maze[row][col-1] == 'E'){
		maze[row][col-1] = '@';
		maze[startRow][startCol] = '@';
		last = new Node(row, col-1);
		last.setLast(m);
		Node k = last;
		answerVis(k);
		return true;
	    }if(maze[row-1][col] == 'E'){
		maze[startRow][startCol] = '@';
		last = new Node(row-1, col);
		last.setLast(m);
		Node k = last;
		maze[row-1][col] = '@';
		answerVis(k);
		return true;
	    }if(maze[row+1][col] == 'E'){
		maze[startRow][startCol] = '@';
		last = new Node(row+1, col);
		last.setLast(m);
		Node k = last;
		maze[row+1][col] = '@';
		answerVis(k);
		return true;
	    }
	    if(maze[row][col+1] == ' '){
		Node l = new Node(row, col+1);
		l.setLast(m);
		places.add(l);
	    }if(maze[row][col-1] == ' '){
		Node l = new Node(row, col-1);
		l.setLast(m);
		places.add(l);
	    }if(maze[row+1][col] == ' '){
		Node l = new Node(row+1, col);
		l.setLast(m);
		places.add(l);
	    }if(maze[row-1][col] == ' '){
		Node l = new Node(row-1, col);
		l.setLast(m);
		places.add(l);
	    }

	    if(maze[row][col+1] != ' ' && maze[row][col-1] != ' ' &&
	       maze[row-1][col] != ' ' && maze[row+1][col] != ' '){
		maze[row][col] = '.';
	    }
	}
	return false;
    }

    public static void main(String[]args){
	BetterMaze z = new BetterMaze("data3.dat");
	if(args.length > 0){
	    if(args[0].equals("true")){
		z.setAnimate(true);
		z.clearTerminal();
	    }
	    if(args.length > 1){
		if(args[1].equals("DFS")){
		    System.out.println(z.solveDFS());
		}else if(args[1].equals("BFS")){
		    System.out.println(z.solveBFS());
		}else{
		    System.out.println("No such search available!");
		    return;
		}
	    }
	}
	z.printArray(z.solutionCoordinates());
    }

    public void printArray(int[]args){
	for(int i =0; i<args.length; i++){
	    System.out.print(args[i] + " ");
	}
	System.out.println();
    }
     
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){
	animate = b;
    }    


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }

    public boolean answerVis(Node m){
	maze[startRow][startCol] = '@';
	while(m.hasLast()){
	    Node k = m.getLast();
	    int row = m.row();
	    int col = m.col();
	    maze[row][col] = '@';
	    m = k;
	}
	System.out.println(this);
	solved = true;
	return true;
    }





    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
    


       
    
    

}
