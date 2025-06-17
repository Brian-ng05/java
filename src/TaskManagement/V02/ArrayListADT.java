package TaskManagement.V02;


import L02javareview.AbstractList;

public class ArrayListADT<E> implements AbstractList<E> {
    private E[] elements;
    private int nextIndex;

    public ArrayListADT() {
        this.elements = (E[]) new Object[3];
        this.nextIndex = 0;
    }

    @Override
    public boolean add(E element) {
        if (this.nextIndex == this.elements.length) {
            grow();
        }
        this.elements[this.nextIndex++] = element;
        return true;
    }
    @SuppressWarnings("unchecked")
    private void grow() {
        E[] biggerElements = (E[]) new Object[elements.length * 2];
            for ( int i = 0; i < elements.length; i++ ) {
                biggerElements[i] = elements[i];
        }
        elements = biggerElements;
    }
    @SuppressWarnings("unchecked")
    private void shirk(){
        E[] smallerElements = (E[]) new Object[elements.length / 2];
            for ( int i = 0; i < nextIndex; i++ ) {
                smallerElements[i] = elements[i];
        }
        elements = smallerElements;
    }
    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > nextIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        if (this.nextIndex == this.elements.length) {
            grow();
        }
        for (int i = nextIndex; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        nextIndex++;
        return true;
    }
    @Override
    public int indexOf(E element) {
        for (int i = 0; i < nextIndex; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public E get(int index) {
        if (index < 0 || index >= nextIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        return this.elements[index];
    }
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= nextIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        E old = elements[index];
        elements[index] = element;
        return old;
    }
    @Override
    public E remove(int index) {
        if (index < 0 || index >= nextIndex){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        E removeElement = elements[index];
        for (int i = index; i < nextIndex - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[nextIndex - 1] = null;
        nextIndex--;

        if (nextIndex > 0 && nextIndex <= elements.length / 3){
            shirk();
        }
        return removeElement;
    }
    @Override
    public int size() {
        return nextIndex;
    }
    @Override
    public boolean contains(E element) {
        for (int i = 0; i < nextIndex; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isEmpty() {
        return nextIndex == 0;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nextIndex; i++) {
            sb.append(elements[i]);
            if (i < nextIndex - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
