import scala.actors.Futures._
/** @author Axel Busch */
object EratosthenesFutures {
    def parallel(end : Int, threads: Int) : Array[Boolean] = {
        val sieve = Array.fill[Boolean](end+1)(true)
        for (i <- 2 to scala.math.sqrt(end).toInt) {
            if (sieve(i)) {
                val nextComposite = i*i
                val compositesPerThread = (end-nextComposite+1)/(threads*i)
                val tasks = for (t <- 0 until threads) yield future {
                    val begin = nextComposite + t * i *
                                compositesPerThread
                    val finish = if (t+1 == threads) end 
                                 else nextComposite + (t+1) * i *
                                        compositesPerThread
                    assert (begin % i == 0)
                    for (composite <- begin to finish by i) {
                        sieve(composite) = false
                    }
                }
                awaitAll(20000L, tasks: _*);
            }
        }
        sieve
    }
    def main(args: Array[String]) = {
        val end = 100000000
        for (threads <- List(1,2,4,8)) {
            val startTime = System.currentTimeMillis();
            parallel(end,threads);
            val endTime = System.currentTimeMillis();
            println(threads + " thread: " + (endTime - startTime) + " ms");
        }
    }
}