public class Employee {
    private String firstName;
    private String lastName;
    private double yearlySalary;
    private int retirementPercent;
    private int age;

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
        this.yearlySalary = yearlySalary;
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

    public void payday() {
        double totalPayout = getMonthlySalary() / 2;
        double maxRetirement = age>60 ? 500 : 300;
        double retirementPayout = Math.min(totalPayout * (retirementPercent / 100.), maxRetirement);
        double matchedPayout = Math.min(Math.min(100, retirementPayout), maxRetirement - retirementPayout);
        double payoutPayout = totalPayout - retirementPayout;

        System.out.printf("Payout: %.2f\n", payoutPayout);
        System.out.printf("Max: %.2f\n", maxRetirement);
        System.out.printf("Retirement: %.2f\n", retirementPayout);
        System.out.printf("Matched: %.2f\n", matchedPayout);
    }
}
