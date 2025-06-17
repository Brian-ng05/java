package Generic;

class Box<E> {
    // attributes
    private E content;

    // constructor
    public Box(E content) {
        this.content = content;
    }
}

public class GenericClassExample {
    public static void main ( String[] args ) {

        Box<Integer> b3 = new Box<>(2025); // <Integer>
        Box<String> b4 = new Box<>("hello"); // <String>

    }
}