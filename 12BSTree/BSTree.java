import java.io.*;

public class BSTree<T extends Comparable<T>>{
    private class Node{
	private T data;
	private Node left;
	private Node right;

	public Node(T value){
	    data = value;
	    
	}
	
	public boolean hasChildren(){
	    return !(left != null && right != null);
	}

	public T getValue(){
	    return data;
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
    public int getHeight(){
	return getHeight(root, 0);
    }

    private int getHeight(Node k, int height){
	if(k == null){
	    return height;
	}
	int g = getHeight(k.getLeft(), height+1);
	int ka = getHeight(k.getRight(), height+1);
	if(g > ka){
	    return g;
	}
	return ka;
    }

    public void add(T value){
	add(value, root);
    }

    private void add(T value, Node current){
	if(current == null){
	    root = new Node(value);
	    return;
	}
	if(value.compareTo(current.getValue()) > 0){
	    if(current.getRight() == null){
		current.setRight(new Node(value));
		return;
	    }
	    add(value, current.getRight());
	    return;
	}
	if(current.getLeft() == null){
	    current.setLeft(new Node(value));
	    return;
	}
	add(value,current.getLeft());
    }
    
    public String toString(){
	return toString(root);
    }

    public String toString(Node k){
	if (k == null){
	    return " _"; 
	}
	return " " + k.getValue() + " " + toString(k.getLeft()) + " " + toString(k.getRight());
    }
    
    public boolean contains(T value){
        return contains(value, root);
    }

    private boolean contains(T value, Node current){
	if (current == null){
	    return false;
	}
	else if(current.getValue().compareTo(value) == 0){
	    return true;
	}
	return contains(value, current.getLeft()) || contains(value, current.getRight());
    }

    public static void main(String[]args){
	BSTree<Integer> mark = new BSTree<Integer>();
        mark.add(new Integer(8));
	mark.add(new Integer(3));
	mark.add(new Integer(1));
	mark.add(new Integer(3));
	mark.add(new Integer(6));
	mark.add(new Integer(4));
	System.out.println(mark);
	System.out.println(mark.getHeight());
    }
}
