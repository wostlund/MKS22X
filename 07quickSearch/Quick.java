public class Quick{

    public static int quickselect(int[]data, int place){
	return quickselect(data, 0, data.length, place);
    }

    public static int quickselect(int[]data, int start, int end, int place){
	int u = (int)(Math.random()*(end - start)) + start;
	int j = partition(data, start, end, data[u]);
	if (j == place){
	    return data[j];
	}else if(j > end - place){
	    return quickselect(data, start, j, data[u]);
	}
	return quickselect(data, j+1, end, data[u]);
    }

    public static int partition(int[]data, int start, int end, int num){
	int[]copy = new int[end-start];
	int place = 0;
	for(int i = start; i < end; i++){
	    if(data[i] < num){
		copy[place] = data[i];
		place++;
	    }
	}
	copy[place] = num;
	int k = place + start;
	place++;
	for(int i = start; i < end; i++){
	    if(data[i] >= num){
		copy[place] = data[i];
		place++;
	    }
	}
	for(int i = 0; i < copy.length; i++){
	    data[i + start] = copy[i];
	}
	return k;
    }
}
