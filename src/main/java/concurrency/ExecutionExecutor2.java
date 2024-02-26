package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutionExecutor2 {
    public static void main(String[] args) {
        CustomerService customerService=new CustomerService();
        ScheduledExecutorService service= Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> futureService= service.scheduleAtFixedRate(customerService,5,5, TimeUnit.SECONDS);
        service.schedule(new Runnable() {
            @Override
            public void run() {
                futureService.cancel(true);
                service.shutdown();
            }
        },30,TimeUnit.SECONDS);
    }
}
