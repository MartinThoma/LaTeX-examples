object HighProduct {
    def main(arg: Array[String]) {
        var max = List(BigInt(0), BigInt(0),
                       BigInt(0));
        val digits = List(0, 1, 2, 3, 4, 5, 6,
                          7, 8, 9);
        for (c <- digits.combinations(4)) {
            // Sort the digits so that the
            // highest number gets built
            val a = c.sorted(Ordering[Int]);
            val b = (digits filterNot a.contains).
                    sorted(Ordering[Int]);
            // calculate number a
            var anum = BigInt(0);
            for ((digit, place) <- a.zipWithIndex) {
                anum += digit *
                        scala.math.pow(10, place).
                            toInt;
            }
            // calculate number b
            var bnum = BigInt(0);
            for ((digit, place) <- b.zipWithIndex) {
                bnum += digit *
                        scala.math.pow(10, place).
                            toInt;
            }

            // calculate number a
            if (anum * bnum > max(0)) {
                max = List(anum * bnum, anum, bnum);
            }
        }
        println("%d • %d = %d".format(max(1),
                                      max(2),
                                      max(0)));
    }
}