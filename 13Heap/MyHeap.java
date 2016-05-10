import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;
    private boolean isMax;
    
    public MyHeap(){
	int size = 0;
	data = (T[])(new Comparable[34]);
    }
    
    public MyHeap(T[] array){
	int size = 0;
	int k = 2;
	while (k+1 > size){
	    k*=2;
	}
	data = (T[])(new Comparable[k+2]);
	for(int i = 1; i<array.length; i++){
	    data[i] = array[i];
	}
    }

    public void swap(T[] arr, int ind1, int ind2){
	T k = arr[ind1];
	arr[ind1] = arr[ind2];
	arr[ind2] = k;
    }
    
    private void pushDown(int k){
	if(data[2*k] == null && data[2*k+1] == null){
	    return;
	}
	if(isMax){
	    if((data[2*k + 1]== null || data[k].compareTo(data[2*k+1]) >= 0) &&
	       data[k].compareTo(data[2*k+1]) >= 0){
		return;
	    }
	    int index = 2 * k;
	    if(data[2*k + 1] != null && data[2*k + 1].compareTo(data[2*k]) >= 0){
		index++;
	    }
	    swap(data, k, index);
	    pushDown(index);
	}else{
	    if((data[2*k + 1]== null || data[k].compareTo(data[2*k+1]) <= 0) &&
	       data[k].compareTo(data[2*k]) <=0){
		return;
	    }
	    int index = 2 * k;
	    if(data[2*k + 1] != null && data[2*k + 1].compareTo(data[2*k]) <= 0){
		index++;
	    }
	    swap(data, k, index);
	    pushDown(index);
	}
    }

    private void pushUp(int k){
	if(isMax){
	    if(k==1 || data[k].compareTo(data[k/2]) <= 0){
		return;
	    }
	    int higherIndex = k/2;
	    swap(data, k, higherIndex);
	    pushUp(higherIndex);
	}else{
	    if(k==1 || data[k].compareTo(data[k/2]) >= 0){
		return;
	    }
	    int higherIndex = k/2;
	    swap(data, k, higherIndex);
	    pushUp(higherIndex);
	}
    }

    private void heapify(){
	for(int i = size; i > 0; i--){
	    pushUp(i);
	}
    }

    public T delete(){
	T k = data[1];
	data[1] = null;
	this.heapify();
	return k;
    }

    public void add(T x){
	size++;
	if(size == data.length){
	    this.doubleSize();
	}
	data[size] = x;
    }

    private void doubleSize(){
	T[] ans = (T[])(new Comparable[data.length * 2]);
	for(int i = 0; i < data.length; i++){
	    ans[i] = data[i];
	}
	data = ans;
    }

    public String toString(){
	this.heapify();
	return toString(1);
    }

    private String toString(int k){
	String ans = "[";
	for(int i = 1; i<size; i++){
	    ans += " " + data[i];
	}
	return ans + "]";
    }

    public void printlen(){
	System.out.println(data.length);
    }
	
    //do this last
    public MyHeap(boolean isMax){
	this();
	this.isMax = isMax;
    }
    public MyHeap(T[] array, boolean isMax){
	this(array);
	this.isMax = isMax;
	
    }

    public static void main(String[]args){
	MyHeap<Integer> mike = new MyHeap<Integer>(true);
	mike.add(new Integer(3));	
	mike.add(new Integer(32));	
	mike.add(new Integer(4253));	
	mike.add(new Integer(43));	
	mike.add(new Integer(32));
	mike.add(new Integer(1));
	mike.add(new Integer(3425));	
	mike.add(new Integer(33));
	mike.add(new Integer(3433));
	mike.add(new Integer(34));
	mike.add(new Integer(3323));
	mike.add(new Integer(343));
	mike.add(new Integer(34));
	mike.add(new Integer(33452));
		
	mike.heapify();
	System.out.println(mike);
    }
}
