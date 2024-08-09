package mutlithreading;

public class Singleton {
    public static volatile Singleton instance;
    private Singleton(){}

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    public void doSomething() {
        System.out.println("Doing something");
    }
}

class SingletonDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            singleton.doSomething();
        });
        Thread t2 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            singleton.doSomething();
        });

        t1.start();
        t2.start();
    }
}