package linkedList;

public class LinkedList {
    Node first;
    Node last;
    int size;

    public LinkedList() {
        this.first = this.last = null;
        this.size = 0;
    }

    public LinkedList(Object o) {
        addFirst(o);
    }

    public void addFirst(Object o) {
        Node newNode = new Node(o);
        newNode.next = this.first;
        first = newNode;
        size++;

        if (this.last == null) {
            last = first;
        }
    }

    public void addLast(Object o) {
        if (this.size == 0) {
            addFirst(o);
        } else {
            add(size - 1, o);
        }
    }

    public void add(int index, Object o) {
        if (index > this.size) {
            addLast(o);
        }

        if (index <= 0) {
            addFirst(o);
            return;
        }

        Node current = first;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        Node temp = current.next;
        current.next = new Node(o);
        current.next.next = temp;

        this.size++;
    }

    public Object removeFirst() {
        if (size == 0) {
            return null;
        }

        Node delObject = first;
        first = first.next;
        size--;

        return delObject;
    }

    public Object removeLast() {
        if (size == 0)
            return null;

        Node prevObj = this.first;
        for (int i = 1; i < size - 1; i++) {
            prevObj = prevObj.next;
        }

        Node delNode = prevObj.next;
        prevObj.next = null;
        size--;

        return delNode;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("[");

        Node curr = first;
        for (;;) {
            result.append(curr.element);
            curr = curr.next;
            if (curr.next == null) {
                result.append("]");
                break;
            } else {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public boolean contain(String a) {
        if (size == 0)
            return false;

        Node current = first;
        for (int i = 1; i < size; i++) {

            if (current.element.toString().equals(a)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
