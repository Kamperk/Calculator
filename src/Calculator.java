import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите число в формате 1 + 1 / I + II");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] ar = input.split(" ");
        if (parse(input).equals("arab")){
            ArabicNumbers.operations(ar[0],ar[1],ar[2]);
            }
        else if(parse(input).equals("roman")){
            RomanNumbers.operations(ar[0],ar[1],ar[2]);
            }
        else{
            throw new IllegalArgumentException("Неверный формат ввода данных");
        }

        }

    public static String parse(String input) {
        String[] ar = input.split(" ");
        if((Character.isDigit(ar[0].charAt(0))) && (Character.isDigit(ar[2].charAt(0))))
            return "arab";
        else if(!(Character.isDigit(ar[0].charAt(0))) && !(Character.isDigit(ar[2].charAt(0))))
            return  "roman";
        else
            throw new IllegalArgumentException("Неверный формат ввода данных");
    }
}
