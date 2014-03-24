public final class StringTask implements Callable<String> {
    int id;
    public StringTask(int id) {
        this.id = id;
    }
    public String call() {
        return "Run " + id;
    }
}