package telran.threads.controller;

import telran.threads.tasks.Printer;

public class PrinterController {
    public static void main(String[] args) {
        Printer printer[] = new Printer[4];
        for (int i = 0; i < printer.length; i++) {
            printer[i] = new Printer(i+1);
        }
        Thread[] threads = new Thread[4];
        for (int i = 0; i < printer.length; i++) {
            threads[i] = new Thread(printer[i]);
            if( i != 0)
                printer[i-1].setNextThread(threads[i]);
        }
        printer[printer.length - 1].setNextThread(threads[0]);
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        threads[0].interrupt();
    }
}
