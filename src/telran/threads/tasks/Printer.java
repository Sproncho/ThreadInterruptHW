package telran.threads.tasks;
public class Printer implements Runnable{
    int number;

    Thread nextThread;
    int counter = 0;
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Thread getNextThread() {
        return nextThread;
    }

    public void setNextThread(Thread nextThread) {
        this.nextThread = nextThread;
    }

    public Printer(int number, Thread nextThread) {
        this.number = number;
        this.nextThread = nextThread;
    }
    public Printer(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            printPortion();
            nextThread.interrupt();
            if(counter != 100)
             run();
        }
    }
    private void printPortion(){
        for (int i = 0; i < 10; i++) {
            if(counter < 100) {
                System.out.print(number);
                counter++;
            }
        }
        System.out.println();
    }
}
