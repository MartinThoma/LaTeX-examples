import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Shell {
    static List<ArrayList<ArrayList<Integer>>> read(String filename) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();

        String thisLine;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            // Begin reading A
            while ((thisLine = br.readLine()) != null) {
                if (thisLine.trim().equals("")) {
                    break;
                } else {
                    ArrayList<Integer> line = new ArrayList<Integer>();
                    String[] lineArray = thisLine.split("\t");
                    for (String number : lineArray) {
                        line.add(Integer.parseInt(number));
                    }
                    A.add(line);
                }
            }

            // Begin reading B
            while ((thisLine = br.readLine()) != null) {
                ArrayList<Integer> line = new ArrayList<Integer>();
                String[] lineArray = thisLine.split("\t");
                for (String number : lineArray) {
                    line.add(Integer.parseInt(number));
                }
                B.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }

        List<ArrayList<ArrayList<Integer>>> res = new LinkedList<ArrayList<ArrayList<Integer>>>();
        res.add(A);
        res.add(B);
        return res;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            int i = 0;
            StringBuilder sb = new StringBuilder(matrix.length);
            for (int number : line) {
                if (i != 0) {
                    sb.append("\t");
                } else {
                    i++;
                }
                sb.append(number);
            }
            System.out.println(sb.toString());
        }
    }

    public static int[][] parallelMult(ArrayList<ArrayList<Integer>> A,
            ArrayList<ArrayList<Integer>> B, int threadNumber) {
        int[][] C = new int[A.size()][B.get(0).size()];
        ExecutorService executor = Executors.newFixedThreadPool(threadNumber);
        List<Future<int[][]>> list = new ArrayList<Future<int[][]>>();

        int part = A.size() / threadNumber;
        if (part < 1) {
            part = 1;
        }
        for (int i = 0; i < A.size(); i += part) {
            System.err.println(i);
            Callable<int[][]> worker = new LineMultiplier(A, B, i, i+part);
            Future<int[][]> submit = executor.submit(worker);
            list.add(submit);
        }

        // now retrieve the result
        int start = 0;
        int CF[][];
        for (Future<int[][]> future : list) {
            try {
                CF = future.get();
                for (int i=start; i < start+part; i += 1) {
                    C[i] = CF[i];
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            start+=part;
        }
        executor.shutdown();

        return C;
    }

    public static void main(String[] args) {
        String filename;
        int cores = Runtime.getRuntime().availableProcessors();
        System.err.println("Number of cores:\t" + cores);
        
        int threads;
        if (args.length < 3) {
            filename = "3.in";
            threads = cores;
        } else {
            filename = args[1];
            threads = Integer.parseInt(args[2]);
        }

        List<ArrayList<ArrayList<Integer>>> matrices = read(filename);
        ArrayList<ArrayList<Integer>> A = matrices.get(0);
        ArrayList<ArrayList<Integer>> B = matrices.get(1);
        int[][] C = parallelMult(A, B, threads);
        printMatrix(C);
    }
}
