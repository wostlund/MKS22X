public class MyLinkedList{

    private class LNode{
	
	private int value;
	private LNode next;

	public LNode getNext(){
	    return this.next;
	}

	public int getValue(){
	    return this.value;
	}

	public void setValue(int k){
	    value = k;
	}

	public void setNext(LNode m){
	    next = m;
	}
	
	public LNode(int Value){
	    value = Value;
	}
    }

    private LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }
    
    public int size(){
	return size;
    }


    public int get(int index){
	LNode last = start;
	for(int i = 0; i < index; i++){
	    last = last.getNext();
	}
	return last.getValue();
    }

    public int set(int index, int newValue){
	LNode last = start;
	for(int i = 0; i < index; i++){
	    last = last.getNext();
	}
	int k = last.getValue();
	last.setValue(newValue);
	return k;
    }

    public boolean add(int index, int newValue){
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

    public boolean add(int newValue){
	return this.add(size, newValue);
    }

    public int indexOf(int value){
	LNode last = this.start;
	for(int i = 0; i < this.size; i++){
	    if(last.getValue() == value){
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

    public int remove(int index){
	if (index < 0 || index >= size){
	    return -1;
	}
	int k = 0;
	LNode before = null;
	LNode current = start;
	if(index == 0){
	    int m = start.getValue();
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
	k = current.getValue();
	before.setNext(current.getNext());
	return k;
    }

    public static void main(String[]args){
	MyLinkedList k = new MyLinkedList();
	k.add(2);
	k.add(3);
	k.add(5);
	k.add(2,4);
	k.add(1, 2345678);
	k.add(0, 34);
	k.remove(0);
	k.set(0, 0);
	k.get(0);
	System.out.println(k.get(4));
	k.remove(1);
	System.out.println(k);
    }
}
