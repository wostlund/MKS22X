public class MyQueue<T>{
    private MyLinkedList<T> data;

    public MyQueue(){
	data = new MyLinkedList<T>();
    }

    public void enqueue(T item){
	data.add(item);
    }

    public T dequeue(){
	return data.remove(0);
    }

    public T peek(){
	return data.get(0);
    }

    public int size(){
	return data.size();
    }

    public boolean isEmpty(){
	return data.size()==0;
    }
}
