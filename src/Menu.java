import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n0. Quit");
            System.out.println("1. Create Employee");

            int choice = getInt(0, 1);

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                createEmployee();
            }
        }
    }

    public static Employee createEmployee() {
        Employee newEmployee = new Employee();

        boolean running = true;
        while(running) {
            System.out.println("\n0. Return to main menu");
            System.out.println("1. Set salary (monthly format)");
            System.out.println("2. Set salary (yearly format)");
            System.out.println("3. Set age");
            System.out.println("4. Preview Payday Statement");
            System.out.println("5. Retirement Help");

            int choice = getInt(0, 5);

            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.print("Monthly salary");
                    double monthlySalary = getDouble(0);
                    newEmployee.setMonthlySalary(monthlySalary);
                    break;
                case 2:
                    System.out.print("Annual salary");
                    double yearlySalary = getDouble(0);
                    newEmployee.setYearlySalary(yearlySalary);
                    break;
                case 3:
                    System.out.print("Age");
                    int age = getInt(0, 120);
                    newEmployee.setAge(age);
                    break;
                case 4:
                    System.out.println();
                    newEmployee.payday();
                    break;
                case 5:
                    newEmployee = retirementHelp(newEmployee);
                    break;

                default:
                    break;
            }
        }

        return newEmployee;
    }

    public static Employee retirementHelp(Employee employee) {
        boolean running = true;
        while (running) {
            System.out.println("\n0. Return to previous menu");
            System.out.println("1. Set Retirement Percentage");
            System.out.println("2. View Retirement Scenarios");

            int choice = getInt(0, 2);

            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.print("Retirement percentage");
                    int retirementPercent = getInt(0, 100);
                    employee.setRetirementPercent(retirementPercent);
                    break;
                case 2:
                    int percent = employee.getRetirementPercent();
                    System.out.println("\n0% contribution, annual payout:");
                    employee.setRetirementPercent(0);
                    employee.payday(24);
                    System.out.printf("Savings by 65: %.2f\n",
                            compound(employee.getRetirementPayout() * 24, 2, 65 - employee.getAge()));

                    System.out.println("\n10% contribution, annual payout:");
                    employee.setRetirementPercent(10);
                    employee.payday(24);
                    System.out.printf("Savings by 65: %.2f\n",
                            compound(employee.getRetirementPayout() * 24, 2, 65 - employee.getAge()));

                    System.out.println("\n" + percent + "% (current) contribution, annual payout:");
                    employee.setRetirementPercent(percent);
                    employee.payday(24);
                    System.out.printf("Savings by 65: %.2f",
                            compound(employee.getRetirementPayout() * 24, 2, 65 - employee.getAge()));
                    System.out.println();

                    break;

                default:
                    break;
            }
        }

        return employee;
    }

    static double compound(double input, int interest, int periods) {
        double total = 0;
        for (int i = 0; i < periods; i++) {
            total += input;
            total *= 1 + interest / 100.;
        }
        // return 0 for negative periods/contributions/etc
        return Math.max(total, 0);
    }

    public static int getInt(int low, int high) {
        int input;
        do {
            System.out.print(": ");
            input = scanner.nextInt();
        } while (input < low || input > high);
        return input;
    }

    public static double getDouble(double low) {
        double input;
        do {
            System.out.print(": ");
            input = scanner.nextDouble();
        } while (input <= low);
        return input;
    }
}
