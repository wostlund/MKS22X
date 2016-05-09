public class MyDeque<T>{

    private T[] data;
    private int index, size;
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (T[])new Object[10];
	index = 0;
    }

    public int size(){
	return size;
    }

    private void resize(){
	int k = 0;
	int c = size;
	T[] ans = (T[])new Object[data.length * 2];
	for(int i = data.length*2 - 1; size != 0 ; i--){
	    ans[i] = this.removeLast();
	    k++;
	}
	index = 0;
	size = c;
	data = ans;
    }

    public void addFirst(T value){
	//System.out.println(size+":"+data.length+":"+index);
	if(size == data.length){
	    this.resize();
	}
	int l = index;
	if(index - size - 1 < 0){
	    l = data.length + (index - size - 1);
	}else{
	    l = index - size - 1;
	}
	size++;
	data[l] = value;
    }

    public void addLast(T value){
	if(size == data.length-1){
	    this.resize();
	}
	if(index == data.length){
	    index = 0;
	}
	size++;
	data[index] = value;
	index++;
    }

    public T removeFirst(){
	int l = index;
	if(index - size < 0){
	    l = data.length + (index - size);
	}else{
	    l = index - size;
	}
	size--;
	return data[l];
    }

    public T removeLast(){
	index--;
	size--;
	if(index == -1){
	    index = data.length-1;
	}
	return data[index];
    }

    public T getFirst(){
	int l = index;
	if(index - size < 0){
	    l = data.length + (index - size);
	}else{
	    l = index - size;
	}
	return data[l];
    }

    public T getLast(){
	int l = index;
	if(l == 0){
	    return data[data.length - 1]; 
	}
	return data[l - 1];
    }

    public String toString(){
	String ans = "";
	while( size!=0){
	    ans  += " " + this.removeFirst();
	}
	return ans;
    }

    public static void main(String[]args){
	MyDeque<Integer> mike = new MyDeque<Integer>();
	for(int i = 0; i < 25; i++){
	    mike.addFirst(i);
	}
	System.out.println(mike);
    }
}
