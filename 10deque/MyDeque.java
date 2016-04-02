public class MyDeque<T>{

    private T[] data;
    private int index, size;
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (T[])new Object[10];
	index = 0;
    }

    private void resize(){
	T[] ans = (T[])new Object[data.length * 2];
	int k = index;
	int i;
	for(i = 0; i < data.length; i++){
	    if(k >= data.length){
		k = 0;
	    }
	    ans[i] = data[k];
	    k++;
	}
	data = ans;
	index = i;
   }

    public void addFirst(T value){
	if(size == data.length){
	    resize();
	}
	int l = index;
	if(index - size < 0){
	    l = data.length + (index - size);
	}else{
	    l = index - size;
	}
	size++;
	data[l] = value;
    }

    public void addLast(T value){
	if(size == data.length){
	    resize();
	}
	if(index == data.length){
	    index = 0;
	}
	size++;
	data[index] = value;
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
	if(index - size < 0){
	    l = data.length + (index - size);
	}else{
	    l = index - size;
	}
	return data[l];
    }

}
