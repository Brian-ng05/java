package L03javareview.linkedList;

public class test {
    public static void main ( String[] args ) {
        LinkedListADT<Integer> myIntList = new LinkedListADT<>(); // <Integer>
        myIntList.addFirst(10);
        myIntList.addFirst(20);
        myIntList.addLast(40);
        myIntList.addLast(50);
        System.out.println(myIntList);
    }
}
