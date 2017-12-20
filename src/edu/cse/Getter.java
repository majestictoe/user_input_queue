package edu.cse;

public class Getter implements Runnable{
    Queue queue;
    Getter(Queue q) {
        queue = q;
    }
    public void run(){
        while(true) {
            while(!queue.get()){
                Thread.currentThread().yield();
            }
            System.out.println (queue.getValue());
            queue.finishPut();
        }
    }
}
