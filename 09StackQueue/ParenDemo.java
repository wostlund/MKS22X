public class ParenDemo{

    public static boolean isMatching(String s){
	MyStack<Character> data = new MyStack<Character>();
	int i = 0;
	while (i<s.length()){
	    char c = s.charAt(i);
	    if(c == '(' || c == '[' || c == '{'){
		data.push(c);
	    }else{
		if(c == ')'){
		    if(!data.isEmpty() && data.peek() == '('){
			data.pop();
		    }else{
			return false;
		    }
		}
		else if(c == ']'){
		    if(data.size() != 0 && data.peek()== '['){
			data.pop();
		    }else{
			return false;
		    }
		}
		else if(c == '}'){
		    if(!data.isEmpty() && data.peek()== '{'){
			data.pop();
		    }else{
			return false;
		    }
		}
	    }
	    i++;
	}
	return data.isEmpty();
    }

    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
 
    }
}
