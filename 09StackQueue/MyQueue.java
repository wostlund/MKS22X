import java.util.*;

public class MyQueue<T>{
    private MyLinkedList<T> data;

    public MyQueue(){
	data = new MyLinkedList<T>();
    }

    public void enqueue(T item){
	data.add(item);
    }

    public T dequeue(){
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
}
