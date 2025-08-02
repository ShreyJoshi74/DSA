
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
public class Main
{   
    static int cnt = 0;
    static void add(int a){
        Node temp = new Node(a);
        if(cnt == 0){
            
            top = temp;
            end = temp;
            cnt++;
            System.out.println("First Element Added: " + a);
        }else{
            cnt++;
            end.next = temp;
            end = end.next;
            System.out.println("Element Added: " + a);
            
        }
    }
    static void pop(){
        if(cnt == 0) System.out.println("Queue is Already Empty!");
        else{
            cnt--;
            System.out.println("Element popped: " + top.data );
            top = top.next;
            if(cnt == 0) end = end.next;
            
        }
    }
    static void size(){
        System.out.println("Size of Queue is: " + cnt);
    }
    static void peek(){
        System.out.println("First Element of Queue is: " + top.data);
    }
    
    static Node top = new Node(-1);
    static Node end = new Node(-1);
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(top.next);
		add(7);
		add(6);
		add(5);
		add(4);
		peek();
		pop();
		pop();
		peek();
		pop();
		size();
		pop();
		pop();
		pop();
		add(7);
		peek();
		size();
		pop();
		
		
	}
}
