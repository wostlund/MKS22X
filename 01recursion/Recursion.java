public class Recursion implements hw01{

    public String name(){
	return "Ostlund,William";
    }
   
    public double sqrt(double n){
	if(n<0){
	    throw(new IllegalArgumentException("The square root function only applies to positive numbers"));
	}else if(n==0){
	    return 0;
	}
	return sqrtHelper(n, 1);
    }
    
    public double sqrtHelper(double n, double guess){
	if(Math.abs((n-guess*guess)/n * 100) <= 0.0000001){
	    return guess;
	}
	return sqrtHelper(n, (n/guess + guess)/2);
    }
}
