package org.example;

public class Main {
    public static void main(String[] args) {
        MinElementFinder minElementFinder = new MinElementFinder();
        minElementFinder.arrayPartitioning();
        int min = minElementFinder.getMinElement();
        System.out.println("Мінімальний елемент масиву: " + min);
    }
}