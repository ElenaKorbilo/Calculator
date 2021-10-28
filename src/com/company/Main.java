package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {
            Calculator calc = new Calculator();
            String number = "";
            int result = 0;

            try {
                Scanner scanner = new Scanner(System.in);
                number = scanner.nextLine();
                calc.firstNumber = Integer.parseInt(number);

                String operator = scanner.nextLine();
                if(!operator.equals("+") && !operator.equals("-") && !operator.equals("/") && !operator.equals("*")){
                    throw new RuntimeException("Ошибка! Ввод неизвестная операция.");
                }

                number = scanner.nextLine();
                calc.secondNumber = Integer.parseInt(number);

                switch (operator) {
                    case "+":
                        result = calc.add();
                        break;
                    case "-":
                        result = calc.takeAway();
                        break;
                    case "*":
                        result = calc.multiply();
                        break;
                    case "/":
                        result = calc.divide();
                        break;
                }

                System.out.println(result);

            } catch (ArithmeticException e) {
                System.out.println("Ошибка! Деление на 0 - запрещено");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Ввод нечисловое значение " + number);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
