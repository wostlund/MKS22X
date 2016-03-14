public class Quick{

    public static String name(){
	return "7,Ostlund,William";
    }

    public static int quickSelectOld(int[]data, int place){
	return quickSelectOld(data, 0, data.length-1, place);
    }

    public static int quickSelectOld(int[]data, int start, int end, int place){
	//showArray(data);
	int u = (int)(Math.random()*(end - start)) + start;
	int j = partitionOld(data, start, end);
	if (j == place){
	    return data[j];
	}else if(j > place){
	    return quickSelectOld(data, start, j-1, place);
	}
	return quickSelectOld(data, j+1, end, place);
    }

        private static void swap(int[] ary, int a, int b){
	int temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
    }
    //I tried to remake Mr. K's code after class since mine was not optimized to sort a 4,000,000 element array
	
    public static int partitionOld(int[] data, int left, int right){
	int index = left + (int)(Math.random()*(right - left + 1)); 
	int pos = data[index];
	swap(data, index, right);
	int ret = left;
	for(int i=left; i<right; i++){
	    if(data[i] < pos){
		swap(data, ret, i);
		ret++;
	    } 
	}
	swap(data, right, ret);
	return ret;
    }

    public static void showArray(int[]arr){
	for(int i = 0; i < arr.length; i++){
	    System.out.print(arr[i] + " ");
	}
	System.out.println();
    }

    public static void quickSortOld(int[] data) {
        quickSortOld(data, 0, data.length - 1);
    }

    public static void quickSortOld(int[] data, int left, int right) {
        if (right-left > 0) {
            int index = partitionOld(data, left, right);
            quickSortOld(data, left, index - 1);
            quickSortOld(data, index+1, right);
        }
    }

        public static int[] partition(int[] arr, int left, int right){
	int index = (int)(Math.random() * (right - left) + left);
	int num = arr[index];
	//System.out.print(num + " " + left + " " + right + "       ");
	//showArray(arr);
	int start = left;
	int end = right-1;
	int i = start;
	while(i<=end){
	    if(arr[i] < num){
		int k = arr[i];
		arr[i] = arr[start];
		arr[start] = k;
		i++;
		start++;
	    }else if(arr[i] > num){
		int k = arr[i];
		arr[i] = arr[end];
		arr[end] = k;
		end --;
	    }else{
		i++;
	    }
	}
	int[]ans = {start, end, arr[start]};
	return ans;
    }

    public static int quickSelect(int[]data, int place){
	return quickSelect(data, 0, data.length, place);
    }

    public static int quickSelect(int[]data, int start, int end, int place){
	//showArray(data);
	int u = (int)(Math.random()*(end - start)) + start;
	int[] j = partition(data, start, end);
	if (place >= j[0] && place <= j[1]){
	    return j[2];
	}else if(j[0] > place){
	    return quickSelect(data, start, j[0], place);
	}
	return quickSelect(data, j[1], end, place);
    }

    public static void quickSort(int[]arr){
	quickSort(arr, 0, arr.length);
    }

    public static void quickSort(int[] arr, int start, int end){
	if(end - start < 2){
	    return;
	}
	int[] k = partition(arr, start, end);
	quickSort(arr, start, k[0]);
	quickSort(arr, k[1], end);
    }
    
    public static void main(String[]args){
	int[] k = {1, 2, 5, 3, 2, 455,56 ,2 ,4 ,2, 34, 21,3, 453 ,23};
        System.out.println(quickSelectOld(k, 0));
	System.out.println(quickSelectOld(k, 1));
	System.out.println(quickSelectOld(k, 2));
	System.out.println(quickSelectOld(k, 3));
	System.out.println(quickSelectOld(k, 4));
	System.out.println(quickSelectOld(k, 5));
	System.out.println(quickSelectOld(k, 6));
	System.out.println(quickSelectOld(k, 7));
	System.out.println(quickSelectOld(k, 8));
	System.out.println(quickSelectOld(k, 9));
	System.out.println(quickSelectOld(k, 10));
	System.out.println(quickSelectOld(k, 11));
	System.out.println(quickSelectOld(k, 12));
	System.out.println(quickSelectOld(k, 13));
	System.out.println(quickSelectOld(k, 14));
	
	showArray(k);
    }
}
