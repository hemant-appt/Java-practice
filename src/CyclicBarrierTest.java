import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {


    static final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    static void task1() {
        System.out.println("Task 1 before barrier ");
        try {
            Thread.sleep(2000);
            cyclicBarrier.await();
            System.out.println("Task 1 after barrier");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }


    static void task2() {
        System.out.println("Task 2 before barrier");
        try {
            Thread.sleep(4000);
            cyclicBarrier.await();
            System.out.println("Task 2 after barrier");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    static void task3() {
        System.out.println("Task 3 before barrier");
        try {
            Thread.sleep(10000);
            cyclicBarrier.await();
            System.out.println("Task 3 after barrier");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            task1();
        });

        Thread t2 = new Thread(() -> {
            task2();
        });

        Thread t3 = new Thread(() -> {
            task3();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
