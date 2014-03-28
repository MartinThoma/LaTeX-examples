struct Complex {
    val real:Double;
    val img :Double;

    def this(r:Double, i:Double) {
        real = r; img = i;
    }

    def operator + (that:Complex) {
        return
            Complex(real + that.real,
                    img + that.img);
    }
}

val x = new Array[Complex](1..10);