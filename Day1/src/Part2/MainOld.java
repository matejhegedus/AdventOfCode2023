package Part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainOld {
    public static void main(String[] args) {
        int sum = 0;
        try (Scanner sc = new Scanner(new File("Day1/resources/inputTest.txt"))) {
            while(sc.hasNextLine()) {
                boolean hasFirstNum = false;
                boolean hasLastNum = false;
                char firstNum = 'n';
                char lastNum = 'n';
                String input = sc.nextLine();
                input = replaceSpelledNumbers(input);
//                System.out.println("reading line: " + input);
                for (int i = 0; i < input.length(); i++) {
                    if (Character.isDigit(input.charAt(i))) {
                        if (!hasFirstNum) {
                            firstNum = input.charAt(i);
                            hasFirstNum = true;
                        }
                        else {
                            lastNum = input.charAt(i);
                            hasLastNum = true;
                        }
                    }
                }
                if(hasFirstNum && !hasLastNum) {
                    lastNum = firstNum;
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

    static String replaceSpelledNumbers (String input) {
        String originalInput = input;
        String result = input;
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

        StringBuilder resultStringBuilder = new StringBuilder();
        for (int j = 0; j < result.length(); j++) {
            for (int i = 0; i < replaceString.length; i++) {
                String oldResult = result;
                result = result.replaceFirst("(?<=^.{" + j + "})" + replaceString[i], String.valueOf(replaceByChar[i]));
//                System.out.println(result);
                if (!result.equals(oldResult)) {
                    j = 0;
                }
            }
        }
        System.out.println("Before replacing:" + originalInput);
        System.out.println("After replacing: " + result);

        return result;
    }
}