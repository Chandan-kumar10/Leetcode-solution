import java.util.concurrent.Semaphore;

class Foo {
    
    // Semaphores to control execution order
    private Semaphore sem2 = new Semaphore(0);
    private Semaphore sem3 = new Semaphore(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // Release permit for the second thread
        sem2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until first() finishes and releases sem2
        sem2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        // Release permit for the third thread
        sem3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until second() finishes and releases sem3
        sem3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}