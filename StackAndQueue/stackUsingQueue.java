import java.util.*;

public class Main {   
    static Queue<Integer> q = new LinkedList<>();

    public static void add(int num) {
        q.add(num);
        System.out.println("done");
    }

    public static void pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            List<Integer> ls = new ArrayList<>(q);
            Collections.reverse(ls);
            System.out.println(ls.remove(0));
            q.clear();
            Collections.reverse(ls);
            q.addAll(ls);
        }
    }

    public static void size() {
        System.out.println(q.size());
    }

    public static void top() {
        if (q.isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            List<Integer> ls = new ArrayList<>(q);
            Collections.reverse(ls);
            System.out.println(ls.get(0));
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        add(5);
        add(5);
        add(3);
        add(0);
        add(8);
        add(6);
        top();   // Should show 6
        pop();   // Should remove 6
        pop();   // Should remove 8
        pop();   // Should remove 0
        pop();   // Should remove 3
        pop();   // Should remove 5
        pop();   // Should remove 5
        pop();   // Should show empty
        top();   // Should show empty
        pop();   // Should show empty
        size();  // Should show 0
        top();   // Should show empty
    }
}
