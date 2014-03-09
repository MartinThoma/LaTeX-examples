import x10.io.Console;

class HelloWholeWorld {
    public static def main(args:Rail[String]):void {
        if (args.size < 1) {
            Console.OUT.println("Usage: HelloWholeWorld message");
            return;
        }

        finish for (p in Place.places()) {
            at (p) async Console.OUT.println(here+" says hello and "+args(0));
        }
        Console.OUT.println("Goodbye");
    }
}