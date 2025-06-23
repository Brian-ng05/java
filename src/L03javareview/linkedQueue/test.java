package L03javareview.linkedQueue;

public class test {
    public static void main(String[] args){
    linkedQueueADT<Integer> myQueue = new linkedQueueADT<>();
    myQueue.offer(10);
    myQueue.offer(20);
    myQueue.offer(30);
    myQueue.offer(40);
        System.out.println(myQueue);
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.peek());
        myQueue.poll();
        System.out.println(myQueue);
    }
}
