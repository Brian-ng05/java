package L01javareview;

public class string {
    public static void main ( String[] args ) {
        int[] numbers = new int[7];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        int[] anotherNumbers = new int[numbers.length]; {
            for (int i = 0; i < numbers.length; i++)
                anotherNumbers[i] = numbers[i];
        }

        for (int i = 0; i < anotherNumbers.length; i++) {
            System.out.println(anotherNumbers[i]);
        }
    }
}

//        String[] cars = {"Volvo", "BMW", "Ford", "Mazda", "Mercedes", "Audi"};
//
//
//
//        for (int i = 0; i < cars.length; i++) {
//            System.out.println(cars[i]);
//
//        }
//    }
//}


