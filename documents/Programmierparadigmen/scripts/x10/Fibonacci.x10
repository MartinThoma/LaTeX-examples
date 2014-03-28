// file Fibonacci.x10
public class Fibonacci {
    public static def fib(n:Int) {
        if (n < 2) {
            return n;
        }

        val f1:Int;
        val f2:Int;
        f1 = fib(n-1);
        f2 = fib(n-2);
        return f1 + f2;
    }

    public static def main(args:Rail[String]) {
        x10.io.Console.OUT.println("This is fibonacci in X10.");
        for (var i:Int=0; i < 10; ++i) {
            x10.io.Console.OUT.println(i + ": " + fib(i));
            fib(i);
        }
    }
}