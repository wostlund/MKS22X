public class MyStack<T>{

    private MyLinkedList<T> data;

    public MyStack(){
	data = new MyLinkedList<T>();
    }

    public void push(T item){
	data.add(0,item);
    }

    public T pop(){
	return data.remove(0);
    }

    public T peep(){
	return data.get(0);
    }

    public int size(){
	return data.size();
    }

    public boolean isEmpty(){
	return data.size()==0;
    }
}
