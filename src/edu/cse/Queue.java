package edu.cse;

import java.util.Arrays;

public class Queue {
    public String queue[] = new String[100];
    private int putNumber;
    private int getNumber;

    Queue() {

    }

    synchronized boolean put(String input) {
        if (queue[putNumber] == null) {
            queue[putNumber] = input;
            if (putNumber < 100) {
                putNumber++;
                System.out.println(Arrays.toString(queue));
            } else {
                putNumber = 0;
                System.out.println(Arrays.toString(queue));
            }
            return true;
        } else {
            return false;
        }
    }

    synchronized boolean get() {
        if (queue[getNumber] != null) {
            return true;
        } else {
            return false;
        }
    }
}
