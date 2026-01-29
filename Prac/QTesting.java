public class QTesting {
    public static void main(String[] args) {
        myQueue aQ = new myQueue(5);

        aQ.enqueue(1);
        aQ.enqueue(2);
        aQ.enqueue(3);
        aQ.dequeue();
        aQ.enqueue(4);
        aQ.enqueue(5);
        aQ.enqueue(6);
        aQ.enqueue(7);
        aQ.enqueue(8);

        aQ.printMyQ();
    }
}
