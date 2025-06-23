package L03javareview.linkedQueue;

public class linkedQueueADT<E> implements abstractLinkedQueue<E> {
    private class Node<E> {
        // data
        private E element;
        private Node<E> next;

        // constructor
        public Node ( E element ) {
            this.element = element;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    // constructor
    public linkedQueueADT (){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void offer ( E element ) {
        Node<E>  newNode = new Node<>(element);

        if (head == null && tail == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public E poll() {
        if (head == null && tail == null){
            throw new IllegalStateException("This list is empty");
        }
        E oldElement = this.head.element;

        if (head == tail){
            this.head = null;
            this.tail = null;
        } else {
            Node<E> tempNode = this.head;
            this.head = this.head.next;
            tempNode.next = null;
        }
        this.size--;
        return oldElement;
    }

    @Override
    public E peek() {
        return this.head.element;
    }

    @Override
    public int size () {
        return this.size;
    }

    @Override
    public boolean isEmpty () {
        return this.size == 0;
    }

    @Override
    public String toString () {
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node<E> tempNode = this.head;

        while (tempNode != null){
            result.append(tempNode.element);
            if (tempNode.next != null) {
                result.append(", ");
            }
            tempNode = tempNode.next;
        }
        result.append("]");
        return result.toString();
    }

}
