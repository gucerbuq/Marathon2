package Payroll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	private static List<Employees> list1;

	public static void employeeList() {

		list1 = new ArrayList<>();

		Employees employee1 = new Employees(LocalDate.of(2000, 10, 25), LocalDate.of(2022, 05, 03), "Bugra",
				EmployeeTypes.FULLTIME);
		Employees employee2 = new Employees(LocalDate.of(2007, 07, 22), LocalDate.of(2019, 02, 18), "Suleikha",
				EmployeeTypes.PARTTIME);
		Employees employee3 = new Employees(LocalDate.of(2002, 05, 07), LocalDate.of(2004, 12, 10), "Mehmet",
				EmployeeTypes.FULLTIME);
		Employees employee4 = new Employees(LocalDate.of(2009, 06, 13), LocalDate.of(2022, 07, 02), "Babur",
				EmployeeTypes.PARTTIME);
		Employees employee5 = new Employees(LocalDate.of(2004, 01, 30), LocalDate.of(2022, 03, 15), "Cagri",
				EmployeeTypes.FULLTIME);
		Employees employee6 = new Employees(LocalDate.of(2018, 10, 25), LocalDate.of(2012, 12, 31), "Ahmet",
				EmployeeTypes.FULLTIME);

		list1.add(employee1);
		list1.add(employee2);
		list1.add(employee3);
		list1.add(employee4);
		list1.add(employee5);
		list1.add(employee6);

		for (Employees employees : list1) {
			int count = list1.indexOf(employees) + 1;
			int id = count + employees.getEntryDate().getYear() * 1000;
			employees.setId(id);
		}
		
		

	}

	public static <E> void main(String[] args) {

		employeeList();
		Wages.main(args);
		
		
		Scanner sc = new Scanner(System.in);

		String menu = "1 - Create a personal list\n" + "2 - Show personal list\n"
				+ "3 - Monthly payments of personals\n" + "Quit (q)";

		while (true) {

			System.out.println(menu);
			System.out.println("What do you want to do?");
			String option = sc.nextLine();

			if (option.equals("q")) {

				System.out.println("Program is ending...");
				break;

			} else if (option.equals("1")) {

				System.out.println("I couldn't understand what to do with this one.");
//				System.out.println("Enter the name of the new list : ");
//				String name = sc.nextLine();
//				
//				List<E> name = new ArrayList<>();
//				
//				while (true) {
//				System.out.println("Enter the values you want to add to " + name + " list (q for quit) : ");
//				
//				if()
//				}
				

			} else if (option.equals("2")) {

				String menu2 = "1 - According to ID numbers \n" + "2 - According to name \n"
						+ "3 - According to date \n" + "b for main menu";

				while (true) {

					System.out.println(menu2);
					System.out.println("What do you want to do?");
					String option2 = sc.nextLine();

					if (option2.equals("b")) {

						System.out.println("Going back to main menu.");
						break;

					} else if (option2.equals("1")) {

						Collections.sort(list1, Comparator.comparingLong(Employees::getId));
						System.out.println(list1);

					} else if (option2.equals("2")) {

						Collections.sort(list1, Comparator.comparing(Employees::getName));
						System.out.println(list1);

					} else if (option2.equals("3")) {

						Collections.sort(list1);

						System.out.println(list1);

					} else {

						System.out.println("Please choose a valid option.");

					}
				}

			} else if (option.equals("3")) {

				System.out.println("Input the year you want to see : ");
				int yearPay = sc.nextInt();
				System.out.println("Input the month you want to see : ");
				int monthPay = sc.nextInt();
				sc.nextLine();

				List<Employees> filteredByYear = list1.stream()
						.filter(personal -> personal.getEntryDate().getYear() < yearPay
								&& personal.getExitDate().getYear() > yearPay)
						.collect(Collectors.toList());
				List<Employees> filteredByMonth = filteredByYear.stream()
						.filter(personal -> personal.getEntryDate().getMonthValue() < monthPay
								&& personal.getExitDate().getMonthValue() > monthPay)
						.collect(Collectors.toList());

				filteredByYear.stream().forEach(personal -> System.out.println(personal + " " + personal.getWage()));

				

			} else {

				System.out.println("Please choose a valid option.");

			}

		}
	}

	public static List<Employees> getList1() {

		employeeList();
		;
		return list1;
	}

	public static void setList1(List<Employees> list1) {
		Main.list1 = list1;
	}

}
