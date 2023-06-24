import java.lang.reflect.Field;

public class DeadLockThreadProblem {


    static class Friend {
        private final String name;

        Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {

            System.out.println(this.name + " : " + bower.getName() + " has bowed to me");
            // System.out.format("%s: %s"+" has bowed to me!%n "+ this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {

            System.out.println(this.name + " : " + bower.getName() + " has bowed back to me");
            //  System.out.format("%s: %s"+" has bowed back to me!%n "+this.name, bower.getName());
        }
    }

    public static void main(String[] args) {

        final Friend hemanth = new Friend("Hemanth");
        final Friend kumar = new Friend("Kumar");

        new Thread(new Runnable() {
            @Override
            public void run() {
                hemanth.bow(kumar);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                kumar.bow(hemanth);
            }
        }).start();
    }
}
