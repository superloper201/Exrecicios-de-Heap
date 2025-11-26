package exercicios.heap;
import java.util.*;

public class Ex01_KMaiores {

    public static List<Integer> findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 7, 20, 1, 15};
        int k = 3;
        System.out.println(findKthLargest(arr, k));
    }
}
