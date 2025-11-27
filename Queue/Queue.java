package Queue;

public interface Queue {
    void enqueue(Object item);

    Object getFront();

    Object dequeue();

    boolean isEmpty();

    boolean isFull();

    int size();
}