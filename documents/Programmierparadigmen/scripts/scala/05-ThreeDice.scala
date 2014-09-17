object ThreeDice {
  def main(arg: Array[String]) {
    val dice_results = List(1, 2, 3, 4, 5, 6);
    var outcomes = for(a <- dice_results;
               b <- dice_results;
               c <- dice_results)
            yield a*b*c;
    println("%d / %d".
        format(
         outcomes.filter(x => x % 2 == 1).length,
         outcomes.length));
  }
}