package exercicios.heap;

import java.util.*;

public class Ex03_DualPriorityQueue {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private Map<Integer, Integer> freq = new HashMap<>();

    private void cleanHeap(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && freq.getOrDefault(heap.peek(), 0) == 0) {
            heap.poll();
        }
    }

    public void insert(int value) {
        minHeap.add(value);
        maxHeap.add(value);
        freq.put(value, freq.getOrDefault(value, 0) + 1);
    }

    public Integer getMin() {
        cleanHeap(minHeap);
        return minHeap.peek();
    }

    public Integer getMax() {
        cleanHeap(maxHeap);
        return maxHeap.peek();
    }

    public Integer removeMin() {
        cleanHeap(minHeap);
        if (minHeap.isEmpty()) return null;

        int val = minHeap.poll();
        freq.put(val, freq.get(val) - 1);
        return val;
    }

    public Integer removeMax() {
        cleanHeap(maxHeap);
        if (maxHeap.isEmpty()) return null;

        int val = maxHeap.poll();
        freq.put(val, freq.get(val) - 1);
        return val;
    }

    public static void main(String[] args) {
        Ex03_DualPriorityQueue dpq = new Ex03_DualPriorityQueue();
        dpq.insert(5);
        dpq.insert(1);
        dpq.insert(9);

        System.out.println(dpq.getMin()); // 1
        System.out.println(dpq.getMax()); // 9

        dpq.removeMin();
        System.out.println(dpq.getMin()); // 5
    }
}