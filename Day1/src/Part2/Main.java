package Part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        try (Scanner sc = new Scanner(new File("Day1/resources/input.txt"))) {
            while(sc.hasNextLine()) {
                char firstNum = 'n';
                char lastNum = 'n';
                String input = sc.nextLine();
                System.out.println("reading line: " + input);
                // find first number
                for (int i = 0; i < input.length(); i++) {

                    if (Character.isDigit(input.charAt(i))) {
                        firstNum = input.charAt(i);
                        break;
                    } else {
                        char spelledNum = returnSpelledNumberAtStartOfAString(input.substring(i));
                        if (Character.isDigit(spelledNum)) {
                            firstNum = spelledNum;
                            break;
                        }
                    }
                }
                // find last number
                for (int i = input.length()-1; i >= 0; i--) {
                    if (Character.isDigit(input.charAt(i))) {
                        lastNum = input.charAt(i);
                        break;
                    } else {
                        char spelledNum = returnSpelledNumberAtStartOfAString(input.substring(i));
                        if (Character.isDigit(spelledNum)) {
                            lastNum = spelledNum;
                            break;
                        }
                    }
                }
                System.out.println("first " + firstNum + ", last " + lastNum);
                String finalNumString = new StringBuilder().append(firstNum).append(lastNum).toString();
                int finalNumber = Integer.parseInt(finalNumString);
                System.out.println(finalNumber);
                sum += finalNumber;
            }
            System.out.println("Sum is " + sum);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static char returnSpelledNumberAtStartOfAString(String input){
        char result = 'n';
        String[] replaceString ={
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"};
        char[] replaceByChar ={
                '1',
                '2',
                '3',
                '4',
                '5',
                '6',
                '7',
                '8',
                '9'};
        for (int i = 0; i < replaceString.length; i++) {
            if(Pattern.compile("^" + replaceString[i]).matcher(input).find()) {
                result = replaceByChar[i];
            }
        }
        return result;
    }
}