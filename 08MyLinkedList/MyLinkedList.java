public class MyLinkedList<T>{

    private class LNode{
	
	private T value;
	private LNode next;

	public LNode getNext(){
	    return this.next;
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

    private LNode start;
    private int size;

    //public MyLinkedList(){
    //	start = null;
    //	size = 0;
    //}

    public MyLinkedList(){
	start = null;
	size = 0;
    }
    
    public int size(){
	return size;
    }


    public T get(int index){
	LNode last = start;
	for(int i = 0; i < index; i++){
	    last = last.getNext();
	}
	return last.getValue();
    }

    public T set(int index, T newValue){
	LNode last = start;
	for(int i = 0; i < index; i++){
	    last = last.getNext();
	}
	T k = last.getValue();
	last.setValue(newValue);
	return k;
    }

    public boolean add(int index, T newValue){
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
	last.setNext(a);
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
	if (index < 0 || index >= size){
	    return null;
	}
	T s;
	int k = 0;
	LNode before = null;
	LNode current = start;
	if(index == 0){
	    T m = start.getValue();
	    start = start.getNext();
	    return m;
	}
	while(k!= index){
	    if(k == index - 1){
		before = current;
	    }
	    current = current.getNext();
	    k++;
	}
	s = current.getValue();
	before.setNext(current.getNext());
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
