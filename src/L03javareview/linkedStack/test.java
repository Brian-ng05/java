package L03javareview.linkedStack;

public class test {
    public static void main (String[] args) {
        linkedStackADT<Integer> myLinkedStack = new linkedStackADT<>();
        myLinkedStack.push(10);
        myLinkedStack.push(20);
        myLinkedStack.push(30);
        myLinkedStack.push(40);
        System.out.println(myLinkedStack);
        System.out.println(myLinkedStack.isEmpty());
        System.out.println(myLinkedStack.peek());
        System.out.println(myLinkedStack.size());
        myLinkedStack.pop();
        System.out.println(myLinkedStack.size());
        System.out.println(myLinkedStack);
    }
}
