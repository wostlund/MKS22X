import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{

    private class LNode{
	
	private T value;
	private LNode next;
	private LNode last;

	public LNode getNext(){
	    return this.next;
	}

	public LNode getLast(){
	    return this.last;
	}

	public void setLast(LNode m){
	    last = m;
	}

	public T getValue(){
	    return this.value;
	}

	public void setValue(T k){
	    value = k;
	}

	public void setNext(LNode m){
	    next = m;
	}
	
	public LNode(T Value){
	    value = Value;
	}
    }

    public Iterator<T> iterator(){
	return new X();
    }

    public class X implements Iterator<T>{
	private LNode current;

	public X(){
	    current = start;
	}

	public boolean hasNext(){
	    return current != null;
	}

	public T next(){
	    if(!this.hasNext()){
		throw new NoSuchElementException("Check for hasNext() next time, fool");
	    }
	    T ans = current.getValue();
	    current = current.getNext();
	    return ans;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }

    private LNode start, end;
    private int size;

    //public MyLinkedList(){
    //	start = null;
    //	size = 0;
    //}

    public MyLinkedList(){
	start = null;
	end = null;
	size = 0;
    }
    
    public int size(){
	return size;
    }


    public T get(int index){
	if(index < 0 || index > size - 1){
	    throw new IndexOutOfBoundsException("Your index don't work too good");
	}
	LNode last = start;
	if(index < size/2){
	    for(int i = 0; i < index; i++){
		last = last.getNext();
	    }
	}else{ 
	    last = end;
	    for(int i = size - 1; i > index - 1; i--){
		last = last.getLast();
	    }
	}
	return last.getValue();
    }

    public T set(int index, T newValue){
	if(index < 0 || index > size - 1){
	    throw new IndexOutOfBoundsException("Your index don't work too good");
	}
	LNode last = start;
	for(int i = 0; i < index; i++){
	    last = last.getNext();
	}
	T k = last.getValue();
	last.setValue(newValue);
	return k;
    }

    public boolean add(int index, T newValue){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException("Your index don't work too good");
	}
	LNode a = new LNode(newValue);
	if(index < 0 || index > size){
	    return false;
	}else if(index == 0){
	    a.setNext(start);
	    this.start = a;
	    this.size ++;
	    return true;
	}
	LNode last = this.start;
	int k = 1;
	while(k != index){
	    last = last.getNext();
	    k++;
	}
	a.setNext(last.getNext());
	a.setLast(last);
	last.setNext(a);
	if(a.getNext()!=null){
	    a.getNext().setLast(a);
	}
	this.size++;
	return true;
    }

    public boolean add(T newValue){
	return this.add(size, newValue);
    }

    public int indexOf(T value){
	LNode last = this.start;
	for(int i = 0; i < this.size; i++){
	    if(last.getValue().equals(value)){
		return i;
	    }
	    last = last.getNext();
	}
	return -1;
    }

    public String toString(){
	LNode chooser = this.start;
	String ans = "[ ";
	while(chooser != null){
	    ans += chooser.getValue() + ", ";
	    chooser = chooser.getNext();
	}
	return ans.substring(0, ans.length() - 2)+ " ]";
    }

    public T remove(int index){
	if(index < 0 || index > size - 1){
	     throw new IndexOutOfBoundsException("Your index don't work too good");
	}
	T s;
	int k = 0;
	LNode before = null;
	LNode current = start;
	if(index == 0){
	    T m = start.getValue();
	    start = start.getNext();
	    start.setLast(null);
	    return m;
	}
	while(k != index){
	    if(k == index - 1){
		before = current;
	    }
	    if(k != index - 1){
		current = current.getNext();
	    }
	    k++;
	}
	s = current.getValue();
	if(current.getNext() != null){
	    before.setNext(current.getNext());
	    current.getNext().setLast(before);
	}else{
	    before.setNext(null);
	}
	size --;
	return s;
    }
    
    public static void main(String[]args){
	MyLinkedList<String> k = new MyLinkedList<String>();
	k.add("I");
	k.add("wish");
	k.add("I");
	k.add(2,"were");
	k.add(1, "good");
	k.add(0, "at");
	k.remove(0);
	k.set(0, "CS");
	k.get(0);
	System.out.println(k.get(4));
	k.remove(1);
	System.out.println(k);
	
    }
}
