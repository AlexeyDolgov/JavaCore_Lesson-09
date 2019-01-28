/*
 * LOGOS IT Academy. First Java Core Console Application.
 */

package ua.lviv.lgs.task9_1;

import java.util.Scanner;

/**
 * @author Alexey Dolgov
 * @since Java 1.8
 * @version 1.1  28 Jan 2019
 */
public class Main {

	/* displays the application menu on the console */
	static void menu() {
		System.out.println();
		System.out.println("Введите 1, чтобы проверить существует ли введенный месяц");
		System.out.println("Введите 2, чтобы вывести все месяцы с такой же порой года");
		System.out.println("Введите 3, чтобы вывести все месяцы с таким же количеством дней");
		System.out.println("Введите 4, чтобы вывести все месяцы с меньшим количеством дней");
		System.out.println("Введите 5, чтобы вывести все месяцы с большим количеством дней");
		System.out.println("Введите 6, чтобы вывести следующую пору года");
		System.out.println("Введите 7, чтобы вывести предыдущую пору года");
		System.out.println("Введите 8, чтобы вывести все месяцы с четным количеством дней");
		System.out.println("Введите 9, чтобы вывести все месяцы с нечетным количеством дней");
		System.out.println("Введите 0, чтобы проверить четное ли количество дней в введенном месяце");
	}

