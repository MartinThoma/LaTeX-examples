public static void main(String[] args) throws
  InterruptedException, ExecutionException {
    ExecutorService pool = 
            Executors.newFixedThreadPool(4);
    List<Future<String>> futures = 
            new ArrayList<Future<String>>();

    for(int i = 0; i < 10; i++) {
        futures.add(pool.submit(new StringTask(i)));
    }

    for(Future<String> future : futures){
        String result = future.get();
        System.out.println(result);
    }

    pool.shutdown();
}