
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
public class Main
{   static int cnt=0;
    static void add(int a){
        Node temp = new Node(a);
        cnt++;
        temp.next = top;
        System.out.println("Element is added: "+ a);
        top = temp;
       
    }
    
    static void pop(){
        
        if(cnt == 0){
            System.out.println("Stack is Empty!");
            
        }else{
            cnt--;
            System.out.println("Element Popped is: " + top.data);
            top = top.next;
            
        }
    }
    static void size(){
        System.out.println("size is :" + cnt);
    }
    static void top(){
        if(top.data == -1) System.out.println("Stack is Empty!");
        else System.out.println("Top Element is : " + top.data);
    }
    static Node top = new Node(-1);
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(top.next);
		top();
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		pop();
		pop();
		top();
		pop();
		pop();
		pop();
		pop();
		top();
		pop();
		add(4);
		top();
		size();
		
	}
}
