public class RunningMedain{

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
	    max.heapify();
	}else{
	    min.add(x);
	    min.heapify();
	}
	median = null;
	this.calcMedian();
    }

    public void calcMedian(){
	if(max.size() > min.size()){
	    median = (double)max.peek().value();
	}else if (min.size() > max.size()){
	    median = (double)min.peek().value();
	}else{
	    median = (double)(min.peek().value() + max.peek().value()) / 2.0;
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
	    for(int i = 0; i < 9; i++){
		tester.add(i);
	    }
	}
	System.out.println(tester.getMedian());
    }
}
