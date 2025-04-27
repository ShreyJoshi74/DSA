//Hello Here I have written code for bitmasking
// It helps to store a set using integer value (using binary representation)


public class Main
{   public static int add(int subset, int element) {
        return subset | (1 << (element - 1));
    }

    public static int delete(int subset,int element){
        return subset & ~(1 << (element - 1));  // This is important bcs if you use xor operation to change bit (Toggle) on deleting same element twice, it actually adds that element in second delete operation so instead it is recommended to use this;
    }
    public static void display(int subset){
        // Suppose it is a set of 10 numbers
        for(int i = 0 ; i <= 9; i++ ){
            if((subset & (1 << i)) != 0 ){
                System.out.print(i + 1 + " ");
            }
        }
    }
	public static void main(String[] args) {
	    
	    int subset = 16;
	    display(subset);
	    System.out.println();
	    subset = add(subset,4);
	    display(subset);
	    subset = delete(subset,4);
	    System.out.println();
	    display(subset);
	    subset = add(subset,10);
	    subset = add(subset,10);
	    subset = add(subset,8);
	    subset = add(subset,3);
        subset = delete(subset,4);
	    System.out.println();
	    display(subset);
	}
}
