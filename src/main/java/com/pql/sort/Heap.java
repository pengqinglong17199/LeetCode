package com.pql.sort;

/**
 * @author pengqinglong
 * @since 2022/12/30
 */
public class Heap {

    private int heapSize;

    private int[] heapArr = new int[1000];
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(3);
        heap.add(6);
        heap.add(2);
        heap.add(5);
        heap.add(4);

        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());

        heap.add(1);
        heap.add(3);
        heap.add(6);
        heap.add(2);
        heap.add(5);
        heap.add(4);

        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
    }

    public void add(int i){
        // 赋值
        heapArr[heapSize] = i;
        heapInsert(heapSize++);
    }
    public void heapInsert(int index){

        // 如果当前位子大于父 则跟父交换 并再次循环
        while (heapArr[index] > heapArr[index >> 1]){
            swap(index, index >> 1);
            index = index >> 1;
        }
    }

    public int pop(){
        if (heapSize == 0) {
            return -1;
        }

        int result = heapArr[0];

        swap(0, --heapSize);

        heapify(0);

        return result;
    }

    private void heapify(int index) {

        int left = index * 2 + 1;
        while (left < heapSize){
            int max = left + 1 < heapSize && heapArr[left] < heapArr[left +1] ? left +1 : left;
            if(heapArr[index] >= heapArr[max]){
                break;
            }
            swap(index, max);
            index = max;
            left = index * 2 + 1;
        }
    }

    private void swap(int i1, int i2) {
        int temp = heapArr[i1];
        heapArr[i1] = heapArr[i2];
        heapArr[i2] = temp;
    }
}
