package Thread.lesson89;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {
    static long numOfOperations = 10_000_000_000L;

    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws Exception {
        System.out.println(numOfThreads);
        System.out.println(new Date());
        //long j = 0;
        //for (long i = 0; i < numOfOperations; i++) {
        //    j += i;
        //}
        //System.out.println(j);

        ForkJoinPool pool = new ForkJoinPool(numOfThreads);
        System.out.println(pool.invoke(new MyFork(0, numOfOperations)));
        System.out.println(new Date());
    }

    static class MyFork extends RecursiveTask<Long> {
        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if((to-from) <= numOfOperations/numOfThreads) {
                long j = 0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
            } else {
                long middle = (to + from)/2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                MyFork secondHalf = new MyFork(middle + 1, to);
                secondHalf.fork();
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}
