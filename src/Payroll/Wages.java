package Payroll;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Wages {

	public static void main(String[] args) {
		
		double ftNetPayment = 15000;
		double ftInsurancePremium = ftNetPayment * 0.25;
		double ftMonthlyPayment = ftInsurancePremium + ftNetPayment;

		

		double ptNetPaymentPerHour = 150;
		double ptTaxRatio = ptNetPaymentPerHour * 0.08;
		double ptHourlyPayment = ptNetPaymentPerHour + ptTaxRatio;

		Random rand = new Random();
		int upperbound = 180;
		
		
		
		
		List<Employees> ptList = Main.getList1().stream()
				.filter(employee -> employee.getEmployeeType().equals(EmployeeTypes.PARTTIME)).toList();

		List<Employees> ftList = Main.getList1().stream()
				.filter(employee -> employee.getEmployeeType().equals(EmployeeTypes.FULLTIME)).toList();
		
		
		ftList.stream().forEach(personal -> personal.setWage(ftMonthlyPayment));
		
		ptList.stream().forEach(personal -> personal.setWage(rand.nextInt(upperbound) * ptHourlyPayment));
		
		for (Employees employees : Main.getList1()) {
			
			if(employees.getEmployeeType().equals(EmployeeTypes.FULLTIME)) {
				
				employees.setWage(ftMonthlyPayment);
				
			}else {
				
				employees.setWage(rand.nextInt(upperbound) * ptHourlyPayment);
				
			}
			
		}

		

	}

}
