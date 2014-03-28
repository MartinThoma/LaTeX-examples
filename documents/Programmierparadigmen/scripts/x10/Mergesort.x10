import x10.io.Console;
import x10.util.Random;

public class Mergesort {
  private static val rand = new Random();
  private static val MIN_ELEMENTS_PARALLEL = 65536;

  public static def sort(values : Array[Int](1)) : Array[Int](1) {
    val numbers = new Array[Int](values.size);
    val helper = new Array[Int](values.size);
    Array.copy(values, numbers);

    mergesort(0, values.size - 1, numbers, helper);

    return numbers;
  }

  private static def mergesort(low : Int, high : Int, numbers : Array[Int](1), helper : Array[Int](1)) {
    if (low < high) {
      val middle = (low + high) / 2;
      if (high - low >= MIN_ELEMENTS_PARALLEL) {
        finish {
          async mergesort(low, middle, numbers, helper);
          async mergesort(middle + 1, high, numbers, helper);
        }
      } else {
        mergesort(low, middle, numbers, helper);
        mergesort(middle + 1, high, numbers, helper);
      }
      merge(low, middle, high, numbers, helper);
    }
  }

  private static def merge(low : Int, middle : Int, high : Int, numbers : Array[Int](1), helper : Array[Int](1)) {
    // Copy the part to be merged into the helper (from low to high)
    Array.copy(numbers, low, helper, low, high - low + 1);

    var left : Int = low;
    var right : Int = middle + 1;
    var position : Int = low;

    while(left <= middle && right <= high) {
      if (helper(left) <= helper(right)) {
      numbers(position++) = helper(left++);
      } else {
      numbers(position++) = helper(right++);
      }
    }

    while(left <= middle) {
      numbers(position++) = helper(left++);
    }
    // Nothing needs to be done for the right half, because is still
    // is where it was copied from, which happens to be the right
    // location.
  }

  public static def main(args:Array[String](1)) {
    if (args.size < 1) {
      Console.OUT.println("Expect array length as argument");
      return;
    }

    val sort_count = Int.parse(args(0));
    val to_sort:Array[Int] = new Array[Int](sort_count, (_:Int) => { return rand.nextInt(); });

    for (i in to_sort) {
      Console.OUT.print(to_sort(i) + " ");
    }
    Console.OUT.println();

    val start = System.nanoTime();
    val sorted = sort(to_sort);
    val duration = System.nanoTime() - start;

    Console.OUT.println("Sorting took " + duration / 1000000.0 + "ms");

    Console.OUT.println("Checking for sortedness...");

    for (i in sorted) {
       Console.OUT.print(sorted(i) + " ");
    }
    Console.OUT.println();
  }
}