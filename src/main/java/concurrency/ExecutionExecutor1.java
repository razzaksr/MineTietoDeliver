package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutionExecutor1 {
    public static void main(String[] args) {
        CustomerService customerService=new CustomerService();
        Executor executor= Executors.newCachedThreadPool();
        executor.execute(customerService);

        ThreadPoolExecutor poolExecutor=(ThreadPoolExecutor) executor;
        poolExecutor.shutdown();
    }
}
