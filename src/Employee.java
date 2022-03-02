public class Employee {
    private String firstName;
    private String lastName;
    private double yearlySalary;
    private int retirementPercent;
    private int age;

    public Employee() {
    }

    public Employee(String firstName, String lastName, double monthlySalary) {
        setFirstName(firstName);
        setLastName(lastName);
        setMonthlySalary(monthlySalary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return yearlySalary / 12;
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 0) {
            this.yearlySalary = monthlySalary * 12;
        }
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        if (yearlySalary > 0) {
            this.yearlySalary = yearlySalary;
        }
    }

    public int getRetirementPercent() {
        return retirementPercent;
    }

    public void setRetirementPercent(int retirementPercent) {
        if (retirementPercent >= 0 && retirementPercent <= 100) {
            this.retirementPercent = retirementPercent;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 120 && age >= 0) {
            this.age = age;
        }
    }

    private int getMaxRetirement() {
        if (age > 60) {
            return 500;
        } else {
            return 300;
        }
    }

    public double getInitialRetirementPayout() {
        // sets the initial retirement payout based on the percentage, up to the max
        return Math.min(getMonthlySalary() / 2 * (retirementPercent / 100.), getMaxRetirement());
    }

    public double getMatchedPayout() {
        // sets the amount the company matches to the minimum of:
        // - $100
        // - the amount already contributed
        // - the amount needed to meet the max
        return Math.min(Math.min(100, getInitialRetirementPayout()), getMaxRetirement() - getInitialRetirementPayout());
    }

    public double getRetirementPayout() {
        return getInitialRetirementPayout() + getMatchedPayout();
    }

    public double getPayout() {
        // finds the actual payout after retirement savings
        return getMonthlySalary() / 2 - (getInitialRetirementPayout() + getMatchedPayout());
    }

    public void payday() {
        payday(1);
    }

    public void payday(double periods) {
        System.out.printf("Payout: %.2f\n", getPayout() * periods);
        System.out.printf("Retirement (%.2f matched): %.2f\n",
                getMatchedPayout() * periods, (getInitialRetirementPayout() + getMatchedPayout()) * periods);
    }
}
