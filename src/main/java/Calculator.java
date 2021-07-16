import java.util.Scanner;

public class Calculator {
    // Operation, first number, second number are separated by a space.
    public static void main(String[] args) throws ZeroDivideException, IncorrectArgsCount, IncorrectOperator {
        String operation;
        Object number1, number2;
        if (args.length != 0) {
            if (args.length != 3) {
                throw new IncorrectArgsCount("There should be 3 arguments: operation, first number, second number.");
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
                throw new IncorrectOperator("Operation \"" + operation + "\" wasn't recognized." +
                        "\nYou need to use: \"+\", \"-\", \"*\", \"/\"");
        }
    }

    private static double parse(Object in) {
        double number;
        try {
            number = Double.parseDouble(in.toString());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Parsing exception. " + e.getMessage());
        }
        return number;
    }

    public static double add(Object in1, Object in2) {
        double number1 = parse(in1),
                number2 = parse(in2);
        double result = number1 + number2;
        System.out.println(number1 + " + " + number2 + " = " + result);
        return result;
    }

    public static double sub(Object in1, Object in2) {
        double number1 = parse(in1),
                number2 = parse(in2);
        double result = number1 - number2;
        System.out.println(number1 + " - " + number2 + " = " + result);
        return result;
    }

    public static double mul(Object in1, Object in2) {
        double number1 = parse(in1),
                number2 = parse(in2);
        double result = number1 * number2;
        System.out.println(number1 + " * " + number2 + " = " + result);
        return result;
    }

    public static double div(Object in1, Object in2) throws ZeroDivideException {
        double number1 = parse(in1),
                number2 = parse(in2);
        if (number2 == 0.d) {
            throw new ZeroDivideException("Zero divide exception.");
        }
        double result = number1 / number2;
        System.out.println(number1 + " / " + number2 + " = " + result);
        return result;
    }
}
