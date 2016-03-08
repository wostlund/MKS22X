public class Driver1{
    public static int[] createArray(int n){
	int[] ans = new int[n];
	for(int i = 0; i<n; i++){
	    ans[i] = (int)(Math.random() * 1000);
	}
	return ans;
    }

    public static void showArray(int[] arr){
	for(int i = 0; i < arr.length; i++){
	    System.out.print(arr[i] + " ");
	}
	System.out.println();
    }

    public static void main(String[]args){
	try{
	    int[]ans = createArray(Integer.parseInt(args[0]));
	    showArray(ans);
	    Sorts.mergesort(ans);
	    showArray(ans);
	}catch(IndexOutOfBoundsException e){
	    int[]ans = createArray(20);
	    showArray(ans);
	    Sorts.mergesort(ans);
	    showArray(ans);
	}
    }
}
