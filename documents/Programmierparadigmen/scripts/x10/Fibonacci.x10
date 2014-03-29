// file Fibonacci.x10
public class Fibonacci {
    public static def fib(n:Long): Long {
        if (n < 2) {
            return n;
        }

        val f1:Long;
        val f2:Long;
        finish {
            async f1 = fib(n-1);
            async f2 = fib(n-2);
        }
        return f1 + f2;
    }

    public static def main(args:Rail[String]) {
        x10.io.Console.OUT.println("This is fibonacci in X10.");
        for (var i:Long=0; i < 10; ++i) {
            x10.io.Console.OUT.println(i + ": " + fib(i));
        }
    }
}