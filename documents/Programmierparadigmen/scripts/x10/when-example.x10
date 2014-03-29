class OneBuffer {
    var datum:Object = null;
    var filled:Boolean = false;
    def send(v:Object) {
        when (!filled) {
            datum = v;
            filled = true;
        }
    }
    def receive():Object {
        when (filled) {
            val v = datum;
            datum = null;
            filled = false;
            return v;
        }
    }
}