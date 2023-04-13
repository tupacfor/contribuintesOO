package entities;

public class TaxPayer {
	
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	public TaxPayer() {
		
	}
	
	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {

		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		
		double monthSalary = salaryIncome / 12;
		
		if (monthSalary >= 5000.0) {
			return salaryIncome * 0.2;
		}
		else if (monthSalary >= 3000 && monthSalary < 5000) {
			return salaryIncome * 0.1;
		}
		else {
			return 0.0;
		}
	}
	
	public double servicesTax() {
		if (servicesIncome > 0) {
			return 0.15 * servicesIncome;
		}
		else {
			return 0;
		}
	}
	
	public double capitalTax() {
		if (capitalIncome > 0) {
			return 0.2 * capitalIncome;
		}
		else {
			return 0;
		}
	}
	
	public double grossTax() {
		
		return salaryTax() + servicesTax() + capitalTax();
		
	}
	
	public double taxRebate() {
		double totalSpending = healthSpending + educationSpending;
		
		if (totalSpending >= 0.3 * grossTax()) {
			double rebate = 0.3 * grossTax();
			return rebate;
		}
		else if (totalSpending >= 0 && totalSpending < 0.3 * grossTax()) {
			return totalSpending;
		}
		else {
			return 0.0;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
	
}
