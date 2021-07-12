import java.util.Scanner;

public class Calculator {
    // Operation, first number, second number are separated by a space.
    public static void main(String[] args) throws ZeroDivideException {
        String operation;
        Object number1, number2;
        if (args.length != 0) {
            if (args.length != 3) {
                System.out.println("There should be 3 arguments: operation, first number, second number.");
                return;
            }
            operation = args[0];
            number1 = args[1];
            number2 = args[2];
        }
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Operation: ");
            operation = scanner.nextLine();
            System.out.print("First number: ");
            number1 = scanner.nextLine();
            System.out.print("Second number: ");
            number2 = scanner.nextLine();
        }

        switch (operation) {
            case "+":
                add(number1, number2);
                break;
            case "-":
                sub(number1, number2);
                break;
            case "*":
                mul(number1, number2);
                break;
            case "/":
                div(number1, number2);
                break;
            default:
                System.out.println("Operation wasn't recognized." +
                        "\nYou need to use: \"+\", \"-\", \"*\", \"/\"");
        }
    }

    private static Object parse(Object in) {
        double number;
        try {
            number = Double.parseDouble(in.toString());
        } catch (NumberFormatException e) {
            System.out.println("Parsing exception. " + e.getMessage());
            return null;
        }
        return number;
    }

    public static double add(Object in1, Object in2) {
        Object number1 = parse(in1),
                number2 = parse(in2);
        if (number1 == null || number2 == null)
            return 0;
        double result = (double)number1 + (double)number2;
        System.out.println(number1 + " + " + number2 + " = " + result);
        return result;
    }

    public static double sub(Object in1, Object in2) {
        Object number1 = parse(in1),
                number2 = parse(in2);
        if (number1 == null || number2 == null)
            return 0;
        double result = (double)number1 - (double)number2;
        System.out.println(number1 + " - " + number2 + " = " + result);
        return result;
    }

    public static double mul(Object in1, Object in2) {
        Object number1 = parse(in1),
                number2 = parse(in2);
        if (number1 == null || number2 == null)
            return 0;
        double result = (double)number1 * (double)number2;
        System.out.println(number1 + " * " + number2 + " = " + result);
        return result;
    }

    public static double div(Object in1, Object in2) throws ZeroDivideException {
        Object number1 = parse(in1),
                number2 = parse(in2);
        if (number1 == null || number2 == null)
            return 0;
        if ((double)number2 == 0.d) {
            throw new ZeroDivideException("Zero divide exception.");
        }
        double result = (double)number1 / (double)number2;
        System.out.println(number1 + " / " + number2 + " = " + result);
        return result;
    }
}
