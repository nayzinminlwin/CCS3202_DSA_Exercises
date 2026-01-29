public class myQueue {
    private int[] myQ;
    private int front;
    private int rear;
    private int size;

    public myQueue(int qSize) {
        myQ = new int[qSize];
        this.size = 0;
        front = 0;
        rear = 0;
    }

    public int getFront() {
        return this.front;
    }

    public int getRear() {
        return this.rear;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isFull() {
        return this.size == myQ.length;
    }

    public void enqueue(int a) {
        ensureSize();
        myQ[rear] = a;
        this.rear = (this.rear + 1) % myQ.length;
        this.size++;
    }

    public int dequeue() {

        int a = myQ[front];
        myQ[front] = 0;
        front = (front + 1) % myQ.length;
        this.size--;

        return a;
    }

    public void printMyQ() {
        if (this.getSize() == 0)
            return;

        int index = this.getFront();
        for (int i = 0; i < this.getSize(); i++) {
            System.out.println(myQ[index]);
            index = (index + 1) % myQ.length;
        }

    }

    public void ensureSize() {
        if (!this.isFull()) {
            return;
        }

        myQueue newQ = new myQueue(this.getSize() * 2);

        while (this.getSize() != 0) {
            newQ.enqueue(this.dequeue());
        }

        this.myQ = newQ.myQ;
        this.front = newQ.front;
        this.rear = newQ.rear;
        this.size = newQ.size;
    }
}
