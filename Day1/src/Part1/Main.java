package Part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        try (Scanner sc = new Scanner(new File("Day1/resources/input.txt"))) {
            while(sc.hasNextLine()) {
                boolean hasFirstNum = false;
                boolean hasLastNum = false;
                char firstNum = 'n';
                char lastNum = 'n';
                String input = sc.nextLine();
                System.out.println("reading line: " + input);
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
}