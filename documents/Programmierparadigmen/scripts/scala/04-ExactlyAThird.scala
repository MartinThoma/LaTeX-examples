import scala.math.pow

object ExactlyAthrid {
  def main(arg: Array[String]) {
    val digits = List(1, 2, 3, 4, 5, 6, 7, 8, 9);
    for (c <- digits.combinations(4)) {
      for(d <- c.permutations) {
        // Get the numerator
        var numerator = 0;
        for((digit, place) <- d.zipWithIndex) {
          numerator += digit
                       * pow(10, place).toInt;
        }

        // Get the denominator
        var denominator = 3 * numerator;

        // Check if all digits appear
        // exactly once
        var cdigits = numerator.toString
                      + denominator.toString;
        var cdigits_list = cdigits.toCharArray.
                   distinct;

        // Print solution
        if (cdigits_list.length == 9 &&
            !cdigits_list.contains('0')){
              println("%d / %d = 1/3".
               format(numerator, denominator));
        }
      }
    }
  }
}