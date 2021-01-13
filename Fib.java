package q1;

public class Fib {

    // constructor
    public Fib(int f0, int f1)
    {
        this.f0 = f0;
        this.f1 = f1;
    }

    // computes F(n) using an ***iterative*** algorithm, where F(n) = F(n-1) + F(n-2) is the recursive definition.
    // use instance variables that store F(0) and F(1).
    // check parameter and throw exception if n < 0. Don't worry about arithmetic overflow.
    public int f(int n) {
        int f0 = this.f0;
        int f1 = this.f1;
        int sum = 0;
	    if(n < 0){
            throw new IllegalArgumentException(Integer.toString(n));
        }
	    else {
            if (n == 0 )
            {
                System.out.println("First " + n + " term(s) of the Fibonacci Sequence (No Recursion): ");
                return f0;
            }
	        else if (n == 1) {
	            System.out.println("First " + n + " term(s) of the Fibonacci Sequence (No Recursion): " + this.f0);
	            return f1;
            }
	        else {
                System.out.print("First " + n + " term(s) of the Fibonacci Sequence (No Recursion): " + this.f0 + " " + this.f1);
                for (int i = 2; i < n; ++i) {
                    sum = f0 + f1;
                    System.out.print(" " + sum);
                    f0 = f1;
                    f1 = sum;
                }
            }
        }
	    return sum;
    }

    // computes F(n) using the ***recursive*** algorithm, where F(n) = F(n-1) + F(n-2) is the recursive definition.
    // use instance variables that store F(0) and F(1).
    // check parameter and throw exception if n < 0. Don't worry about arithmetic overflow.
    public int fRec(int n) {
        if (n == 1) return this.f1;
        else if(n == 0) {
            return this.f0;
        } else if (n < 0) {
            throw new IllegalArgumentException(Integer.toString(n));
        }
        return this.fRec(n-2) + this.fRec(n-1);
    }

    public static void main(String[] args) {
        int f0;
        int f1;
        int n;
        // get numbers F(0) and F(1) from args[0] and args[1].
        // use either the Scanner class or Integer.parseInt(args[...])
        // you must handle possible exceptions !
        try{
            f0 = Integer.parseInt(args[0]);
            f1 = Integer.parseInt(args[1]);
            n = Integer.parseInt(args[2]);
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR WITH INPUT");
        }
        // create a Fib object with params F(0) and F(1)
        Fib myFib = new Fib(f0, f1);
        // calculate F(0), ..., F(n) and display them with System.out.println(...) using
        // the iterative method f(i)
        myFib.f(n);
        // calculate F(0), ..., F(n) and display them with System.out.println(...) using
        // the recursive method fRec(i)
        System.out.print("\nFirst " + n + " term(s) of the Fibonacci Sequence using Recursion: ");
        for(int i = 0; i < n; i++){
            System.out.print(myFib.fRec(i) +" ");
        }
    }
    // instance variables store F(0) and F(1):
    private int f0;
    private int f1;
}

