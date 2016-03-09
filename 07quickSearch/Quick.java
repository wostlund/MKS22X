public class Quick{

    public static String name(){
	return "7,Ostlund,William";
    }

    public static int quickselect(int[]data, int place){
	return quickselect(data, 0, data.length, place+1);
    }

    public static int quickselect(int[]data, int start, int end, int place){
	//showArray(data);
	int u = (int)(Math.random()*(end - start)) + start;
	int[] j = partition(data, start, end);
	if (j[0] == place){
	    return j[1];
	}else if(j[0] > place){
	    return quickselect(data, start, j[0], place);
	}
	return quickselect(data, j[0], end, place);
    }

    public static int[] partition(int[]data, int start, int end){
	int num = data[(int)(Math.random()*(end-start))+start];
	int[]copy = new int[end-start];
	int place = 0;
	for(int i = start; i < end; i++){
	    if(data[i] < num){
		copy[place] = data[i];
		place++;
	    }
	}
	int k = place + start;
	for(int i = start; i < end; i++){
	    if(data[i] >= num){
		copy[place] = data[i];
		place++;
	    }
	}
	for(int i = 0; i < copy.length; i++){
	    data[i + start] = copy[i];
	}
	int[]ans = new int[2];
	if(copy[k-start] == num){
	    if((int)(Math.random()*2) > 1){
		ans[0] = k;
	    }else{
		ans[0] = k + 1;
	    }
	}
	ans[1] = num;
	return ans;
    }

    public static void showArray(int[]arr){
	for(int i = 0; i < arr.length; i++){
	    System.out.print(arr[i] + " ");
	}
	System.out.println();
    }
    
    public static void main(String[]args){
	int[] k = {1, 2, 5, 3, 2, 455,56 ,2 ,4 ,2, 34, 21,3, 453 ,23};
	System.out.println(quickselect(k, 0));
	System.out.println(quickselect(k, 1));
	System.out.println(quickselect(k, 2));
	System.out.println(quickselect(k, 3));
	System.out.println(quickselect(k, 4));
	System.out.println(quickselect(k, 5));
	System.out.println(quickselect(k, 6));
	System.out.println(quickselect(k, 7));
	System.out.println(quickselect(k, 8));
	System.out.println(quickselect(k, 9));
	System.out.println(quickselect(k, 10));
	System.out.println(quickselect(k, 11));
	System.out.println(quickselect(k, 12));
	System.out.println(quickselect(k, 13));
	System.out.println(quickselect(k, 14));
    }
}
