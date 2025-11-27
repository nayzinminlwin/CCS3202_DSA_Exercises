package Queue;

public class ArrayQueue implements Queue {
    private Object[] items;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public void enqueue(Object item) {
        if (isFull()) {
            this.resize(item);
        }
        rear = (rear + 1) % capacity;
        items[rear] = item;
        size++;
    }

    private void resize(Object item) {
        int newCapacity = capacity * 2;
        Object[] newItems = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            System.out.printf("newItems[%d] = items[%d]\n", i, (front + i) % capacity);
            System.out.printf("%s = %s\n", newItems[i], items[(front + i) % capacity]);
            newItems[i] = items[(front + i) % capacity];
        }
        items = newItems;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        enqueue(item);
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object item = items[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    @Override
    public Object getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items[front];
    }

    @Override
    public int size() {
        return size;
    }
}