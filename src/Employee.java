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
        double maxRetirement;
        if (age > 60) {
            maxRetirement = 500;
        } else {
            maxRetirement = 300;
        }
        // sets the initial retirement payout based on the percentage, up to the max
        double retirementPayout = Math.min(totalPayout * (retirementPercent / 100.), maxRetirement);
        // sets the amount the company matches to the minimum of:
        // - $100
        // - the amount already contributed
        // - the amount needed to meet the max
        double matchedPayout = Math.min(Math.min(100, retirementPayout), maxRetirement - retirementPayout);
        // finds the actual payout ater retirement savings
        double payoutPayout = totalPayout - retirementPayout;

        System.out.printf("Payout: %.2f\n", payoutPayout);
        System.out.printf("Max: %.2f\n", maxRetirement);
        System.out.printf("Retirement: %.2f\n", retirementPayout);
        System.out.printf("Matched: %.2f\n", matchedPayout);
    }
}
