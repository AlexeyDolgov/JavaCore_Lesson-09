package ua.lviv.lgs.task9_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws MyException {

		Scanner scanner = new Scanner(System.in);

		int a;
		int b;

		System.out.println("Введите первое целое число:");

		if (scanner.hasNextInt()) {
			a = scanner.nextInt();

			System.out.println("Введите второе целое число:");

			if (scanner.hasNextInt()) {
				b = scanner.nextInt();

				Methods calc = new Methods(a, b);

				Methods.viewCalcResult(calc.plus());
				Methods.viewCalcResult(calc.minus());
				Methods.viewCalcResult(calc.multiply());
				Methods.viewCalcResult(calc.devide());
			}

			else
				System.out.println("Ошибка! Необходимо было ввести ЦЕЛОЕ число");
		}

		else
			System.out.println("Ошибка! Необходимо было ввести ЦЕЛОЕ число");

	}
}
