import java.util.*;

public class MyStack<T>{

    private MyLinkedList<T> data;

    public MyStack(){
	data = new MyLinkedList<T>();
    }

    public void push(T item){
	data.add(0,item);
    }

    public T pop(){
	if(data.size() == 0){
	    throw new NoSuchElementException();
	}
	return data.remove(0);
    }

    public T peek(){
	if(data.size() == 0){
	    throw new NoSuchElementException();
	}
	return data.get(0);
    }

    public int size(){
	return data.size();
    }

    public boolean isEmpty(){
	return data.size()==0;
    }

    public String toString(){
	return data.toString();
    }

    public static void main(String[]args){
	MyStack<Integer> tester = new MyStack<Integer>();
	Stack<Integer> actual = new Stack<Integer>();
	for(int i = 0; i < 20; i++){
	    int g = (int)(Math.random()*50);
	    tester.push(g);
	    actual.push(g);
	    System.out.println(tester);
	    System.out.println(actual);
	    System.out.println("-------------------------------------------");
	}
    }
}
