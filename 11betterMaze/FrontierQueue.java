import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    private MyLinkedList<T> data;

    public FrontierQueue(){
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

    public void add(T element){
	this.enqueue(element);
    }

    public T next(){
	return this.dequeue();
    }

    public boolean hasNext(){
	return !this.isEmpty();
    }
}
