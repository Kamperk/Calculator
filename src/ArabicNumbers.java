class ArabicNumbers {
    public static void operations(String number1, String operand, String number2) {
        if ((Integer.parseInt(number1) <= 0) || (Integer.parseInt(number2) <= 0) || (Integer.parseInt(number1) > 10) ||
                (Integer.parseInt(number2) > 10))
            throw new IllegalArgumentException("Введенное число выходит за диапазон (0; 10]");
        else {
            switch (operand) {
                case ("+"): {
                    int b = Integer.parseInt(number1) + Integer.parseInt(number2);
                    System.out.println(b);
                    break;
                }
                case ("-"): {
                    int b = Integer.parseInt(number1) - Integer.parseInt(number2);
                    System.out.println((b));
                    break;
                }
                case ("/"): {
                    int b = Integer.parseInt(number1) / Integer.parseInt(number2);
                    System.out.println((b));
                    break;
                }
                case ("*"): {
                    int b = Integer.parseInt(number1) * Integer.parseInt(number2);
                    System.out.println((b));
                    break;
                }
                default:
                    System.out.println("Неверный операнд");
            }
        }
    }
}


