package Queue;

public class Assginment2 {
    public static void main(String[] args) {
        ArrayQueue OperationQ = new ArrayQueue(0);

        OperationQ.enqueue(5);
        OperationQ.enqueue(3);
        System.out.println(OperationQ.dequeue());

        OperationQ.enqueue(7);
        System.out.println(OperationQ.dequeue());

        System.out.println(OperationQ.getFront());
        System.out.println(OperationQ.dequeue());
        System.out.println(OperationQ.dequeue());
        System.out.println(OperationQ.isEmpty());

        OperationQ.enqueue(9);
        OperationQ.enqueue(7);
        System.out.println(OperationQ.size());
        OperationQ.enqueue(3);
        OperationQ.enqueue(5);
        System.out.println(OperationQ.dequeue());
        System.out.println(OperationQ.getRear());

    }
}