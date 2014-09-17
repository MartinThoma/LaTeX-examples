object TwoBases {
    def test(x: Int, y: Int, z: Int) =
        (100*x + 10*y + z == math.pow(9,2)*z + 9*y + z)

    def main(args: Array[String]) {
        for(x <- 0 to 9; y <- 0 to 9; z <- 0 to 9) {
            if(test(x, y, z)){
                println("%d%d%d".format(x, y, z));
            }
        }
    }
}