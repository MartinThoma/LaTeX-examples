import scala.actors.Futures._;

object FastPower {
    /**
     * Calculate a power of two fast.
     */
    def fastPow(x: Int, n: Int): Long = {
        var result = 1L;

        val b = n.toBinaryString.reverse;
        for(d <- 0 until b.length()) {
            if(b.charAt(d).equals('1')){
                result *= scala.math.pow(x,
                    scala.math.pow(2, d)).toLong;
            }
        }

        return result;
    }

    /**
     * Calculate a power of two fast and use Futures.
     */
    def fastPowParallel(x: Int, n: Int): Long = {
        var result = 1L;
        val b = n.toBinaryString.reverse;
        val tasks = for (d <- 0 until b.length())
            yield future
        {
            var interim = 0L;
            if (b.charAt(d).equals('1')){
                interim = scala.math.pow(x,
                    scala.math.pow(2, d)).toLong;
            }

            interim;
        }

        val futureRes = awaitAll(20000L, tasks: _*);

        futureRes.foreach { res => 
            res match {
                case Some(x: Long) => if (x > 0) 
                                        result *= x
                case None => throw new
                             Exception("error")
            };
        }

        return result;
    }

    def main(args: Array[String]) {
        println(fastPowParallel(2, 9));
        // => 512
    }
}
