public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "Cena", 1000000);
        Employee employee2 = new Employee("John", "Smith", 5000);

        System.out.printf("employee1: %.2f\n", employee1.getMonthlySalary() * 12);
        System.out.printf("employee2: %.2f\n", employee2.getMonthlySalary() * 12);

        employee1.setMonthlySalary(employee1.getMonthlySalary() * 1.1);
        employee2.setMonthlySalary(employee2.getMonthlySalary() * 1.1);

        System.out.printf("employee1: %.2f\n", employee1.getMonthlySalary() * 12);
        System.out.printf("employee2: %.2f\n", employee2.getMonthlySalary() * 12);
    }
}
