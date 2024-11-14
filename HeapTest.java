package algo_06_20195181;

public class HeapTest {
    public static void main(String args[]) {
        Heap h = new Heap();
        h.insert(30);
        h.insert(40);
        h.insert(20);
        h.insert(10);
        h.insert(35);
        h.insert(45);
        h.insert(50);
        h.insert(25);
        h.insert(70);
        h.insert(48);
        h.insert(64);
        h.printHeap();

        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        
        System.out.println("************************");
        
        // -10�� �ǹ̾��� ������
        int[] origArray = {-10, 50, 55, 60, 30, 70, 90, 25, 80, 40, 45};
        h = new Heap(origArray);
        h.printHeap();

        System.out.println(h.delete());
        System.out.println(h.delete());

        h.printHeap();

    }
}
