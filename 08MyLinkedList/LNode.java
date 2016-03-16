public class LNode{

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
