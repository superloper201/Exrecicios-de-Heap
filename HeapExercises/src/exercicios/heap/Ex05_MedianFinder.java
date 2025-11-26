package exercicios.heap;

import java.util.*;

public class Ex05_MedianFinder {

    private PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder()); // Max-Heap
    private PriorityQueue<Integer> large = new PriorityQueue<>();                          // Min-Heap

    public void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.add(num);
        } else {
            large.add(num);
        }

        // Balancear
        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        } else if (large.size() > small.size()) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }
        return small.peek();
    }

    public static void main(String[] args) {
        Ex05_MedianFinder mf = new Ex05_MedianFinder();

        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5

        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2
    }
}