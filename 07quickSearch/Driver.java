import java.util.Arrays;

public class Driver{
    public static void main(String[]args){
	double[][]storage = new double[3][3];
	for(int n = 0; n<3; n++){
	    int[] d = new int [4000000];
	    int[] c = new int [d.length];
	    int[] e = new int [d.length];
	    for(int i = 0; i < d.length; i++){
		d[i] = (int)(Math.random()*Integer.MAX_VALUE);
		c[i] = d[i];
		e[i] = c[i];
	    }
	    System.out.println("Sorting an array of numbers from 0 to MAX_VALUE");
	    System.out.println("Trial " + n);
	    long start1 = System.currentTimeMillis();
	    Quick.quickSortOld(e);
	    long end1 = System.currentTimeMillis();
	    storage[0][n] = (end1-start1)/1000.0;
	    System.out.println("Time for old sort: "+ storage[0][n] + " seconds");
	    start1 = System.currentTimeMillis();
	    Quick.quickSort(c);
	    end1 = System.currentTimeMillis();
	    storage[1][n] = (end1-start1)/1000.0;
	    System.out.println("Time for new sort: "+ storage[1][n] + " seconds");
	    start1 = System.currentTimeMillis();
	    Arrays.sort(d);
	    end1 = System.currentTimeMillis();
	    storage[2][n] = (end1-start1)/1000.0;
	    System.out.println("Time for built in sort: "+ storage[2][n] + " seconds");
	    System.out.println("Done: Sorted="+Arrays.equals(d,e));
	    System.out.println();
	}
	System.out.println("Average time for old quick sort: "+
			   (storage[0][0] + storage[0][1] + storage[0][2])/3.0);
	System.out.println("Average time for new quick sort: "+
			   (storage[1][0] + storage[1][1] + storage[1][2])/3.0);
	System.out.println("Average time for system sort: "+
			   (storage[2][0] + storage[2][1] + storage[2][2])/3.0);
    
	storage = new double[3][3];
	for(int n = 0; n<3; n++){
	    int[] d = new int [40];
	    int[] c = new int [d.length];
	    int[] e = new int [d.length];
	    for(int i = 0; i < d.length; i++){
		d[i] = (int)(Math.random()*4);
		c[i] = d[i];
		e[i] = c[i];
	    }
	    System.out.println("Sorting an array of numbers from 0 to 4");
	    System.out.println("Trial " + n);
	    long start1 = System.currentTimeMillis();
	    //Quick.quickSortOld(e);
	    long end1 = System.currentTimeMillis();
	    storage[0][n] = (end1-start1)/1000.0;
	    System.out.println("Time for old sort: "+ storage[0][n] + " seconds");
	    start1 = System.currentTimeMillis();
	    Quick.quickSort(c);
	    end1 = System.currentTimeMillis();
	    storage[1][n] = (end1-start1)/1000.0;
	    System.out.println("Time for new sort: "+ storage[1][n] + " seconds");
	    start1 = System.currentTimeMillis();
	    Arrays.sort(d);
	    end1 = System.currentTimeMillis();
	    storage[2][n] = (end1-start1)/1000.0;
	    System.out.println("Time for built in sort: "+ storage[2][n] + " seconds");
	    System.out.println("Done: Sorted="+Arrays.equals(d,c));
	    System.out.println();
	}
	System.out.println("Average time for old quick sort: "+
			   (storage[0][0] + storage[0][1] + storage[0][2])/3.0);
	System.out.println("Average time for new quick sort: "+
			   (storage[1][0] + storage[1][1] + storage[1][2])/3.0);
	System.out.println("Average time for system sort: "+
			   (storage[2][0] + storage[2][1] + storage[2][2])/3.0);
    }
}
