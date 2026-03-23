package utils;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String message) {
        System.out.print(message);
        int value = Integer.parseInt(scanner.nextLine());
        return value;
    }

    public static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static double readDouble(String message) {
        System.out.print(message);
        double value = Double.parseDouble(scanner.nextLine());
        return value;
    }
}