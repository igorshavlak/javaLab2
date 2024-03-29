package org.example;

public class ThreadFinder extends Thread{

    public int start;
    public int end;
    public int[] arr;
    private final MinElementFinder finder;

    public ThreadFinder(int start, int end, int[] arr, MinElementFinder finder){
        this.start = start;
        this.end = end;
        this.arr = arr;
        this.finder = finder;
        new Thread(this).start();
    }
    @Override
    public void run() {
        int localMin = Integer.MAX_VALUE;
        int localMinIndex = -1;

        for (int j = start; j < end; j++) {
            if (arr[j] < localMin) {
                localMin = arr[j];
                localMinIndex = j;
            }
        }
        finder.compareMinElement(localMin,localMinIndex);

    }
}
