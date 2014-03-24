public final class StringTask implements Runnable {
    int id;
    public StringTask(int id) {
        this.id = id;
    }
    public void run() {
        // do calculation
    }
}

ExecutorService pool =
    Executors.newFixedThreadPool(4);
for(int i = 0; i < 10; i++){
    pool.execute(new StringTask(i));
}
pool.shutdown();
executor.awaitTermination();