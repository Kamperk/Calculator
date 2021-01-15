import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumbers {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100);

    private int value;

    RomanNumbers(int value) {
        this.value = value;
    }

    public static List<RomanNumbers> getReverseSortedValues() {
        return Arrays.stream(values()).sorted(Comparator.comparing((RomanNumbers e) -> e.value)
                .reversed()).collect(Collectors.toList());
    }

    public static int romanToArab(String input) {
        int result = 0;
        List<RomanNumbers> romanNumbers = RomanNumbers.getReverseSortedValues();
        int i = 0;
        while ((input.length() > 0) && (i < romanNumbers.size())) {
            RomanNumbers symbol = romanNumbers.get(i);
            if (input.startsWith(symbol.name())) {
                result += symbol.value;
                input = input.substring(symbol.name().length());
            } else
                i++;
        }
        if (input.length() > 0)
            throw new IllegalArgumentException(input + "cannot be converted to Roman numeral");
        return result;
    }

    public static String arabToRoman(int a) {
        if ((a <= 0) || (a > 4000)) {
            throw new IllegalArgumentException(a + " is not in range (0; 4000]");
        }
        List<RomanNumbers> romanNumeral = RomanNumbers.getReverseSortedValues();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while ((a > 0) && (i < romanNumeral.size())) {
            RomanNumbers current = romanNumeral.get(i);
            if (current.value <= a) {
                sb.append(current.name());
                a -= current.value;
            } else
                i++;
        }
        return sb.toString();
    }
    public static String sample (String input){
        String[] numbers = input.split(" ");
        if((Character.isDigit(numbers[0].charAt(0))) && (Character.isDigit(numbers[2].charAt(0)))){
            return ArabicNumbers.calculate(numbers[0], numbers[1], numbers[2]);
        }
        else if(!(Character.isDigit(numbers[0].charAt(0))) && !(Character.isDigit(numbers[2].charAt(0))))
            return arabToRoman(Integer.parseInt(ArabicNumbers.calculate(String.valueOf(romanToArab(numbers[0])),
                    numbers[1], String.valueOf(romanToArab(numbers[2])))));
        else
            throw new IllegalArgumentException("Неверный формат ввода данных");
    }
}
