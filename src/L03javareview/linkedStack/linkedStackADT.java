package L03javareview.linkedStack;

public class linkedStackADT<E> implements abstractLinkedStack<E> {
    private class Node<E>{
        // attributes
        private E element;
        private Node<E> next;

        // constructor
        public Node ( E element ) {
            this.element = element;
            this.next = null;
        }
    }
    // attributes
    private Node<E> top;
    private int size;

    // constructor
    public linkedStackADT () {
        this.top = null;
        this.size = 0;
    }


    @Override
    public void push ( E element ) {
       Node<E> newNode = new Node<>(element);

       if (this.top == null) {
           this.top = newNode;
       } else {
           newNode.next = this.top;
           this.top = newNode;
       }
        this.size++;
    }

    @Override
    public E pop () {
        if (this.top == null){
            throw new IllegalStateException("This stack is empty");
        }
        E oldElement = this.top.element;

        Node<E> tempNode = this.top;
        this.top = this.top.next;
        tempNode.next = null;

        this.size--;

        return oldElement;
    }

    @Override
    public E peek () {
         if (top == null){
             throw new IllegalStateException("This stack is empty");
         }
        return this.top.element;
    }

    @Override
    public int size () {
        return size;
    }

    @Override
    public boolean isEmpty () {
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("[");

        Node<E> current = top;
        while (current != null) {
            result.append(current.element);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }

        result.append("]");
        return result.toString();

    }
}
