package org.example;

import java.util.Arrays;
import java.util.Random;


public class MinElementFinder {

    private  final int NUM_THREADS = 1;
    private  int[] array;
    private  int minElement = Integer.MAX_VALUE;
    private  int minElementIndex = -1;
    private Thread[] threads;

    private void generateArray(int length) {
        array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000);
        }
        array[0] = -152;

    }
    public void arrayPartitioning() {
    long startTime = System.nanoTime();
        generateArray(100000);
        int chunkSize = array.length / NUM_THREADS; // 5
        threads = new Thread[NUM_THREADS]; // 20
        for (int i = 0; i < NUM_THREADS; i++) {
            final int start = i * chunkSize;
            final int end;
            if (i == NUM_THREADS - 1) {
                end = array.length;
            } else {
                end = (i + 1) * chunkSize;
            }
            threads[i] = new Thread(new ThreadFinder(start,end,array, this));
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Execution time: " + elapsedTime/1000 + " nanoseconds");
    }
    synchronized  public void compareMinElement(int localMin,int localMinIndex){
        if(localMin < minElement){
            minElement = localMin;
            minElementIndex = localMinIndex;
        }
    }
    public int getMinElement(){
        return minElement;
    }

    public int getMinElementIndex() {
        return minElementIndex;
    }
}












