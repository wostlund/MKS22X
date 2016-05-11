public class RunningMedian{

    private MyHeap<Integer> max;
    private MyHeap<Integer> min;
    private double median;

    public RunningMedian(){
	max = new MyHeap<Integer>(false);
	min = new MyHeap<Integer>(true);
	this.median = 0;
    }

    public void add(Integer x){
	if(x > median){
	    max.add(x);
	}else{
	    min.add(x);
	}
	this.calcMedian();
    }

    public void calcMedian(){
	if(max.size() - min.size() == 2){
	    min.add(max.delete());
	}else if(min.size() - max.size() == 2){
	    max.add(min.delete());
	}
	max.heapify();
	min.heapify();
	if(max.size() > min.size()){
	    median = (double)max.peek();
	}else if (min.size() > max.size()){
	    median = (double)min.peek();
	}else{
	    median = ((double)(min.peek()) + (double)max.peek()) / 2.0;
	}
    }

    public double getMedian(){
	return this.median;
    }

    public static void main(String[]args){
	RunningMedian tester = new RunningMedian();
	if(args.length > 0){
	    for(int i = 0; i<args.length; i++){
		tester.add(Integer.parseInt(args[i]));
	    }
	}else{
	    for(int i = 0; i < 12; i++){
		tester.add(i);
	    }
	}
	System.out.println(tester.max.size());
	System.out.println(tester.min.size());
	System.out.println(tester.max);
	System.out.println(tester.min);	
	System.out.println(tester.getMedian());
    }
}