	public static void main(String[] args) throws WrongInputConsoleParametersException {

		Scanner scanner = new Scanner(System.in);
		Months[] arrayMonths = Months.values();
		Seasons[] arraySeasons = Seasons.values();
		
		/* creates an infinite loop that calls the menu method */
		while (true) {
			menu();

			/* takes the values from the scanner and runs the corresponding case */
			switch (scanner.nextInt()) {

			case 1: {
				System.out.println("=== Программа проверки существования введенного месяца ===");
				System.out.println("Введите месяц:");
				String month1 = scanner.next();

				boolean flag = isMonthExists(arrayMonths, month1);

				if (flag == true) {
					System.out.println("Введенный месяц существует!");
				} else {
					String message = "Такого месяца нет!";
					throw new WrongInputConsoleParametersException(message);
				}
				
				break;
			}

			case 2: {
				System.out.println("=== Программа вывода всех месяцев с введенной порой года ===");
				System.out.println("Введите пору года:");
				String season2 = scanner.next();

				boolean flag = false;

				for (Months months : arrayMonths) {
					if (months.getSeason().name().equalsIgnoreCase(season2)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Пора года " + season2 + " в следующих месяцах:");

					for (Months months2 : arrayMonths) {
						if (months2.getSeason().toString().equalsIgnoreCase(season2)) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false) {
					String message = "Таких месяцев нет!";
					throw new WrongInputConsoleParametersException(message);
				}
				
				break;
			}

			case 3: {
				System.out.println("=== Программа вывода всех месяцев с введенным количеством дней ===");
				System.out.println("Введите количество дней:");
				int numberOfDays3 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayMonths) {
					if (months.getNumberOfDays() == numberOfDays3) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Количество дней " + numberOfDays3 + " в следующих месяцах:");

					for (Months months2 : arrayMonths) {
						if (months2.getNumberOfDays() == numberOfDays3) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false) {
					String message = "Таких месяцев нет!";
					throw new WrongInputConsoleParametersException(message);
				}
				
				break;
			}

			case 4: {
				System.out.println("=== Программа вывода всех месяцев с количеством дней меньше введенного ===");
				System.out.println("Введите количество дней:");
				int numberOfDays4 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayMonths) {
					if (months.getNumberOfDays() == numberOfDays4 && numberOfDays4 >= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Количество дней меньше " + numberOfDays4 + " в следующих месяцах:");

					for (Months months2 : arrayMonths) {
						if (months2.getNumberOfDays() < numberOfDays4) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false) {
					String message = "Таких месяцев нет!";
					throw new WrongInputConsoleParametersException(message);
				}
				break;
			}

			case 5: {
				System.out.println("=== Программа вывода всех месяцев с количеством дней больше введенного ===");
				System.out.println("Введите количество дней:");
				int numberOfDays5 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayMonths) {
					if (months.getNumberOfDays() == numberOfDays5 && numberOfDays5 <= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Количество дней больше " + numberOfDays5 + " в следующих месяцах:");

					for (Months months2 : arrayMonths) {
						if (months2.getNumberOfDays() > numberOfDays5) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false) {
					String message = "Таких месяцев нет!";
					throw new WrongInputConsoleParametersException(message);
				}
				
				break;
			}

			case 6: {
				System.out.println("=== Программа вывода следующей поры года ===");
				System.out.println("Введите пору года:");
				String season6 = scanner.next();

				boolean flag = false;

				for (Seasons seasons : arraySeasons) {
					if (seasons.name().equalsIgnoreCase(season6)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Следующая пора года:");

					Seasons seasons2 = Seasons.valueOf(firstUpperCase(season6.toLowerCase()));
					int i = seasons2.ordinal();

					if (i == (arraySeasons.length - 1)) {
						i = 0;
						System.out.println(arraySeasons[i]);
					} else {
						System.out.println(arraySeasons[i + 1]);
					}
				}

				if (flag == false) {
					String message = "Такой поры года нет!";
					throw new WrongInputConsoleParametersException(message);
				}
				
				break;
			}

			case 7: {
				System.out.println("=== Программа вывода предыдущей поры года ===");
				System.out.println("Введите пору года:");
				String season7 = scanner.next();

				boolean flag = false;

				for (Seasons seasons : arraySeasons) {
					if (seasons.name().equalsIgnoreCase(season7)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Предыдущая пора года:");

					Seasons seasons2 = Seasons.valueOf(firstUpperCase(season7.toLowerCase()));
					int i = seasons2.ordinal();

					if (i == 0) {
						i = (arraySeasons.length - 1);
						System.out.println(arraySeasons[i]);
					} else {
						System.out.println(arraySeasons[i - 1]);
					}
				}

				if (flag == false) {
					String message = "Такой поры года нет!";
					throw new WrongInputConsoleParametersException(message);
				}
				
				break;
			}

			case 8: {
				System.out.println("=== Программа вывода месяцев с четным количеством дней ===");

				for (Months months : arrayMonths) {
					if (months.getNumberOfDays() % 2 == 0) {
						System.out.println(months);
					}
				}

				break;
			}

			case 9: {
				System.out.println("=== Программа вывода месяцев с нечетным количеством дней ===");

				for (Months months : arrayMonths) {
					if (months.getNumberOfDays() % 2 != 0) {
						System.out.println(months);
					}
				}

				break;
			}

			case 0: {
				System.out.println("=== Программа проверки четности количества дней в введенном месяце ===");
				System.out.println("Введите месяц:");
				String month0 = scanner.next();

				boolean flag = isMonthExists(arrayMonths, month0);

				if (flag == true) {
					Months month = Months.valueOf(firstUpperCase(month0.toLowerCase()));

					if (month.getNumberOfDays() % 2 == 0) {
						System.out.println("Количество дней в месяце " + month0 + " - " + month.getNumberOfDays()
								+ ". Это число - четное");
					} else {
						System.out.println("Количество дней в месяце " + month0 + " - " + month.getNumberOfDays()
								+ ". Это число - нечетное");
					}
				}

				if (flag == false) {
					String message = "Такого месяца нет!";
					throw new WrongInputConsoleParametersException(message);
				}
				
				break;
			}

			default: {
				System.out.println("Введите число от 0 до 9!");

				break;
			}

			}
		}
	}

	/**
	 * Checks if the month exists in array and returns a boolean expression
	 * 
	 * @param arrayMonths, month
	 * 
	 * @return boolean expression
	 * 
	 */
	static boolean isMonthExists(Months[] arrayMonths, String month) {
		boolean flag = false;

		for (Months months : arrayMonths) {
			if (months.name().equalsIgnoreCase(month)) {
				flag = true;
			}
		}

		return flag;
	}

	/**
	 * Converts the first character of a string to upper case
	 * 
	 * @param string
	 * 
	 * @return String (with first letter in UpperCase) 
	 *  
	 */	
	static String firstUpperCase(String string) {
		if (string == null || string.isEmpty()) {
			return string;
		} else {
			return string.substring(0, 1).toUpperCase() + string.substring(1);
		}
	}

}
