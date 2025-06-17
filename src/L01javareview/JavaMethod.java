package L01javareview;
import java.util.Scanner;

public class JavaMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Program starts.");
        greets(sc);
        int userAge = askUserAge(sc);
        validateAge(userAge);
        System.out.println("Program ends.");

        sc.close();
    }

    public static void greets(Scanner sc) {
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello " + name + ".");
    }

    public static int askUserAge(Scanner sc) {
        System.out.println("How old are you?");
        String ageString = sc.nextLine();
        int age = Integer.parseInt(ageString);
        return age;
    }

    public static void validateAge(int age) {
        if (age < 18) {
            System.out.println("Access denied - You are not old enough!");
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }
}

