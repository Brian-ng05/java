package L02javareview;

public class test {
    public static void main ( String[] args ) {
        ArrayListADT<Integer> myIntList = new ArrayListADT<>(); // <Integer>
        myIntList.add(10);
        myIntList.add(20);
        myIntList.add(30);
        myIntList.add(40);
        myIntList.add(50);

        ArrayListADT<String> myStringList = new ArrayListADT<>(); // <String>
        myStringList.add("Hello");
        myStringList.add("World");
        System.out.println(myIntList);
        System.out.println(myStringList);
        System.out.println(myIntList.size());
        System.out.println(myIntList.isEmpty());
        System.out.println(myIntList.contains(20));
        System.out.println(myIntList.contains(44));
        System.out.println(myIntList.indexOf(22));
        System.out.println(myStringList.indexOf("World"));
        System.out.println(myIntList.get(1));
        System.out.println(myIntList.set(1, 100));
        System.out.println(myIntList);
        System.out.println(myIntList.remove(2));
        System.out.println(myIntList);
        System.out.println(myIntList.remove(0));
        System.out.println(myIntList.remove(0));
        System.out.println(myIntList.remove(0));
        System.out.println(myIntList.remove(0));
        System.out.println(myIntList.isEmpty());
        myIntList.add(0,500);
        myIntList.add(1,100);
        myIntList.add(1, 200);
        System.out.println(myIntList);

    }
}
