public class BSTree<T extends comparable<T>>{
    private class Node{
	private T data;
	private Node left;
	private Node right;
	private int height;

	public boolean hasChildren(){
	    return !(left != null && right != null);
	}

	public Node getRight(){
	    return right;
	}

	public Node getLeft(){
	    return left;
	}

	public void set(T val){
	    data = val;
	}

	public void setLeft(Node k){
	    left = k;
	}

	public void setRight(Node k){
	    right = k;
	}
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public getHeight(){
	return getHeight(root, 0);
    }

    public int getHeight(Node k, int height){
	if(k == null){
	    return height;
	}
	int g = getHeight(k.getLeft(), height+1);
	int k = getHeight(k.getRight(), height+1);
	if(g > k){
	    return g;
	}
	return k;
    }

    public void add(T value){
	//check for empty before you do things with root.
    }
    public String toString(){
	return toString(root);
    }

    public String toString(Node k){
	if (k == null){
	    return " _"; 
	}
	return "" + k.getValue() + " " + toString(k.getLeft()) + " " + toString(k.getRight());
    }
    
    public boolean contains(T value){
	//check for empty before you do things with root.
	return false;
    }
}import java.io.*;

public class BSTree<T implements Comparable<T>>{

    private TreeNode root;
    
}
