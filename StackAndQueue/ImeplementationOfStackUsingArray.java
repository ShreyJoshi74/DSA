

public class Main
    
{   
    // Globally declared parameter for stack
    static int cnt = 0;
    static int top = -1;
    static int[] arr = new int[5];
    public static int add(int num){
        cnt++;
        if(cnt > arr.length ) {
            cnt--;
            System.out.println("Stack is full");
            return -1;
        }else{
            top++;
            arr[top] = num;
            return num;
        }
    }
    public static int pop(){
        cnt--;
        if(cnt < 0){
            top = -1;
            cnt = 0;
            System.out.println("Stack is Empty");
            return -1;
            
        }else{
            top--;
            return 0;
        }
    }
    public static void top() {System.out.println(arr[top]);}
    public static void size() {System.out.println(cnt);}
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] arr = new int[5];
		pop();
	    add(5);
		add(6);
		top();
		size();
		add(7);
		add(7);
		add(7);
		add(7);
		add(7);
		size();
		pop();
		pop();
		pop();
		pop();
		pop();
		pop();
		pop();
		add(3);
		top();
		
	}
}
