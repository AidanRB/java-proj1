public class NewEmployeeHarness {
    public static void main(String[] args) {
        Employee employee = new Employee("Phil", "Swift", 9999999);
        System.out.printf("%.2f\n", employee.getYearlySalary());
        System.out.printf("%.2f\n", employee.getMonthlySalary());
        employee.setYearlySalary(12.12);
        System.out.printf("%.2f\n", employee.getYearlySalary());
        System.out.printf("%.2f\n", employee.getMonthlySalary());
        employee.setYearlySalary(50000);
        System.out.printf("%.2f\n", employee.getMonthlySalary());
        employee.setMonthlySalary(1000);
        System.out.printf("%.2f\n", employee.getYearlySalary());

        employee.payday();
        employee.setRetirementPercent(15);
        employee.payday();
        employee.setRetirementPercent(50);
        employee.payday();
        employee.setRetirementPercent(75);
        employee.payday();
        employee.setAge(70);
        employee.payday();
    }
}