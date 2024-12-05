public class SalaryCalculator {
    private int baseSalary = 1000;

    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped >= 5 ? 0.85 : 1.0;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >= 20 ? 13 : 10;
    }

    public double bonusForProductsSold(int productsSold) {
        return productsSold * this.bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double finalSalary = this.baseSalary * this.salaryMultiplier(daysSkipped) + this.bonusForProductsSold(productsSold);
        return finalSalary > 2000.0 ? 2000.0 : finalSalary;
    } 
}
