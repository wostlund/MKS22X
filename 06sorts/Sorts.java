public class Sorts{
    
    public static void selectionSort(int[]jeff){
	for(int i=0; i<jeff.length-1; i++){
	    int min = i;
	    int p = jeff[i];
	    for(int q=i; q<jeff.length; q++){
		if (jeff[min]>jeff[q]){
		    min=q;
		}
	    }
	    p=jeff[min];
	    jeff[min]=jeff[i];
	    jeff[i]=p;
	}
    }

    public static void insertionSort(int[]jeff){
	for (int i=0; i<jeff.length; i++){
	    for(int p=i; p>0 && jeff[p]<jeff[p-1] ; p--){
		int k = jeff[p];
		jeff[p]=jeff[p-1];
		jeff[p-1] = k;
	    }
	}
    }

    public static void bubbleSort(int[]jeff){
	boolean frank = true;
	for(int i=jeff.length; i>-1; i--){
	    for(int k=0; k<i-1; k++){
		if(jeff[k]>jeff[k+1]){
		    int a = jeff[k];
		    jeff[k]=jeff[k+1];
		    jeff[k+1]=a;
		    frank=false;
		}
	    }
	    if(frank){
		return;
	    }
	}
    }

    public static void mergeSort(int[]jeff){
	int[]k = jeff;
	mergeHelper(k, k.length, 1);
    }

    public static void mergeHelper(int[]holder, int arrays, int step){
	if(arrays == 1){
	    return;
	}
	int k = step;
	int p = 0;
	for(int i = 0; i<holder.length; i+= k*2){
	    if(i+(k*2) > holder.length && i+k < holder.length){
		interleave(holder, i, i+k, holder.length);
	    }else if (i + (2*k) <= holder.length){		
		interleave(holder, i, i+k, i+(2*k));
	    }
	    p++;
	}
	mergeHelper(holder, p, step*2);
    }

    public static void interleave(int[]holder,int start1, int start2, int end){
	int place1 = start1;
	int place2 = start2;
	int[] ans = new int[end-start1];
	for(int i = 0; i < end-start1; i++){
	    if(place1 == start2){
		ans[i] = holder[place2];
		place2++;
	    }else if(place2 == end || holder[place2] >= holder[place1]){
		ans[i] = holder[place1];
		place1++;
	    }else{
		ans[i] = holder[place2];
		place2++;
	    }
	}
	for(int i = start1; i < end; i++){
	    holder[i] = ans[i-start1];
	}
    }

    public static void fillRandom(int[]jeff){
	for(int i=0; i<jeff.length; i++){
	    jeff[i]=(int)(Math.random()*100000);
	}
    }

    public static void swap(int[]jeff, int p, int q){
	int a = jeff[p];
	jeff[p]=jeff[q];
	jeff[q]=a;
    }
    
    public static void main(String[]args){
	int[] m = {2, 4, 1, 2, 4, 2, 12, 4, 3, 23, 43, 234, 43, 342, 1};
	int[] l = {3, 2, 5, 2, 4, 32};
	int[] k = {2, 4, 23, 54, 3, 4, 5, 6, 12, 45};
	mergeSort(l);
	showArray(l);
    }

    public static void showArray(int[] m){
    	for(int i=0; i<m.length; i++){
	    System.out.print(m[i]+" ");
	}
	System.out.println();
    }
}
