package edu.cse;
import javafx.scene.control.Label;

public class Getter implements Runnable{
    String[] values;
    Queue queue;
    Label lab;
    Getter(Queue q, Label label) {
        queue = q;
        lab = label;
    }
    public void run(){
        Thread.currentThread().setName("GETTER Thread");

        while(true) {
            values = queue.getValues();
            while(values == null){
                Thread.currentThread().yield();
                values = queue.getValues();
            }
            System.out.println (values[0]);
            lab.setText(values[0]);
            queue.finishPut();
        }
    }
    synchronized String currentOutput(){
        return values[0];
    }
}
