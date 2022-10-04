package Payroll;

import java.time.LocalDate;

public class Employees implements Comparable<Employees> {

	private int id;
	private LocalDate entryDate;
	private LocalDate exitDate;
	private String name;
	private double wage;
	private EmployeeTypes employeeType ;


	

	public Employees(LocalDate entryDate, LocalDate exitDate, String name, EmployeeTypes employeeType) {
		super();
		
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.name = name;
		this.wage = wage;
		this.employeeType = employeeType;
		this.id = id;
	}
	

	public EmployeeTypes getEmployeeType() {
		return employeeType;
	}


	public void setEmployeeType(EmployeeTypes employeeType) {
		this.employeeType = employeeType;
	}


	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getExitDate() {
		return exitDate;
	}

	public void setExitDate(LocalDate exitDate) {
		this.exitDate = exitDate;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((Employees) obj).getName().equals(getName());
	}
	
	@Override
	public int compareTo(Employees employee) {
		// TODO Auto-generated method stub
		return getEntryDate().compareTo(employee.getEntryDate());
	}
	
	
	
	

}
