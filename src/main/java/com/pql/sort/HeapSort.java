package com.pql.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆排序实现
 * @author pengqinglong
 * @since 2023/1/6 10:43
 */
public class HeapSort {

    private List<Integer> heap = new ArrayList<>();

    private int heapSize = 0;

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        for (int i = 0; i < 10; i++) {
            heapSort.add(i+1);
        }
        int j = 0;
        while ((j = heapSort.pop()) > 0){
            System.out.println(j);
        }

        for (int i = 0; i < 10; i++) {
            heapSort.add(i+1);
        }

        while ((j = heapSort.pop()) > 0){
            System.out.println(j);
        }

    }

    public void add(int i){
        int cur = heapSize++;
        heap.add(cur, i);
        houseInsert(cur);
    }

    public void houseInsert(int cur){
        Integer i = heap.get(cur);
        while (heap.get(cur / 2) < i) {
            this.swap(cur, cur / 2);
            cur = cur / 2;
        }
    }

    public int pop(){
        if(heapSize == 0){
            return -1;
        }

        Integer max = heap.get(0);
        swap(0, --heapSize);

        heapify(0);
        return max;
    }

    public void heapify(int cur){
        int left = 0;
        while ((left = cur * 2 +1) < heapSize){

            int maxIndex = left+1 < heapSize && heap.get(left+1) > heap.get(left) ? left+1 : left;
            maxIndex = heap.get(cur) < heap.get(maxIndex) ? maxIndex : cur;
            if(maxIndex == cur){
                break;
            }
            this.swap(cur, maxIndex);
            cur = maxIndex;
        }
    }

    private void swap(int cur, int parent) {
        Integer p = heap.get(parent);
        Integer c = heap.get(cur);
        heap.set(parent, c);
        heap.set(cur, p);
    }
}
