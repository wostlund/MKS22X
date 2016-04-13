import java.util.*;

public class FrontierStack<T> implements Frontier<T>{

    private MyLinkedList<T> data;

    public FrontierStack(){
	data = new MyLinkedList<T>();
    }

    public T next(){
	return this.pop();
    }

    public boolean hasNext(){
	return !this.isEmpty();
    }

    public void add(T element){
	this.push(element);
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

}
