package com.bpkb.fiveinrow.server.host;

public class Test {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData(); // Shared data object

        Thread parentThread = new Thread(() -> {
            System.out.println("Parent thread starting");
            sharedData.setValue(10); // Modify shared data in parent thread

            Thread childThread = new Thread(() -> {
                System.out.println("Child thread modifying shared data");
                sharedData.setValue(20); // Modify shared data in child thread
            });
            childThread.start();

            try {
                childThread.join(); // Wait for the child thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });
        System.out.println("start "+sharedData.getValue());
        parentThread.start();

        try {
            parentThread.join(); // Wait for the parent thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Parent thread ending: " + sharedData.getValue());
    }
}

class SharedData {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}