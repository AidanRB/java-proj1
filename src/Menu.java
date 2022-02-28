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
                    System.out.println("Age");
                    int age = getInt(0, 120);
                    newEmployee.setAge(age);
                    break;
                case 4:
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
            System.out.println("0. Return to previous menu");
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
                    break;
            
                default:
                    break;
            }
        }
        
        return employee;
    }

    public static int getInt(int low, int high) {
        int input = low - 1;
        while (input < low || input > high) {
            System.out.print(": ");
            input = scanner.nextInt();
        }
        return input;
    }

    public static double getDouble(double low) {
        double input = low - 1;
        while (input <= low) {
            System.out.print(": ");
            input = scanner.nextDouble();
        }
        return input;
    }    
}
