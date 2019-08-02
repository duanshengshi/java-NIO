package algorithm.sort;

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] lists = new int[100];
        Random random = new Random();
        for (int i = 0; i < lists.length; i++) {
            lists[i] = random.nextInt(100);
        }
        printAll(lists);
        int temp = 0;
        boolean change = false;
        for (int i = 0; i < lists.length - 1; i++) {
            change = false;
            for (int j = lists.length-1; j >i ; j--) {
                if(lists[j]<lists[j-1]){
                    temp = lists[j];
                    lists[j] = lists[j-1];
                    lists[j-1] = temp;
                    change = true;
                }
            }
            if (!change){
                break;
            }
            System.out.println();
            System.out.format("第 %d 趟：\t", i);
            printAll(lists);
        }
    }

    static void printAll(int[] lists){
        for (int list : lists) {
            System.out.print(list+" ");
        }
    }
}
